package org.gov.web.model;

import java.io.Serializable;

public class Livro implements Serializable  {

	/**
	 *
	 */
	private static final long serialVersionUID = 2941457049495437754L;

	public String titulo;
	public double preco;
	public String dataLancamento;

	public Livro() {
	}

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

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}