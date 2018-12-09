package br.com.experian.gerenciadorperfil.core.service;

import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureDescontoFilter;

public interface FeatureDescontoService extends Service<FeatureDesconto, Integer, FeatureDescontoFilter> {

	void salvar(FeatureDesconto feature);
	
}
