package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Apac;
import org.gov.model.Interferencia;

public interface InterferenciaDao extends Serializable {

	public String gravar(Interferencia interferencia);
//	public List<Apac> apacs();
//	public String remover(String id);
//	public String editar(Apac apac);

}
