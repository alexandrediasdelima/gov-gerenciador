package org.gov.model;

public enum Tst_tmi_cd {
	ARON_SCOTT("Aron-scott"),
	BOULTON("Boulton"),
	BRUGGEMAN("Bruggeman"),
	CHOW("Chow"),
	COOPER_JACOB("Cooper-jacob"),
	DE_GLEE("De glee"),
	DIETZ("Dietz"),
	ERNST_THIEM_WALTON("Ernst-thiem walton"),
	GOSSELIN("Gosselin"),
	HANTUSH("Hantush"),
	HANTUSH_JACOB("Hantush-jacob"),
	HANTUSH_THEIS("Hantush-theis"),
	HANTUSH_THOMAS("Hantush-thomas"),
	HUISMAN("Huisman"),
	HUISMAN_KEMPERMAN("Huisman-kemperman"),
	HURR("Hurr"),
	JACOB("Jacob"),
	JACOB_LOHMAN("Jacob-lohman"),
	LOGAN("Logan"),
	PAPADOPULOS_COOPER("Papadopulos-cooper"),
	PONTO_DE_CULMINACAO("Ponto de culminacao"),
	RECUPERACAO_DE_THEIS("Recuperacao de theis"),
	STALLMAN("Stallman"),
	STENBERG("Stenberg"),
	THEIS("Theis"),
	THIEM_DUPUIT("Thiem-dupuit"),
	THIEN("Thien"),
	ZANGAR("Zangar");

	private String descricao;
	Tst_tmi_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
