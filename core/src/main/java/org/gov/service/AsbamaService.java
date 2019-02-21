package org.gov.service;

import java.io.Serializable;

import org.gov.model.Asbama;

public interface AsbamaService extends Serializable {

	public String gravar(Asbama asbama);
	public Asbama pesquisar(int id);
	public String remover(Integer id);
	public String editar(Asbama asbama);

}
