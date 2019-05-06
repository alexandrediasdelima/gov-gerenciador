package org.gov.model;

public enum TipoMetodoInterpretacao {
	ARON_SCOTT("Aron-scott", 1),
	BOULTON("Boulton", 2),
	BRUGGEMAN("Bruggeman", 3),
	CHOW("Chow", 4),
	COOPER_JACOB("Cooper-jacob", 5),
	DE_GLEE("De glee", 6),
	DIETZ("Dietz", 7),
	ERNST_THIEM_WALTON("Ernst-thiem walton", 8),
	GOSSELIN("Gosselin", 9),
	HANTUSH("Hantush", 10),
	HANTUSH_JACOB("Hantush-jacob", 11),
	HANTUSH_THEIS("Hantush-theis", 12),
	HANTUSH_THOMAS("Hantush-thomas", 13),
	HUISMAN("Huisman", 14),
	HUISMAN_KEMPERMAN("Huisman-kemperman", 15),
	HURR("Hurr", 16),
	JACOB("Jacob", 17),
	JACOB_LOHMAN("Jacob-lohman", 18),
	LOGAN("Logan", 19),
	PAPADOPULOS_COOPER("Papadopulos-cooper", 20),
	PONTO_DE_CULMINACAO("Ponto de culminacao", 21),
	RECUPERACAO_DE_THEIS("Recuperacao de theis", 22),
	STALLMAN("Stallman", 23),
	STENBERG("Stenberg", 24),
	THEIS("Theis", 25),
	THIEM_DUPUIT("Thiem-dupuit", 26),
	THIEN("Thien", 27),
	ZANGAR("Zangar", 28);


    private int chave;
    private String valor;

    TipoMetodoInterpretacao(String valor, int chave) {
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
