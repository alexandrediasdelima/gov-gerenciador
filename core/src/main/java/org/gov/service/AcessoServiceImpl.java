package org.gov.service;

import org.gov.dao.AcessoDao;
import org.gov.dao.AcessoDaoImpl;
import org.gov.model.Acesso;


public class AcessoServiceImpl implements AcessoService{

	/**
	 *
	 */
	private static final long serialVersionUID = 8814755819598169756L;

	private AcessoDao acessoDao;

	public boolean verificarAcesso(Acesso acesso) {

		acessoDao = new AcessoDaoImpl();

		return acessoDao.verificarAcesso(acesso);


	}



}
