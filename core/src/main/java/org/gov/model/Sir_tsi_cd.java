package org.gov.model;

public enum Sir_tsi_cd {
	SULCOS_ABERTOS_EM_DESNIVEL("Sulcos abertos em desnível"),
	INUNDACAO_PERMANENTE_DIQUES_EM_NIVEL("Inundação permanente (diques em nível)"),
	ASPERSAO_POR_SISTEMA_CONVENCIONAL("Aspersão por sistema convencional"),
	ASPERSAO_POR_SISTEMA_AUTOPROPELIDO("Aspersão por sistema autopropelido"),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL("Aspersão por sistema pivô central"),
	GOTEJAMENTO("Gotejamento"),
	MICRO_ASPERSAO("Micro-aspersão"),
	TUBOS_PERFURADOS_TRIPA("Tubos perfurados (tripa)"),
	SULCOS_INTERLIGADOS_EM_BACIAS("Sulcos interligados em bacias"),
	SUB_IRRIGACAO("Sub-irrigação"),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_COM_LEPA("Aspersão por sistema pivô central com LEPA"),
	ASPERSAO_POR_CANHAO_HIDRAULICO("Aspersão por canhão hidráulico"),
	ASPERSAO_POR_SISTEMA_DESLOCAMENTO_LINEAR("Aspersão por sistema deslocamento linear"),
	ASPERSAO_POR_SISTEMA_EM_MALHA("Aspersão por sistema em malha"),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_REBOCAVEL("Aspersão por sistema pivô central rebocável"),
	CAMINHAO_REGADEIRA("Caminhão regadeira"),
	GOTEJAMENTO_SUBTERRANEO_TUBO_POROSO("Gotejamento subterrâneo - tubo poroso"),
	SULCOS_FECHADOS("Sulcos fechados"),
	INUNDACAO_TEMPORARIA_DIQUES_EM_DESNIVEL("Inundação temporária (diques em desnível)");

	private String descricao;

	Sir_tsi_cd(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
