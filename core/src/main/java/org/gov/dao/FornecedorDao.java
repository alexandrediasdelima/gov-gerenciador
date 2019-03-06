package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Fornecedor;

public interface FornecedorDao extends Serializable {

	public String gravar(Fornecedor fornecedor);
	public List<Fornecedor> fornecedores();
	public String remover(Integer id);
	public String editar(Fornecedor fornecedor);
	public List<Integer> ids();


}
