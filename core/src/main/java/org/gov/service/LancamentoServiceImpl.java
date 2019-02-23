package org.gov.service;

import org.gov.dao.LancamentoDao;
import org.gov.dao.LancamentoDaoImpl;
import org.gov.model.Lancamento;


public class LancamentoServiceImpl implements LancamentoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private LancamentoDao lancamentoDao;


	public String gravar(Lancamento lancamento) {

		lancamentoDao = new LancamentoDaoImpl();
		return lancamentoDao.gravar(lancamento);
	}


	public Lancamento pesquisar(int id) {

		lancamentoDao = new LancamentoDaoImpl();
		return lancamentoDao.pesquisar(id);
	}


	public String editar(Lancamento lancamento) {
		return lancamentoDao.editar(lancamento);
	}

	public String remover(Integer id) {
		lancamentoDao = new LancamentoDaoImpl();
		return lancamentoDao.remover(id);
	}


}
