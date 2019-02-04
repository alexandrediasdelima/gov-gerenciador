package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Cnarh;

public interface CnarhService extends Serializable {

	public String gravar(Cnarh cnarh);
	public List<Cnarh> cnarhs();
	public String remover(String id);
	public String editar(Cnarh cnarh);

}
