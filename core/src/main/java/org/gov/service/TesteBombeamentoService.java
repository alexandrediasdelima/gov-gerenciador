package org.gov.service;

import java.io.Serializable;

import org.gov.model.TesteBombeamento;

public interface TesteBombeamentoService extends Serializable {

	public String gravar(TesteBombeamento testeBombeamento);
	public TesteBombeamento pesquisar(int id);
	public String remover(Integer id);
	public String editar(TesteBombeamento testeBombeamento);

}
