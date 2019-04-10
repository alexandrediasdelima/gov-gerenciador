package org.gov.service;

import java.util.List;

import org.gov.dao.FornecedorDao;
import org.gov.dao.FornecedorDaoImpl;
import org.gov.dao.OutraInfoDaoImpl;
import org.gov.dao.UsuarioDaoImpl;
import org.gov.model.Fornecedor;
import org.gov.model.OutraInfo;


public class FornecedorServiceImpl implements FornecedorService{

	/**
	 *
	 */
	private static final long serialVersionUID = -5803732226558628525L;

	private FornecedorDao fornecedorDao;

	public String gravar(Fornecedor fornecedor) {

		fornecedorDao = new FornecedorDaoImpl();
		fornecedorDao.gravar(fornecedor);

		return "ok";
	}

	public List<Fornecedor> fornecedores() {

		fornecedorDao = new FornecedorDaoImpl();
		return fornecedorDao.fornecedores();
	}

	public String remover(Integer id) {
		fornecedorDao = new FornecedorDaoImpl();
		return fornecedorDao.remover(id);
	}

	public String editar(Fornecedor fornecedor) {
		fornecedorDao = new FornecedorDaoImpl();
		return fornecedorDao.editar(fornecedor);
	}

	public List<Integer> ids() {
		fornecedorDao = new FornecedorDaoImpl();
		return fornecedorDao.ids();
	}

	public Fornecedor pesquisar(int id) {
		fornecedorDao = new FornecedorDaoImpl();
		return fornecedorDao.pesquisar(id);
	}

}
