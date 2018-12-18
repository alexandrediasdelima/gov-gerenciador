package org.gov.web.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2687456402139175639L;


	private String usuario;
	private String senha;


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


}
