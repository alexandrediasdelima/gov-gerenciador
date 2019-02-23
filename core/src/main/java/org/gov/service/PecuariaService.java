package org.gov.service;

import java.io.Serializable;

import org.gov.model.Pecuaria;

public interface PecuariaService extends Serializable {

	public String gravar(Pecuaria pecuaria);
	public Pecuaria pesquisar(int id);
	public String remover(Integer id);
	public String editar(Pecuaria pecuaria);

}
