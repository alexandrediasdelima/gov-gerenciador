package org.gov.model;

public enum TipoPenetracaoAquifero {
	PARCIAL("Parcial", 1),
	TOTAL("Total", 2);


    private int chave;
    private String valor;

    TipoPenetracaoAquifero(String valor, int chave) {
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
