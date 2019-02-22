package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Irrigacao;

public interface IrrigacaoDao extends Serializable {

	public String gravar(Irrigacao irrigacao);
	public Irrigacao pesquisar(int id);
	public String remover(Integer id);
	public String editar(Irrigacao irrigacao);

}
