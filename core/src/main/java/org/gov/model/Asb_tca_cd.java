package org.gov.model;

public enum Asb_tca_cd {
	LIVRE("Livre"),
	CONFINADO("Confinado"),
	SEMI_LIVRE("Semi-livre"),
	SEMI_CONFINADO("Semi-confinado");

	private String descricao;
	Asb_tca_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
