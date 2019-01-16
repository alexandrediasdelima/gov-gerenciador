package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Apac;

public interface ApacDao extends Serializable {

	public String gravar(Apac apac);
	public List<Apac> apacs();
	public String remover(String id);
	public String editar(Apac apac);

}
