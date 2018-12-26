package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Livro;
import org.gov.service.LivroService;
import org.gov.service.LivroServiceImpl;
import org.primefaces.event.SelectEvent;

public class LivroBean extends Controller  {

	/**
	 *
	 */
	private static final long serialVersionUID = -7849970183863861263L;

	private Livro livro;
	private LivroService livroService;
	private List<org.gov.model.Livro> livros;


	public LivroBean() {

		livro = new Livro();
		this.livros = new ArrayList<org.gov.model.Livro>();
		this.livroService = new LivroServiceImpl();

		livros();
	}


	public String gravar() {

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
		limparForm();
		return eval(index());
	}

	public String telaEditar(Livro livro) {

		this.livro = livro;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {

		livroService.editar(livro);
		livros();

		return eval(index());
	}

	public String deletar(org.gov.model.Livro livro) {

		livroService.remover(livro.getId());
		livros();
		return eval(index());
	}

	 private void limparForm() {
		this.livro.setId(0);
		this.livro.setTitulo(null);
		this.livro.setPreco(0);
		this.livro.setData(null);
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
