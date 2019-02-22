package org.gov.service;

import java.io.Serializable;

import org.gov.model.Industria;

public interface IndustriaService extends Serializable {

	public String gravar(Industria industria);
	public Industria pesquisar(int id);
	public String remover(Integer id);
	public String editar(Industria industria);

}
