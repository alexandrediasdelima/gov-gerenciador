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

import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoFilter;

@Component
public class DocumentoDAOImpl extends AbstractDAO<Documento, Long, DocumentoFilter> implements DocumentoDAO {


	public DocumentoDAOImpl() {
		super(Documento.class, DocumentoFilter.class);
	}

	private static final String QUERY = "SELECT d FROM Documento d";

	private static final String DELETE = "DELETE FROM Documento d";

	public void adicionar(final List<Documento> documentos) {
		Session session = (Session) getEntityManager().getDelegate();
		session.doWork(new Work() {
			public void execute(Connection connection) throws SQLException {
				int contador = DocumentoDAO.BULK_STATEMENT_SIZE;
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PC_GEP_DOCUMENTO (PK_PC_GEP_DOCUMENTO, DS_CNPJ, FK_PC_GEP_CAMPANHA, DS_LOGON) VALUES (SEQ_PC_GEP_DOCUMENTO.NEXTVAL, ?, ?, ?)");
				for (Documento documento : documentos) {
					preparedStatement.setString(1, documento.getCnpj());
					preparedStatement.setLong(2, documento.getCampanhaGratuidade().getId());
					preparedStatement.setString(3, documento.getLogin());
					preparedStatement.addBatch();
					if (contador > 1) {
						contador--;
					} else {
						preparedStatement.executeBatch();
						contador = DocumentoDAO.BULK_STATEMENT_SIZE;
					}
				}
				if (contador != DocumentoDAO.BULK_STATEMENT_SIZE) {
					preparedStatement.executeBatch();
				}
			}
		});
	}

	@Override
	protected void applyFilter(Query query, DocumentoFilter documentoFilter) {

		super.applyFilter(query, documentoFilter);

		if (documentoFilter.getIdCampanhaGratuidadeEquals() != null) {
			query.setParameter(DocumentoFilter.ID_CAMPANHA_GRATUIDADE_EQUALS, documentoFilter.getIdCampanhaGratuidadeEquals());
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			query.setParameter(DocumentoFilter.CNPJ_LIKE_BOTH, "%" + documentoFilter.getCnpjLikeBoth() + "%");
		}
	}

	@Override
	protected String createSqlQuery(DocumentoFilter documentoFilter) {

		StringBuilder sql = new StringBuilder(QUERY);

		List<String> wheres = new ArrayList<String>();

		if (documentoFilter.getIdCampanhaGratuidadeEquals() != null) {
			wheres.add("d.campanhaGratuidade.id = :" + DocumentoFilter.ID_CAMPANHA_GRATUIDADE_EQUALS);
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			wheres.add("d.cnpj LIKE :" + DocumentoFilter.CNPJ_LIKE_BOTH);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected String createSqlDelete(DocumentoFilter documentoFilter) {

		StringBuilder sql = new StringBuilder(DELETE);

		List<String> wheres = new ArrayList<String>();

		if (documentoFilter.getIdCampanhaGratuidadeEquals() != null) {
			wheres.add("d.campanhaGratuidade.id = :" + DocumentoFilter.ID_CAMPANHA_GRATUIDADE_EQUALS);
		}

		if (documentoFilter.getCnpjLikeBoth() != null) {
			wheres.add("d.cnpj = :" + DocumentoFilter.CNPJ_LIKE_BOTH);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}
}
