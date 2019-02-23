package org.gov.service;

import org.gov.dao.VazaoDao;
import org.gov.dao.VazaoDaoImpl;
import org.gov.model.Vazao;


public class VazaoServiceImpl implements VazaoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private VazaoDao vazaoDao;


	public String gravar(Vazao vazao) {

		vazaoDao = new VazaoDaoImpl();
		return vazaoDao.gravar(vazao);
	}


	public Vazao pesquisar(int id) {

		vazaoDao = new VazaoDaoImpl();
		return vazaoDao.pesquisar(id);
	}


	public String editar(Vazao vazao) {
		return vazaoDao.editar(vazao);
	}

	public String remover(Integer id) {
		vazaoDao = new VazaoDaoImpl();
		return vazaoDao.remover(id);
	}


}
