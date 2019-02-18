package org.gov.service;

import org.gov.dao.AsbcaracDao;
import org.gov.dao.AsbcaracDaoImpl;
import org.gov.model.Asbcarac;


public class AsbcaracServiceImpl implements AsbcaracService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AsbcaracDao asbcaracDao;


	public String gravar(Asbcarac asbcarac) {

		asbcaracDao = new AsbcaracDaoImpl();
		asbcaracDao.gravar(asbcarac);
		//
		return null;
	}


	public Asbcarac pesquisar(int id) {

		asbcaracDao = new AsbcaracDaoImpl();
		return asbcaracDao.pesquisar(id);
	}


	public String editar(Asbcarac asbcarac) {

		asbcaracDao.editar(asbcarac);

		return null;
	}

	public String remover(Integer id) {
		asbcaracDao = new AsbcaracDaoImpl();
		return asbcaracDao.remover(id);
	}


}
