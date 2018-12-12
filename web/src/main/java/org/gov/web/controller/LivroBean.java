package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.service.LivroService;
import org.gov.service.LivroServiceImpl;
import org.gov.web.model.Livro;

public class LivroBean extends Controller  {

	/**
	 *
	 */
	private static final long serialVersionUID = -7849970183863861263L;

	private Livro livro = new Livro();
	private LivroService livroService;
	private List<org.gov.model.Livro> livros;

	private String view;


	public String gravar() {

		org.gov.model.Livro livro = new org.gov.model.Livro();

		livro.setTitulo(this.livro.getTitulo());
		livro.setData(this.livro.getDataLancamento());
		livro.setPreco(this.livro.getPreco());

		livroService = new LivroServiceImpl();

		livroService.gravar(livro);
		livros();

		return eval(index());
	}

	public String livros() {

		this.livros = new ArrayList<org.gov.model.Livro>();

		setLivros(livroService.livros());

		return eval(index());

	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public List<org.gov.model.Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<org.gov.model.Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public String index() {
		return "/exemplo/index";
	}

}
