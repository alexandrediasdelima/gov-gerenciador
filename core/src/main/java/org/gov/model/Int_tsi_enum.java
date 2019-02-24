package org.gov.model;

public enum Int_tsi_enum {

	PROJETO("Projeto"),
	CONSTRUCAO("Construção"),
	OPERACAO("Operação"),
	DESATIVADA("Desativada");

	private String descricao;

	Int_tsi_enum(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
