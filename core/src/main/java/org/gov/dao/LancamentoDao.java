package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Lancamento;

public interface LancamentoDao extends Serializable {

	public String gravar(Lancamento irrigacao);
	public Lancamento pesquisar(int id);
	public String remover(Integer id);
	public String editar(Lancamento irrigacao);

}
