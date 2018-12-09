package br.com.experian.gerenciadorperfil.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoCaronaFeatureFilter;

@Component
public class DocumentoCaronaFeatureDAOImpl extends AbstractDAO<DocumentoCaronaFeature, Long, DocumentoCaronaFeatureFilter> implements DocumentoCaronaFeatureDAO {


	public DocumentoCaronaFeatureDAOImpl() {
		super(DocumentoCaronaFeature.class, DocumentoCaronaFeatureFilter.class);
	}

	private static final String QUERY = "SELECT d FROM DocumentoCaronaFeature d";
	
	private static final String DELETE = "DELETE FROM DocumentoCaronaFeature d";

	public void adicionar(final List<DocumentoCaronaFeature> documentos) {
		
		Session session = (Session) getEntityManager().getDelegate();
		session.doWork(new Work() {
			
			public void execute(Connection connection) throws SQLException {
				
				int contador = DocumentoCaronaFeatureDAO.BULK_STATEMENT_SIZE;
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PC_GEP_DOC_CAMPANHA_DESC (PK_PC_GEP_DOC_CAMPANHA_DESC, DS_CNPJ, FK_PC_GEP_CAMPANHA_DESC, DS_LOGON) VALUES (SEQ_PC_GEP_DOC_CAMPANHA_DESC.NEXTVAL, ?, ?, ?)");
				for (DocumentoCaronaFeature documento : documentos) {
					preparedStatement.setString(1, documento.getCnpj());
					preparedStatement.setLong(2, documento.getCaronaFeature().getId());
					preparedStatement.setString(3, documento.getLogin());
					preparedStatement.addBatch();
					if (contador > 1) {
						contador--;
					} else {
						preparedStatement.executeBatch();
						contador = DocumentoCaronaFeatureDAO.BULK_STATEMENT_SIZE;
					}
				}
				if (contador != DocumentoCaronaFeatureDAO.BULK_STATEMENT_SIZE) {
					preparedStatement.executeBatch();
				}
			}
		});
	}

	// QUERY CRIADA SEM FILTER POR QUESTOES DE OTIMIZACAO
	@SuppressWarnings("unchecked")
	public List<DocumentoCaronaFeature> buscarComAceiteSemCancelamento(Feature feature, List<String> cnpjs,  List<String> logons) {
		
		
		String QUERY = "SELECT NEW DocumentoCaronaFeature(d.id, d.cnpj, d.login, d.caronaFeature.id, d.caronaFeature.nome, d.caronaFeature.dataInicio, d.caronaFeature.dataFim)"
							+ " FROM DocumentoCaronaFeature d " +
							 "WHERE d.cnpj IN (:cnpjs) AND d.caronaFeature.feature.id = :feature AND " +
							 "EXISTS (SELECT r.id FROM RespostaCaronaFeature r WHERE r.documentoCaronaFeature.id = d.id AND r.resposta = 'S') AND " +
							 "NOT EXISTS (SELECT c.id FROM CancelamentoCaronaFeature c WHERE c.documentoCaronaFeature.id = d.id)";
		
		//INC1709536 - Efetuar o bloqueio por CNPJ + Logon que possui a feature ativa.
		if(logons!=null && !logons.isEmpty()) {
			QUERY = QUERY + " AND d.login IN (:logons)";
		}
		
		Session session = (Session) getEntityManager().getDelegate();
		org.hibernate.Query q = session.createQuery(QUERY);
		
		q.setParameter("feature", feature.getId());
		q.setParameterList("cnpjs", cnpjs);
		
		if(logons!=null && !logons.isEmpty()) {
			q.setParameterList("logons", logons);
		}
		
		return q.list();
	}
	
	
	@SuppressWarnings("unchecked")//
	public List<DocumentoCaronaFeature> listarDocumentosCienciaPendente(List<String> cnpjs, String produto) {
		final String QUERY = "SELECT NEW DocumentoCaronaFeature(d.id, d.cnpj, d.caronaFeature.id, d.caronaFeature.nome, d.caronaFeature.dataInicio, d.caronaFeature.dataFim)"
						     +" FROM DocumentoCaronaFeature d left join d.respostasCaronaFeature r left join r.cienciaCaronaFeaturesOptout ci"  
							 +" WHERE d.cnpj IN (:cnpjs) AND d.caronaFeature.status = 3 AND d.caronaFeature.tipoOferta = 'O' AND (trunc(d.caronaFeature.dataFim) < trunc(sysdate())) "
						     +" AND ci.id is null AND d.caronaFeature.feature.produto.nome = :produto"
							 +" AND NOT	EXISTS (SELECT c.id FROM CancelamentoCaronaFeature c WHERE c.documentoCaronaFeature.id = d.id)";
							 
		
		Session session = (Session) getEntityManager().getDelegate();
		org.hibernate.Query q = session.createQuery(QUERY);		
		q.setParameterList("cnpjs", cnpjs);
		q.setParameter("produto", produto);
		
		return q.list();
	}
	
	@Override
	protected void applyFilter(Query query, DocumentoCaronaFeatureFilter documentoFilter) {

		super.applyFilter(query, documentoFilter);

		if (documentoFilter.getIdCaronaFeatureEquals() != null) {
			query.setParameter(DocumentoCaronaFeatureFilter.ID_CAMPANHA_DESCONTO_EQUALS, documentoFilter.getIdCaronaFeatureEquals());
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			query.setParameter(DocumentoCaronaFeatureFilter.CNPJ_LIKE_BOTH, "%" + documentoFilter.getCnpjLikeBoth() + "%");
		}
	}

	@Override
	protected String createSqlQuery(DocumentoCaronaFeatureFilter documentoFilter) {

		StringBuilder sql = new StringBuilder(QUERY);

		List<String> wheres = new ArrayList<String>();

		if (documentoFilter.getIdCaronaFeatureEquals() != null) {
			wheres.add("d.caronaFeature.id = :" + DocumentoCaronaFeatureFilter.ID_CAMPANHA_DESCONTO_EQUALS);
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			wheres.add("d.cnpj LIKE :" + DocumentoCaronaFeatureFilter.CNPJ_LIKE_BOTH);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected String createSqlDelete(DocumentoCaronaFeatureFilter documentoFilter) {

		StringBuilder sql = new StringBuilder(DELETE);

		List<String> wheres = new ArrayList<String>();

		if (documentoFilter.getIdCaronaFeatureEquals() != null) {
			wheres.add("d.caronaFeature.id = :" + DocumentoCaronaFeatureFilter.ID_CAMPANHA_DESCONTO_EQUALS);
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			wheres.add("d.cnpj = :" + DocumentoCaronaFeatureFilter.CNPJ_LIKE_BOTH);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	

}
