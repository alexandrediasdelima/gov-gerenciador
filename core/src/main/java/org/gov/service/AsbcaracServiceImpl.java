package org.gov.service;

import org.gov.dao.AsbcaracDao;
import org.gov.dao.AsbcaracDaoImpl;
import org.gov.model.Asbcarac;


public class AsbcaracServiceImpl implements AsbcaracService{



	//private LivroDao livroDao;

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

//	public List<Apac> apacs() {
//		apacDao = new ApacDaoImpl();
//		return apacDao.apacs();
//	}
//
//	public String remover(String id) {
//		apacDao = new ApacDaoImpl();
//		return apacDao.remover(id);
//	}
//
//	public String editar(Apac apac) {
//
//		apacDao = new ApacDaoImpl();
//		return apacDao.editar(apac);
//	}
//
//	public AsbcaracDao getAsbcaracDao() {
//		return asbcaracDao;
//	}
//
//	public void setAsbcaracDao(AsbcaracDao asbcaracDao) {
//		this.asbcaracDao = asbcaracDao;
//	}

}
