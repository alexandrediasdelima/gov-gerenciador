package org.gov.service;

import java.io.Serializable;

import org.gov.model.Captacao;

public interface CaptacaoService extends Serializable {

	public String gravar(Captacao captacao);
	public Captacao pesquisar(int id);
	public String remover(Integer id);
	public String editar(Captacao captacao);

}
