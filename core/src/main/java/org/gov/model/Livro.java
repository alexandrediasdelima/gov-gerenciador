package org.gov.model;

import java.io.Serializable;
import java.util.Date;

public class Livro implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4761707641349322701L;

	private String titulo;
	private double preco;
	private Date data;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


}
