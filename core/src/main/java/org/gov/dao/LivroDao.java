package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Livro;

public interface LivroDao extends Serializable {

	public String gravar(Livro livro);

}
