package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.service.LivroService;
import org.gov.service.LivroServiceImpl;
import org.gov.web.model.Livro;
import org.primefaces.event.SelectEvent;

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

	public String telaEditar(org.gov.model.Livro livro) {

		this.livro.setTitulo(livro.getTitulo());
		this.livro.setDataLancamento(livro.getData());
		this.livro.setPreco(livro.getPreco());

		setView(EDIT);

		return eval(index());
	}

	public String editar() {

		org.gov.model.Livro livro = new org.gov.model.Livro();

		livro.setTitulo(this.livro.getTitulo());
		livro.setData(this.livro.getDataLancamento());
		livro.setPreco(this.livro.getPreco());

		livroService.gravar(livro);
		limparForm();
		livros();

		return eval(index());
	}

	public String deletar(org.gov.model.Livro livro) {


		livros();

		return eval(index());
	}

	 private void limparForm() {
		this.livro.setTitulo(null);
		this.livro.setPreco(0);
		this.livro.setDataLancamento(null);
	}

	public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
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
