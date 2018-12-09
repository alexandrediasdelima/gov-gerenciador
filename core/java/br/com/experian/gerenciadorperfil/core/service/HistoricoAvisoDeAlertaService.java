package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoAvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoAvisoDeAlertaFilter;

public interface HistoricoAvisoDeAlertaService extends Service<HistoricoAvisoDeAlerta, Long, HistoricoAvisoDeAlertaFilter> {

	List<HistoricoAvisoDeAlerta> listarPorProduto(Produto produto);
	
	Integer removerPorProduto(Produto produto);
	
}