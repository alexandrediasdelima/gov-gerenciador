package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Pecuaria;

public interface PecuariaDao extends Serializable {

	public String gravar(Pecuaria irrigacao);
	public Pecuaria pesquisar(int id);
	public String remover(Integer id);
	public String editar(Pecuaria irrigacao);

}
