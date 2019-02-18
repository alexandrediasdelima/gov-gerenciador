package org.gov.service;

import java.io.Serializable;

import org.gov.model.Asbcarac;

public interface AsbcaracService extends Serializable {

	public String gravar(Asbcarac asbcarac);
	public Asbcarac pesquisar(int id);
	public String remover(Integer id);
	public String editar(Asbcarac asbcarac);

}
