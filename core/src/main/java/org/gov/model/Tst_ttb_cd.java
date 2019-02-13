package org.gov.model;

public enum Tst_ttb_cd {
	REBAIXAMENTO("Rebaixamento "),
	RECARGA("Recarga "),
	ESCALONADO("Escalonado "),
	RECUPERACAO_RESIDUAL("Recuperação residual"),
	RECUPERACAO("Recuperação"),
	CONTINUO("Continuo ");

	private String descricao;
	Tst_ttb_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
