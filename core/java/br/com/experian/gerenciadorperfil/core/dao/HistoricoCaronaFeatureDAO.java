package br.com.experian.gerenciadorperfil.core.dao;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoCaronaFeatureFilter;

public interface HistoricoCaronaFeatureDAO extends DAO<HistoricoCaronaFeature, Integer, HistoricoCaronaFeatureFilter> {

	List<HistoricoCaronaFeature> carregarHistoricoCaronaFeatureStatus(Long idCaronaFeature, Integer statusCaronaFeature);
	
}
