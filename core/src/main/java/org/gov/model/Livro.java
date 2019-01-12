package org.gov.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Livro implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4761707641349322701L;

	@Id
	@GeneratedValue
	private int id;
	private String titulo;

	@Column(name = "preco", columnDefinition = "numeric")
	private double preco;

	@Temporal(TemporalType.DATE)
	private Date data;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
