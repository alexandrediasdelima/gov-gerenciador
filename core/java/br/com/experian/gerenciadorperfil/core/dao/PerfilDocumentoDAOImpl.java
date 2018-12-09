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

import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilDocumentoFilter;

@Component
public class PerfilDocumentoDAOImpl extends AbstractDAO<PerfilDocumento, Long, PerfilDocumentoFilter> implements PerfilDocumentoDAO {

	private static final String SELECT = "SELECT p from PerfilDocumento p ";

	private static final String DELETE = "DELETE from PerfilDocumento p ";

	public PerfilDocumentoDAOImpl() {
		super(PerfilDocumento.class, PerfilDocumentoFilter.class);
	}


	public void adicionar(final List<PerfilDocumento> documentos) {
		Session session = (Session) getEntityManager().getDelegate();
		session.doWork(new Work() {
			public void execute(Connection connection) throws SQLException {
				int contador = DocumentoDAO.BULK_STATEMENT_SIZE;
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PC_GEP_PERFIL_DOCUMENTO (PK_PC_GEP_PERFIL_DOCUMENTO, DS_CNPJ, FK_PC_GEP_PERFIL) VALUES (SEQ_PC_GEP_PERFIL_DOCUMENTO.NEXTVAL, ?, ?)");
				for (PerfilDocumento documento : documentos) {
					preparedStatement.setString(1, documento.getCnpj());
					preparedStatement.setLong(2, documento.getPerfil().getId());
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
	protected void applyFilter(Query query, PerfilDocumentoFilter perfilFilter) {

		super.applyFilter(query, perfilFilter);

		if (perfilFilter.getIdPerfilEquals() != null) {
			query.setParameter(PerfilDocumentoFilter.ID_PERFIL_EQUALS, perfilFilter.getIdPerfilEquals());
		}
		if (StringUtils.isNotBlank(perfilFilter.getContainsDocumentoCnpj())) {
			query.setParameter(PerfilDocumentoFilter.CONTAINS_DOCUMENTO_CNPJ, perfilFilter.getContainsDocumentoCnpj());
		}

		if (perfilFilter.getIdPerfilInSubSelect() != null) {
			query.setParameter(PerfilDocumentoFilter.ID_PERFIL_IN_SUBSELECT, perfilFilter.getIdPerfilInSubSelect());
		}

		if (perfilFilter.getIdPerfilIn() != null) {
			query.setParameter(PerfilDocumentoFilter.ID_PERFIL_IN, perfilFilter.getIdPerfilIn());
		}


	}

	@Override
	protected String createSqlQuery(PerfilDocumentoFilter perfilFilter) {

		String baseSql = SELECT;

		StringBuilder sql = new StringBuilder(baseSql);

		List<String> wheres = new ArrayList<String>();

		if (perfilFilter.getIdPerfilEquals() != null) {
			wheres.add("p.perfil.id = :" + PerfilDocumentoFilter.ID_PERFIL_EQUALS);
		}

		if (StringUtils.isNotBlank(perfilFilter.getContainsDocumentoCnpj())) {
			wheres.add("p.cnpj = :" + PerfilDocumentoFilter.CONTAINS_DOCUMENTO_CNPJ);
		}


		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected String createSqlDelete(PerfilDocumentoFilter perfilFilter) {

		String baseSql = DELETE;

		StringBuilder sql = new StringBuilder(baseSql);
		List<String> wheres = new ArrayList<String>();

		if (perfilFilter.getIdPerfilEquals() != null) {
			wheres.add("p.perfil.id = :" + PerfilDocumentoFilter.ID_PERFIL_EQUALS);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected String createSqlGrouped(PerfilDocumentoFilter perfilFilter) {

		String sql =
				" SELECT P FROM PerfilDocumento P WHERE P.cnpj IN "+
						" (SELECT P1.cnpj FROM PerfilDocumento P1 "+
						" WHERE P1.perfil.id IN (:"+PerfilDocumentoFilter.ID_PERFIL_IN_SUBSELECT+") "+
						" GROUP BY P1.cnpj "+
						" HAVING COUNT(*) > 1) "+
				" AND P.perfil.id IN (:"+PerfilDocumentoFilter.ID_PERFIL_IN+") " +
				" ORDER BY P.cnpj, P.perfil.id ";

		return sql.toString();
	}
}
