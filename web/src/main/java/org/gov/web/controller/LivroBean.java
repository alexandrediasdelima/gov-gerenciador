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

	private Livro livroForm = new Livro();
	private Autor autor = new Autor();

	private LivroService livroService;
	private AutorService autorService;


	public String gravar() {


		org.gov.model.Livro livro = new org.gov.model.Livro();

		livro.setTitulo(getLivroForm().getTitulo());
		livro.setData(getLivroForm().getDataLancamento());
		livro.setPreco(getLivroForm().getPreco());

		livroService = new LivroServiceImpl();

		livroService.gravar(livro);



		return"index.xhtml";
	}

	public List<Autor> getAutores() {

		return null;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Livro getLivroForm() {
		return livroForm;
	}

	public void setLivroForm(Livro livroForm) {
		this.livroForm = livroForm;
	}

}
