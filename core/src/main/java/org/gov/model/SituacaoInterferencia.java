package org.gov.model;

public enum SituacaoInterferencia {
	PROJETO("PROJETO", 1),
	CONSTRUCAO("CONSTRUÇÃO", 2),
	OPERACAO("OPERAÇÃO", 3),
	DESATIVADA("DESATIVADA", 4);

    private int chave;
    private String valor;

    SituacaoInterferencia(String valor, int chave){
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
