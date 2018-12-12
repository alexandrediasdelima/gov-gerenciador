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

	public LivroBean() {

		livro = new Livro();
		this.livros = new ArrayList<org.gov.model.Livro>();
		this.livroService = new LivroServiceImpl();

		livros();
	}

	private Livro livro;
	private LivroService livroService;
	private List<org.gov.model.Livro> livros;


	public String gravar() {

		org.gov.model.Livro livro = new org.gov.model.Livro();

		livro.setTitulo(this.livro.getTitulo());
		livro.setData(this.livro.getDataLancamento());
		livro.setPreco(this.livro.getPreco());

		livroService.gravar(livro);
		livros();

		return eval(index());
	}

	public String livros() {

		setLivros(livroService.livros());
		setView(LIST);
		return eval(index());

	}

	public String adicionarBtnNovoLivro() {
		setView(ADD);
		return eval(index());
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
