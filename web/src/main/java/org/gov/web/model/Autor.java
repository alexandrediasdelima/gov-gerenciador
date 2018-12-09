package org.gov.web.model;

import java.io.Serializable;

public class Autor implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1152871978485508191L;

	private int id;
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
