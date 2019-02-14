package org.gov.model;

public enum Asb_tca_enum {

	LIVRE("Livre"),
	CONFINADO("Confinado"),
	SEMI_LIVRE("Semi-Livre"),
	SEMI_CONFINADO("Semi-Confinado");

	private String descricao;

	Asb_tca_enum(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
