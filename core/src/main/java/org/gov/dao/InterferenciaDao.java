package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Apac;
import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;

public interface InterferenciaDao extends Serializable {

	public String gravar(Interferencia interferencia);
	public List<Interferencia> interferencias();
	public String remover(Integer id);
	public String editar(Interferencia interferencia);
	public List<Cnarh> cnarhs();
	public List<Apac> processos();
	public List<Empreendimento> empreendimentos();

}
