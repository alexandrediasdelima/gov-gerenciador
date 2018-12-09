package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoAvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoAvisoDeAlertaFilter;

@Component
public class HistoricoAvisoDeAlertaDAOImpl extends AbstractDAO<HistoricoAvisoDeAlerta, Long, HistoricoAvisoDeAlertaFilter> implements HistoricoAvisoDeAlertaDAO {

	private static final String SELECT = "SELECT h FROM HistoricoAvisoDeAlerta h";
	
	private static final String DELETE = "DELETE FROM HistoricoAvisoDeAlerta h";

	public HistoricoAvisoDeAlertaDAOImpl() {
		super(HistoricoAvisoDeAlerta.class, HistoricoAvisoDeAlertaFilter.class);
	}

	@Override
	protected String createSqlQuery(HistoricoAvisoDeAlertaFilter historicoAvisoDeAlertaFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> where = new ArrayList<String>();

		if (historicoAvisoDeAlertaFilter.getIdProdutoEquals() != null) {
			where.add("h.produtoHistorico.id = :" + HistoricoAvisoDeAlertaFilter.ID_PRODUTO_EQUALS);
		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		return sql.toString();
	}
	
	@Override
	protected String createSqlDelete(HistoricoAvisoDeAlertaFilter historicoAvisoDeAlertaFilter) {
		StringBuilder sql = new StringBuilder(DELETE);

		List<String> where = new ArrayList<String>();

		if (historicoAvisoDeAlertaFilter.getIdProdutoEquals() != null) {
			where.add("h.produtoHistorico.id = :" + HistoricoAvisoDeAlertaFilter.ID_PRODUTO_EQUALS);
		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected void applyFilter(Query query, HistoricoAvisoDeAlertaFilter historicoAvisoDeAlertaFilter) {

		super.applyFilter(query, historicoAvisoDeAlertaFilter);

		if (historicoAvisoDeAlertaFilter.getIdProdutoEquals() != null) {
			query.setParameter(HistoricoAvisoDeAlertaFilter.ID_PRODUTO_EQUALS, historicoAvisoDeAlertaFilter.getIdProdutoEquals());
		}
	}
}
