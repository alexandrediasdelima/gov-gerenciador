package org.gov.model;

public enum Emp_ds_uf {
	AC("AC"),
	AL("AL"),
	AM("AM"),
	AP("AP"),
	BA("BA"),
	CE("CE"),
	DF("DF"),
	ES("ES"),
	GO("GO"),
	MA("MA"),
	MG("MG"),
	MS("MS"),
	MT("MT"),
	PA("PA"),
	PB("PB"),
	PE("PE"),
	PI("PI"),
	PR("PR"),
	RJ("RJ"),
	RN("RN"),
	RO("RO"),
	RR("RR"),
	RS("RS"),
	SC("SC"),
	SE("SE"),
	SP("SP"),
	TO("TO");

	private String descricao;
	Emp_ds_uf(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
