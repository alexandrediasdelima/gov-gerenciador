package org.gov.model;

public enum TipoOutorga {
	DIREITO_DE_USO("DIREITO DE USO", 1),
	PREVENTIVA("PREVENTIVA", 2),
	DRDH("DRDH", 3),
	CERTOH("CERTOH", 4),
	LICENCA_OU_AUTORIZACAO_PARA_PERFURACAO_DE_POCOS("LICENÇA OU AUTORIZAÇÃO PARA PERFURAÇÃO DE POÇOS", 5),	
	ANUENCIA_PREVIA("ANUÊNCIA PRÉVIA", 6),
	CADASTRO("CADASTRO", 7),
	OUTRA("OUTRA", 99);


    private int chave;
    private String valor;

    TipoOutorga(String valor, int chave) {
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
