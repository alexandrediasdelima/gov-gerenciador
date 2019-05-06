package org.gov.model;

public enum TipoTesteBombeamento {
	REBAIXAMENTO("Rebaixamento", 1),
	RECARGA("Recarga", 2),
	ESCALONADO("Escalonado", 3),
	RECUPERACAO_RESIDUAL("Recuperação residual", 4),
	RECUPERACAO("Recuperação", 5),
	CONTINUO("Continuo", 6);


    private int chave;
    private String valor;

    TipoTesteBombeamento(String valor, int chave) {
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
