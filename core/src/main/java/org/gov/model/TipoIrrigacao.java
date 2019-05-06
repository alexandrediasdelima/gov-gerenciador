package org.gov.model;

public enum TipoIrrigacao {
	SULCOS_ABERTOS_EM_DESNIVEL("SULCOS ABERTOS EM DESNÍVEL", 1),
	INUNDACAO_PERMANENTE_DIQUES_EM_NIVEL("INUNDAÇÃO PERMANENTE (DIQUES EM NÍVEL)", 2),
	ASPERSAO_POR_SISTEMA_CONVENCIONAL("ASPERSÃO POR SISTEMA CONVENCIONAL", 3),
	ASPERSAO_POR_SISTEMA_AUTOPROPELIDO("ASPERSÃO POR SISTEMA AUTOPROPELIDO", 4),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL("ASPERSÃO POR SISTEMA PIVÔ CENTRAL", 5),
	GOTEJAMENTO("GOTEJAMENTO", 6),
	MICRO_ASPERSAO("MICRO-ASPERSÃO", 7),
	TUBOS_PERFURADOS_TRIPA("TUBOS PERFURADOS (TRIPA)", 8),
	SULCOS_INTERLIGADOS_EM_BACIAS("SULCOS INTERLIGADOS EM BACIAS", 9),
	SUB_IRRIGACAO("SUB-IRRIGAÇÃO", 10),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_COM_LEPA("ASPERSÃO POR SISTEMA PIVÔ CENTRAL COM LEPA", 11),
	ASPERSAO_POR_CANHAO_HIDRAULICO("ASPERSÃO POR CANHÃO HIDRÁULICO", 12),
	ASPERSAO_POR_SISTEMA_DESLOCAMENTO_LINEAR("ASPERSÃO POR SISTEMA DESLOCAMENTO LINEAR", 13),
	ASPERSAO_POR_SISTEMA_EM_MALHA("ASPERSÃO POR SISTEMA EM MALHA", 14),
	ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_REBOCAVEL("ASPERSÃO POR SISTEMA PIVÔ CENTRAL REBOCÁVEL", 15),
	CAMINHAO_REGADEIRA("CAMINHÃO REGADEIRA", 16),
	GOTEJAMENTO_SUBTERRÂNEO_TUBO_POROSO("GOTEJAMENTO SUBTERRÂNEO - TUBO POROSO", 17),
	SULCOS_FECHADOS("SULCOS FECHADOS", 18),
	INUNDACAO_TEMPORARIA_DIQUES_EM_DESNIVEL("INUNDAÇÃO TEMPORÁRIA (DIQUES EM DESNÍVEL)", 19);

    private int chave;
    private String valor;

    TipoIrrigacao(String valor, int chave) {
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
