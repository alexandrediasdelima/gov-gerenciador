package org.gov.service;

import java.util.List;

import org.gov.dao.InterferenciaDao;
import org.gov.dao.InterferenciaDaoImpl;
import org.gov.model.Interferencia;


public class InterferenciaServiceImpl implements InterferenciaService{

	private InterferenciaDao interferenciaDao;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Interferencia interferencia) {

		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.gravar(interferencia);
	}

	public List<Interferencia> interferencias() {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.interferencias();
	}

	public String remover(Integer id) {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.remover(id);
	}

	public String editar(Interferencia interferencia) {

		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.editar(interferencia);
	}
	
	
	
//	public String gravar(Interferencia interferencia) {
//
//		interferenciaDao = new InterferenciaDaoImpl();
//		return interferenciaDao.gravar(interferencia);
//	}

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

}
