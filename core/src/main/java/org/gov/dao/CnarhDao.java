package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Cnarh;
import org.gov.model.Usuario;

public interface CnarhDao extends Serializable {

	public String gravar(Cnarh cnarh);
	public List<Cnarh> cnarhs();
	public String remover(String id);
	public String editar(Cnarh apac);
	public Cnarh pesquisar(String id);

}
