package org.gov.service;

import java.io.Serializable;

import org.gov.model.Livro;

public interface LivroService extends Serializable {

	public String gravar(Livro livro);

}
