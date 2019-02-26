package org.gov.model;

public enum Fin_tfn_cd {

	SEM_FINALIDADE("Sem Finalidade"),
	ABASTECIMENTO_PUBLICO("Abastecimento Público"),
	ESGOTAMENTO_SANITARIO("Esgotamento Sanitário"),
	INDUTRIA("Indústria"),
	MINERACAO_EXTRACAO_AREIA_CASCALHO("Mineração – Extração de Areia/Cascalho em Leito de Rio"),
	IRRIGACAO("Irrigação"),
	CRIACAO_ANIMAL("Criação Animal"),
	AGRICULTURA_TANQUE_ESCAVADO("Agricultura em Tanque Escavado"),
	TERMOELETRICA("Termoelétrica"),
	TRANSPOSICAO("Transposição"),
	APROVEITAMENTO_HIDROELETRICO("Aproveitamento Hidroelétrico"),
	RESERVATORIO_BARRAMENTO_REGULARIZACAO("Reservatório/Barramento/Regularização Vazoes Usos Múltiplos"),
	CONSUMO_HUMANO("Consumo Humano"),
	MINERACAO_OUTROS("Mineração – Outros Processos Extrativos"),
	OBRAS_HIDRAULICAS("Obras Hidráulicas"),
	SERVICOS("Serviços"),
	AGRICULTURA_TANQUE_REDE("Agricultura em Tanque Rede"),
	OUTRAS("Outras");


	private String descricao;

	Fin_tfn_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
