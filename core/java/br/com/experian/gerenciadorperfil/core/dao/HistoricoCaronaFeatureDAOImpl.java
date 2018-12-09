package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoCaronaFeatureFilter;

@Component
public class HistoricoCaronaFeatureDAOImpl extends AbstractDAO<HistoricoCaronaFeature, Integer, HistoricoCaronaFeatureFilter> implements HistoricoCaronaFeatureDAO {

	private static final String QUERY = "SELECT h from HistoricoCaronaFeature h";

	public HistoricoCaronaFeatureDAOImpl() {
		super(HistoricoCaronaFeature.class, HistoricoCaronaFeatureFilter.class);
	}

	@Override
	protected void applyFilter(Query query, HistoricoCaronaFeatureFilter caronaFeatureFilter) {
		super.applyFilter(query, caronaFeatureFilter);
		
		if (caronaFeatureFilter.getIdCaronaFeatureEquals() != null) {
			query.setParameter(HistoricoCaronaFeatureFilter.ID_CARONA_FEATURE_EQUALS, caronaFeatureFilter.getIdCaronaFeatureEquals());
		}
		
		if (caronaFeatureFilter.getStatusCaronaFeatureEquals() != null) {
			query.setParameter(HistoricoCaronaFeatureFilter.STATUS_CARONA_FEATURE_EQUALS, caronaFeatureFilter.getStatusCaronaFeatureEquals());
		}
	}
	
	public List<HistoricoCaronaFeature> carregarHistoricoCaronaFeatureStatus(Long idCaronaFeature, Integer statusCaronaFeature) {
		
		HistoricoCaronaFeatureFilter historicoCaronaFeatureFilter = new HistoricoCaronaFeatureFilter();
		
		historicoCaronaFeatureFilter.setIdCaronaFeatureEquals(idCaronaFeature);
		historicoCaronaFeatureFilter.setStatusCaronaFeatureEquals(statusCaronaFeature);
		
		return this.listar(historicoCaronaFeatureFilter);
	}

	@Override
	protected String createSqlQuery(HistoricoCaronaFeatureFilter caronaFeatureFilter) {
		
		StringBuilder sql = new StringBuilder(QUERY);
		
		List<String> wheres = new ArrayList<String>();
		
		if (caronaFeatureFilter.getIdCaronaFeatureEquals() != null) {
			wheres.add("h.caronaFeatureHistorico.id = :" + HistoricoCaronaFeatureFilter.ID_CARONA_FEATURE_EQUALS);
		}
		
		if (caronaFeatureFilter.getStatusCaronaFeatureEquals() != null) {
			wheres.add("h.statusHistorico = :" + HistoricoCaronaFeatureFilter.STATUS_CARONA_FEATURE_EQUALS);
		}
		
		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}
		
		return sql.toString();
	}
}
