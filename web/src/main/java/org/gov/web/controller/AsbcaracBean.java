package org.gov.web.controller;



public class AsbcaracBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int pkAsbcarac;

	public String redirecionarTelaCadastroAsbcarac() {

		return eval(index());
	}

	public String index() {
		return "/asbcarac/index";
	}

	public int getPkAsbcarac() {
		return pkAsbcarac;
	}

	public void setPkAsbcarac(int pkAsbcarac) {
		this.pkAsbcarac = pkAsbcarac;
	}






}
