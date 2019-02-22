package org.gov.service;

import org.gov.dao.IndustriaDao;
import org.gov.dao.IndustriaDaoImpl;
import org.gov.model.Industria;


public class IndustriaServiceImpl implements IndustriaService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private IndustriaDao industriaDao;


	public String gravar(Industria industria) {

		industriaDao = new IndustriaDaoImpl();
		return industriaDao.gravar(industria);
	}


	public Industria pesquisar(int id) {

		industriaDao = new IndustriaDaoImpl();
		return industriaDao.pesquisar(id);
	}


	public String editar(Industria industria) {
		return industriaDao.editar(industria);
	}

	public String remover(Integer id) {
		industriaDao = new IndustriaDaoImpl();
		return industriaDao.remover(id);
	}


}
