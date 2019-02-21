package org.gov.service;

import java.io.Serializable;

import org.gov.model.Asbtst;

public interface AsbtstService extends Serializable {

	public String gravar(Asbtst asbtst);
	public Asbtst pesquisar(int id);
	public String remover(Integer id);
	public String editar(Asbtst asbtst);

}
