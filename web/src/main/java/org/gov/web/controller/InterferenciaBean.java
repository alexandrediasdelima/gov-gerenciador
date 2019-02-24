package org.gov.web.controller;

import org.gov.model.Interferencia;




public class InterferenciaBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Interferencia interferencia;

	public InterferenciaBean() {

		this.interferencia = new Interferencia();
	}

	public Interferencia getInterferencia() {
		return interferencia;
	}

	public void setInterferencia(Interferencia interferencia) {
		this.interferencia = interferencia;
	}

	public String gravar() {

		System.out.println(interferencia);

		return null;
	}



}
