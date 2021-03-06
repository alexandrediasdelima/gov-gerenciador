package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Fornecedor;
import org.gov.model.OutraInfo;

public interface FornecedorService extends Serializable {

	public String gravar(Fornecedor fornecedor);
	public List<Fornecedor> fornecedores();
	public String remover(Integer id);
	public String editar(Fornecedor fornecedor);
	public List<Integer> ids();
	public Fornecedor pesquisar(int id);
}
