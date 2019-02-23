package org.gov.service;

import org.gov.dao.TesteBombeamentoDao;
import org.gov.dao.TesteBombeamentoDaoImpl;
import org.gov.model.TesteBombeamento;


public class TesteBombeamentoServiceImpl implements TesteBombeamentoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TesteBombeamentoDao testeBombeamentoDao;


	public String gravar(TesteBombeamento testeBombeamento) {

		testeBombeamentoDao = new TesteBombeamentoDaoImpl();
		return testeBombeamentoDao.gravar(testeBombeamento);
	}


	public TesteBombeamento pesquisar(int id) {

		testeBombeamentoDao = new TesteBombeamentoDaoImpl();
		return testeBombeamentoDao.pesquisar(id);
	}


	public String editar(TesteBombeamento testeBombeamento) {
		return testeBombeamentoDao.editar(testeBombeamento);
	}

	public String remover(Integer id) {
		testeBombeamentoDao = new TesteBombeamentoDaoImpl();
		return testeBombeamentoDao.remover(id);
	}


}
