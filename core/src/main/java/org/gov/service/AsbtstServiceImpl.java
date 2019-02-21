package org.gov.service;

import org.gov.dao.AsbtstDao;
import org.gov.dao.AsbtstDaoImpl;
import org.gov.model.Asbtst;


public class AsbtstServiceImpl implements AsbtstService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AsbtstDao asbtstDao;


	public String gravar(Asbtst asbtst) {

		asbtstDao = new AsbtstDaoImpl();
		return asbtstDao.gravar(asbtst);
	}


	public Asbtst pesquisar(int id) {

		asbtstDao = new AsbtstDaoImpl();
		return asbtstDao.pesquisar(id);
	}


	public String editar(Asbtst asbtst) {
		return asbtstDao.editar(asbtst);
	}

	public String remover(Integer id) {
		asbtstDao = new AsbtstDaoImpl();
		return asbtstDao.remover(id);
	}


}
