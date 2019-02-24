package org.gov.model;

public enum Int_tin_cd {

	CAPTACAO("Captação"),
	LANCAMENTO("Lançamento"),
	BARRAGEM("Barragem"),
	PONTO_REFERENCIA("Ponto de Referência");

	private String descricao;

	Int_tin_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
