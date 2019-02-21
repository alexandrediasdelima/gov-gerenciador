package org.gov.service;

import org.gov.dao.CaptacaoDao;
import org.gov.dao.CaptacaoDaoImpl;
import org.gov.model.Captacao;


public class CaptacaoServiceImpl implements CaptacaoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CaptacaoDao captacaoDao;


	public String gravar(Captacao captacao) {

		captacaoDao = new CaptacaoDaoImpl();
		return captacaoDao.gravar(captacao);
	}


	public Captacao pesquisar(int id) {

		captacaoDao = new CaptacaoDaoImpl();
		return captacaoDao.pesquisar(id);
	}


	public String editar(Captacao captacao) {
		return captacaoDao.editar(captacao);
	}

	public String remover(Integer id) {
		captacaoDao = new CaptacaoDaoImpl();
		return captacaoDao.remover(id);
	}


}
