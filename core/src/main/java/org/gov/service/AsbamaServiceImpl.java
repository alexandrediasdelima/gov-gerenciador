package org.gov.service;

import org.gov.dao.AsbamaDao;
import org.gov.dao.AsbamaDaoImpl;
import org.gov.model.Asbama;


public class AsbamaServiceImpl implements AsbamaService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AsbamaDao asbamaDao;


	public String gravar(Asbama asbama) {

		asbamaDao = new AsbamaDaoImpl();
		return asbamaDao.gravar(asbama);
	}


	public Asbama pesquisar(int id) {

		asbamaDao = new AsbamaDaoImpl();
		return asbamaDao.pesquisar(id);
	}


	public String editar(Asbama asbama) {
		return asbamaDao.editar(asbama);
	}

	public String remover(Integer id) {
		asbamaDao = new AsbamaDaoImpl();
		return asbamaDao.remover(id);
	}


}
