package org.gov.model;

public enum TipoInterferencia {
	CAPTACAO("CAPTAÇÃO", 1),
	LANCAMENTO("LANÇAMENTO", 2),
	BARRAGEM("BARRAGEM", 3),
	PONTO_REFERENCIA("PONTO DE REFERÊNCIA", 4);

    private int chave;
    private String valor;

    TipoInterferencia(String valor, int chave){
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