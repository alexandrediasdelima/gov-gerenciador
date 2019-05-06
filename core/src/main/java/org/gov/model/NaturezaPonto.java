package org.gov.model;

public enum NaturezaPonto {
	POCO_ESCAVADO_CACIMBA_CISTERNA("Poço escavado(cacimba/cisterna)", 1),
	FONTE_NATURAL("Fonte natural", 2),
	LAGO("Lago", 3),
	LAGOA("Lagoa", 4),
	NASCENTE("Nascente", 5),
	PIEZOMETRO("Piezômetro", 6),
	POCO_AMAZONAS("Poço amazonas", 7),
	POCO_COLETOR("Poço coletor", 8),
	POCO_PONTEIRA("Poço ponteira", 9),
	POCO_TUBULAR("Poço tubular", 10),
	POCO_DE_MONITORAMENTO("Poço de monitoramento", 11);


    private int chave;
    private String valor;

    NaturezaPonto(String valor, int chave) {
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
