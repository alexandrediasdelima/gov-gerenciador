package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Livro;

public interface LivroDao extends Serializable {

	public String gravar(Livro livro);
	public List<Livro> livros();

}
