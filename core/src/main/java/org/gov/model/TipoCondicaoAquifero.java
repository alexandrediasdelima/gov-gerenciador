package org.gov.model;

public enum TipoCondicaoAquifero {
	LIVRE("Livre", 1),
	CONFINADO("Confinado", 2),
	SEMI_LIVRE("Semi-livre", 3),
	SEMI_CONFINADO("Semi-confinado", 4);


    private int chave;
    private String valor;

    TipoCondicaoAquifero(String valor, int chave) {
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
