package org.gov.service;

import java.io.Serializable;

import org.gov.model.Vazao;

public interface VazaoService extends Serializable {

	public String gravar(Vazao vazao);
	public Vazao pesquisar(int id);
	public String remover(Integer id);
	public String editar(Vazao vazao);

}
