package br.com.experian.gerenciadorperfil.core.dao;

import java.util.List;

import br.com.experian.commons.strings.gm53.bean.ProtocoloGM53;
import br.com.experian.commons.strings.gm53.bean.RetornoGM53;
import br.com.experian.commons.strings.gm53.exception.GM53Exception;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureFilter;

public interface FeatureDAO extends DAO<Feature, Integer, FeatureFilter> {

	Feature obterPorTransacaoEmProduto(String transacao, Produto produto);

	Feature obterPorNomeEmProduto(String nome, Produto produto);

	List<Feature> obterFeatureEspelho(Integer pkPrincipal);
	
	RetornoGM53 obterFeatureDesconto(ProtocoloGM53 protocoloEnvio) throws GM53Exception;
	
}
