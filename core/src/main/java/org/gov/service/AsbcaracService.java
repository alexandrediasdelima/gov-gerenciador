package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Apac;
import org.gov.model.Asbcarac;

public interface AsbcaracService extends Serializable {

	public String gravar(Asbcarac asbcarac);
	public Asbcarac pesquisar(int id);
//	public List<Apac> apacs();
//	public String remover(String id);
//	public String editar(Apac apac);

}
