package org.gov.model;

public enum Int_tsu_cd {
	SUPERFICIAL("Superficial"),
	SUBTERRANEA("Subterrânea");

	private String descricao;

	Int_tsu_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
