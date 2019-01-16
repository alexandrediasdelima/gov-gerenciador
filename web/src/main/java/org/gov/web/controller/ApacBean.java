package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Apac;
import org.gov.service.ApacService;
import org.gov.service.ApacServiceImpl;
import org.primefaces.event.SelectEvent;

public class ApacBean extends Controller  {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	private Apac apac;
	private ApacService apacService;
	private List<Apac> apacs;


	public ApacBean() {

		setApac(new Apac());
		apacService = new ApacServiceImpl();
		apacs = new ArrayList<Apac>();
		apacs();
	}


	public String gravar() {

		apacService.gravar(apac);
		apacs();

		return eval(index());
	}

	public String apacs() {

		apacs = apacService.apacs();
		setView(LIST);
		return eval(index());

	}

	public String adicionarBtnNovoApac() {
		setView(ADD);
		limparForm();
		return eval(index());
	}

	public String telaEditar(Apac apac) {

		this.apac = apac;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {

		apacService.editar(apac);
		apacs();

		return eval(index());
	}

	public String deletar(Apac apac) {

		apacService.remover(apac.getNumeroProcesso());
		apacs();
		return eval(index());
	}

	 private void limparForm() {

		 this.apac.setAnalistaResponsavel(null);
		 this.apac.setAtoAdministrativoPublicacaoInstrumento("null");

	}

	public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }


	public String index() {
		return "/apac/index";
	}


	public Apac getApac() {
		return apac;
	}


	public void setApac(Apac apac) {
		this.apac = apac;
	}


	public List<Apac> getApacs() {
		return apacs;
	}


	public void setApacs(List<Apac> apacs) {
		this.apacs = apacs;
	}

}
