package org.gov.model;

public enum Asb_tpn_enum {


	PARCIAL("Parcial"),
	TOTAL("Total");

	private String descricao;

	 Asb_tpn_enum(String descricao) {
		 this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}}
