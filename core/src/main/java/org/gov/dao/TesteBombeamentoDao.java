package org.gov.dao;

import java.io.Serializable;

import org.gov.model.TesteBombeamento;

public interface TesteBombeamentoDao extends Serializable {

	public String gravar(TesteBombeamento irrigacao);
	public TesteBombeamento pesquisar(int id);
	public String remover(Integer id);
	public String editar(TesteBombeamento irrigacao);

}
