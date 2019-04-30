package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Cnarh;
import org.gov.model.Usuario;
import org.gov.service.CnarhService;
import org.gov.service.CnarhServiceImpl;
import org.primefaces.event.SelectEvent;

public class CnarhBean extends Controller  {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	private Cnarh cnarh;
	private CnarhService cnarhService;
	private List<Cnarh> cnarhs;
	private List<Cnarh> filteredCnarhs;


	public CnarhBean() {

		setCnarh(new Cnarh());
		cnarhService = new CnarhServiceImpl();
		cnarhs = new ArrayList<Cnarh>();
		cnarhs();
	}

	public String redirecionarTelaCadastro(String id) {

		cnarh = new Cnarh();
		this.cnarh.setCnarh_id(id);

		Cnarh usr = cnarhService.pesquisar(id);
		setView(ADD);

		if(usr != null) {
			this.cnarh = usr;
			setView(EDIT);
		}

		return eval(index());
	}

	public void resetView() {
		//setView(LIST);
	}
	
	public String gravar() {
		setView(LIST);
		cnarhService.gravar(cnarh);
		cnarhs();

		return eval(index());
	}

	public String cnarhs() {
		this.cnarhs = cnarhService.cnarhs();
		setView(LIST);
		return eval(index());
	}

	public String adicionarBtnNovoCnarh() {
		setView(ADD);
		limparForm();
		return eval(index());
	}

	public String telaEditar(Cnarh cnarh) {

		this.cnarh = cnarh;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {
		setView(LIST);
		cnarhService.editar(cnarh);
		cnarhs();
		return eval(index());
	}

	public String deletar() {
		setView(LIST);
		cnarhService.remover(cnarh.getCnarh_id());
		cnarhs();
		return eval(index());
	}

	 private void limparForm() {
		 this.cnarh.setCnarh_id(null);
		 this.cnarh.setInt_nu_siagas(null);
		 this.cnarh.setIus_ar_resmax(null);
		 this.cnarh.setIus_nu_alturares(null);
		 this.cnarh.setIus_vo_resmax(null);
	}

	public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }

	public String voltar() {
		setView(LIST);
		return "/cnarh/index";
	}

	public String index() {
		return "/cnarh/index";
	}

	public Cnarh getCnarh() {
		return cnarh;
	}


	public void setCnarh(Cnarh cnarh) {
		this.cnarh = cnarh;
	}


	public List<Cnarh> getCnarhs() {
		return cnarhs;
	}


	public void setCnarhs(List<Cnarh> cnarhs) {
		this.cnarhs = cnarhs;
	}


	public List<Cnarh> getFilteredCnarhs() {
		return filteredCnarhs;
	}


	public void setFilteredCnarhs(List<Cnarh> filteredCnarhs) {
		this.filteredCnarhs = filteredCnarhs;
	}



}
