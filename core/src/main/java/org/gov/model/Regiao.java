package org.gov.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_regiao")
public class Regiao implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4393846583363607850L;


	@Column(name="reg_str_unidadefederativa")
	private String uf;

	@Column(name="reg_nu_codibge")
	@Id
	private Integer codIbge;

	@Column(name="reg_str_municipio")
	private String municipio;


	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(Integer codIbge) {
		this.codIbge = codIbge;
	}

}
