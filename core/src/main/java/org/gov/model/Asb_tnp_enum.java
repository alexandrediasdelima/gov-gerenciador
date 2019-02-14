package org.gov.model;

public enum Asb_tnp_enum {

	POCO_ESCAVADO("Poço escavado(cacimba/cisterna)"),
	FONTE_NATURAL("Fonte natural"),
	LAGO("LAGO"),
	LAGOA("LAGOA"),
	NASCENTE("Nascente"),
	PIEZOMETRO("Piezometro"),
	POCO_AMAZONAS("Poço Amazonas"),
	POCO_COLETOR("Poço coletor"),
	POCO_PONTEIRA("Poço ponteira"),
	POCO_TUBULAR("Poço tubular"),
	POCO_MONITORAMENTO("Poço de monitoramento");

	private String descricao;

	 Asb_tnp_enum(String descricao) {
		 this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
