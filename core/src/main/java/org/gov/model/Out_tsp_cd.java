package org.gov.model;

public enum Out_tsp_cd {

	OUTORGADO("Outorgado"),
	NAO_OUTORGAVEL("Não Outorgável"),
	EM_ANALISE("Em Análise"),
	USO_INSIGNIFICANTE("Uso Insignificante"),
	INDEFERIDO("Indeferido"),
	INVALIDO("Inválido"),
	AUTORIZADO("Autorizado (água subterrânea)"),
	OUTRA("Outra");

	private String descricao;

	Out_tsp_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
