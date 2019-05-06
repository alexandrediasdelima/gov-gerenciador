package org.gov.model;

public enum SituacaoOutorga {
	OUTORGADO("OUTORGADO", 1), 
	NAO_OUTORGAVEL("NÃO OUTORGÁVEL", 2), 
	EM_ANALISE("EM ANÁLISE" , 3),
	USO_INSIGNIFICANTE("USO INSIGNIFICANTE", 4),
	INDEFERIDO("INDEFERIDO", 5),	
	INVALIDO("INVÁLIDO", 6),
	AUTORIZADO_SUBTERRANEA("AUTORIZADO (ÁGUA SUBTERRÂNEA)", 8),
	OUTRA("OUTRA", 99);
	

    private int chave;
    private String valor;

    SituacaoOutorga(String valor, int chave) {
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
