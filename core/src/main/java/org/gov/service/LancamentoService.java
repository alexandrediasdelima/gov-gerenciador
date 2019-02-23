package org.gov.service;

import java.io.Serializable;

import org.gov.model.Lancamento;

public interface LancamentoService extends Serializable {

	public String gravar(Lancamento lancamento);
	public Lancamento pesquisar(int id);
	public String remover(Integer id);
	public String editar(Lancamento lancamento);

}
