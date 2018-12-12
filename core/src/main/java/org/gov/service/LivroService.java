package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Livro;

public interface LivroService extends Serializable {

	public String gravar(Livro livro);
	public List<Livro> livros();

}
