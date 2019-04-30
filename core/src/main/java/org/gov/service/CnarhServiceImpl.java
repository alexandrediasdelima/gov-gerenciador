package org.gov.service;

import java.util.List;

import org.gov.dao.CnarhDao;
import org.gov.dao.CnarhDaoImpl;
import org.gov.dao.UsuarioDaoImpl;
import org.gov.model.Cnarh;
import org.gov.model.Usuario;


public class CnarhServiceImpl implements CnarhService{



	//private LivroDao livroDao;

	private CnarhDao cnarhDao;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Cnarh cnarh) {

		cnarhDao = new CnarhDaoImpl();
		return cnarhDao.gravar(cnarh);
	}

	public List<Cnarh> cnarhs() {
		cnarhDao = new CnarhDaoImpl();
		return cnarhDao.cnarhs();
	}

	public String remover(String id) {
		cnarhDao = new CnarhDaoImpl();
		return cnarhDao.remover(id);
	}

	public String editar(Cnarh cnarh) {

		cnarhDao = new CnarhDaoImpl();
		return cnarhDao.editar(cnarh);
	}

	public Cnarh pesquisar(String id) {
		cnarhDao = new CnarhDaoImpl();
		return cnarhDao.pesquisar(id);
	}
}
