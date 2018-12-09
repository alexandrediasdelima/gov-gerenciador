package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.HistoricoAvisoDeAlertaDAO;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.HistoricoAvisoDeAlertaFilter;

@Service
public class HistoricoAvisoDeAlertaServiceImpl extends AbstractService<HistoricoAvisoDeAlerta, Long, HistoricoAvisoDeAlertaFilter, HistoricoAvisoDeAlertaDAO> implements HistoricoAvisoDeAlertaService {

	@Autowired
	public HistoricoAvisoDeAlertaServiceImpl(HistoricoAvisoDeAlertaDAO historicoAvisoDeAlertaDAO) {
		super(historicoAvisoDeAlertaDAO);
	}

	public List<HistoricoAvisoDeAlerta> listarPorProduto(Produto produto) {
		HistoricoAvisoDeAlertaFilter historicoAvisoDeAlertaFilter = new HistoricoAvisoDeAlertaFilter()
		.setIdProdutoEquals(produto.getId());

		return listar(historicoAvisoDeAlertaFilter);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer removerPorProduto(Produto produto) {
		HistoricoAvisoDeAlertaFilter historicoAvisoDeAlertaFilter = new HistoricoAvisoDeAlertaFilter()
		.setIdProdutoEquals(produto.getId());
		return getDao().remover(historicoAvisoDeAlertaFilter);
	}
}
