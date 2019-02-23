package org.gov.service;

import org.gov.dao.PecuariaDao;
import org.gov.dao.PecuariaDaoImpl;
import org.gov.model.Pecuaria;


public class PecuariaServiceImpl implements PecuariaService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private PecuariaDao lancamentoDao;


	public String gravar(Pecuaria lancamento) {

		lancamentoDao = new PecuariaDaoImpl();
		return lancamentoDao.gravar(lancamento);
	}


	public Pecuaria pesquisar(int id) {

		lancamentoDao = new PecuariaDaoImpl();
		return lancamentoDao.pesquisar(id);
	}


	public String editar(Pecuaria lancamento) {
		return lancamentoDao.editar(lancamento);
	}

	public String remover(Integer id) {
		lancamentoDao = new PecuariaDaoImpl();
		return lancamentoDao.remover(id);
	}


}
