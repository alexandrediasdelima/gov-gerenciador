package org.gov.web.controller;

import javax.faces.context.FacesContext;



public class InterferenciaBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public InterferenciaBean() {

	}

	public String redirecionaMenuInterferencia(int id) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("idInterferencia", id);

		return "/interferencia/menuInterferencia";
	}



}
