package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Vazao;

public interface VazaoDao extends Serializable {

	public String gravar(Vazao irrigacao);
	public Vazao pesquisar(int id);
	public String remover(Integer id);
	public String editar(Vazao irrigacao);

}
