package br.com.experian.gerenciadorperfil.core.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoOferta;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoOfertaFilter;

@Component
public class HistoricoOfertaDAOImpl extends AbstractDAO<HistoricoOferta, Integer, HistoricoOfertaFilter> implements HistoricoOfertaDAO {

	private static final String SELECT = "SELECT o from HistoricoOferta o ";

	public HistoricoOfertaDAOImpl() {
		super(HistoricoOferta.class, HistoricoOfertaFilter.class);
	}

	@Override
	protected void applyFilter(Query query, HistoricoOfertaFilter ofertaFilter) {
		super.applyFilter(query, ofertaFilter);
	}

	@Override
	protected String createSqlQuery(HistoricoOfertaFilter ofertaFilter) {
		StringBuilder sql = new StringBuilder(SELECT);
		return sql.toString();
	}
}
