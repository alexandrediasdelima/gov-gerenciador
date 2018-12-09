package org.gov.web.controller;

import java.io.Serializable;
import java.util.List;

import org.gov.service.AutorService;
import org.gov.service.LivroService;
import org.gov.service.LivroServiceImpl;
import org.gov.web.model.Autor;
import org.gov.web.model.Livro;

public class LivroBean implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -8848447789491900839L;

	private Livro livro = new Livro();
	private Autor autor = new Autor();

	private LivroService livroService;
	private AutorService autorService;


	public String gravar() {

		livroService = new LivroServiceImpl();

		return"index.xhtml";
	}

	public List<Autor> getAutores() {

		return null;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
