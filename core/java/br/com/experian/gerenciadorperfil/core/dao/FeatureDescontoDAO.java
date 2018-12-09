package br.com.experian.gerenciadorperfil.core.dao;

import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureDescontoFilter;

public interface FeatureDescontoDAO extends DAO<FeatureDesconto, Integer, FeatureDescontoFilter> {

	FeatureDesconto obterPorTransacaoMaisFeature(String transacao, Integer id);

	FeatureDesconto obterPorFeature(Feature feature);
	
	void salvar(FeatureDesconto feature);

}
