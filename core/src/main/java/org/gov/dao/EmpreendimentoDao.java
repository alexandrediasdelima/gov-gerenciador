package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Empreendimento;

public interface EmpreendimentoDao extends Serializable {

	public String gravar(Empreendimento empreendimento);
	public List<Empreendimento> empreendimentos();
	public String remover(Integer id);
	public String editar(Empreendimento empreendimento);
	public List<Integer> ids();


}
