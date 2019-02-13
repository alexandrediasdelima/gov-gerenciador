package org.gov.model;

public enum Asb_tpn_cd {
	PARCIAL("Parcial"),
	TOTAL("Total");

	private String descricao;
	Asb_tpn_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
