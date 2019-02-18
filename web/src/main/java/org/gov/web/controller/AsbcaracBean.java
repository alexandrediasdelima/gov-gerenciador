package org.gov.web.controller;

import javax.faces.context.FacesContext;

import org.gov.model.Asbcarac;
import org.gov.service.AsbcaracService;
import org.gov.service.AsbcaracServiceImpl;



public class AsbcaracBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Asbcarac asbcarac;
	private AsbcaracService asbcaracService;


	public AsbcaracBean () {
		asbcaracService = new AsbcaracServiceImpl();
	}

	public String redirecionarTelaCadastroAsbcarac() {

		asbcarac = new Asbcarac();
		this.asbcarac.setId((Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idInterferencia"));

		Asbcarac asb = asbcaracService.pesquisar(asbcarac.getId());
		setView(ADD);

		if(asb != null) {
			this.asbcarac = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		asbcaracService.gravar(asbcarac);

		return null;
	}

	public String alterar() {

		asbcaracService.editar(asbcarac);

		return null;
	}

	public String deletar() {

		asbcaracService.remover(asbcarac.getId());

		return null;
	}

	public String index() {
		return "/asbcarac/index";
	}

	public Asbcarac getAsbcarac() {
		return asbcarac;
	}

	public void setAsbcarac(Asbcarac asbcarac) {
		this.asbcarac = asbcarac;
	}

	public AsbcaracService getAsbcaracService() {
		return asbcaracService;
	}

	public void setAsbcaracService(AsbcaracService asbcaracService) {
		this.asbcaracService = asbcaracService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}






}
