package org.gov.service;

import java.util.List;

import org.gov.dao.ApacDao;
import org.gov.dao.ApacDaoImpl;
import org.gov.model.Apac;


public class ApacServiceImpl implements ApacService{


	private ApacDao apacDao;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Apac apac) {

		apacDao = new ApacDaoImpl();
		return apacDao.gravar(apac);
	}

	public List<Apac> apacs() {
		apacDao = new ApacDaoImpl();
		return apacDao.apacs();
	}

	public String remover(String id) {
		apacDao = new ApacDaoImpl();
		return apacDao.remover(id);
	}

	public String editar(Apac apac) {

		apacDao = new ApacDaoImpl();
		return apacDao.editar(apac);
	}

}
