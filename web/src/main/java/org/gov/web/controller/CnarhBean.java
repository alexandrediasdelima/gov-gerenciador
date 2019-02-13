package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Cnarh;
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


	public CnarhBean() {

		setCnarh(new Cnarh());
		cnarhService = new CnarhServiceImpl();
		cnarhs = new ArrayList<Cnarh>();
		cnarhs();
	}


	public String gravar() {

		cnarhService.gravar(cnarh);
		cnarhs();

		return eval(index());
	}

	public String cnarhs() {

		cnarhs = cnarhService.cnarhs();
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

		cnarhService.editar(cnarh);
		cnarhs();

		return eval(index());
	}

	public String deletar(Cnarh cnarh) {

		cnarhService.remover(cnarh.getCnarh_id());
		cnarhs();
		return eval(index());
	}

	 private void limparForm() {
//		 this.cnarh.setAreaTotalReserv(null);
//		 this.cnarh.setNumeroSiagas(null);
//		 this.cnarh.setVolumeMaxReserv(null);
	}

	public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
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

}
