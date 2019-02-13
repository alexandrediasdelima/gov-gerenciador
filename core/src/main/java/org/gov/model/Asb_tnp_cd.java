package org.gov.model;

public enum Asb_tnp_cd {
	POCO_ESCAVADO("Poço escavado(cacimba/cisterna)"),
	FONTE_NATURAL("Fonte natural"),
	LAGO("Lago"),
	LAGOA("Lagoa"),
	NASCENTE("Nascente"),
	PIEZOMETRO("Piezômetro"),
	POCO_AMAZONAS("Poço amazonas"),
	POCO_COLETOR("Poço coletor"),
	POCO_PONTEIRA("Poço ponteira"),
	POCO_TUBULAR("Poço tubular"),
	POCO_DE_MONITORAMENTO("Poço de monitoramento");

	private String descricao;
	Asb_tnp_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
