package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface FeatureService extends Service<Feature, Integer, FeatureFilter> {

	List<Feature> obterPorProduto(Produto produto);

	List<Feature> obterFeaturesNaoAssociadoPorProduto(Produto produto);

	List<Feature> obterFeatureEspelho(Integer pkPrincipal);

	FeatureDesconto obterFeatureDesconto(Feature feature) throws GerenciadorPerfilServiceException;
	
}
