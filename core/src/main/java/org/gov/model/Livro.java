package org.gov.model;

import java.io.Serializable;

public class Livro implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4761707641349322701L;

	private String titulo;
	private double preco;
	private String data;
	private String autor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


}
