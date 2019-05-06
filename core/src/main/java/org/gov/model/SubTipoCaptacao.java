package org.gov.model;

public enum SubTipoCaptacao {
	SUPERFICIAL("SUPERFICIAL", 1),
	SUBTERRANEA("SUBTERRÂNEA", 2);

    private int chave;
    private String valor;

    SubTipoCaptacao(String valor, int chave) {
        this.valor = valor;
        this.chave = chave;
    }

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
