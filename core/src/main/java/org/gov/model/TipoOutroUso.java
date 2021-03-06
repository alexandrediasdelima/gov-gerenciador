package org.gov.model;

public enum TipoOutroUso {
	ABASTECIMENTO_DE_PULVERIZADORES("ABASTECIMENTO DE PULVERIZADORES", 51),
	BALNEARIO_LAZER_E_CLUBE("BALNEÁRIO - LAZER E CLUBE", 39),
	CLARIFICACAO_DA_AGUA("CLARIFICAÇÃO DA ÁGUA", 22),
	COMBATE_A_INCENDIO("COMBATE A INCÊNDIO", 45),
	CONSTRUCAO_CIVIL("CONSTRUÇÃO CIVIL", 54),
	DEPURACAO_DE_EFLUENTES("DEPURAÇÃO DE EFLUENTES", 26),
	DISPOSICAO_DE_REJEITOS("DISPOSIÇÃO DE REJEITOS", 27),
	ECLUSA("ECLUSA", 1),
	HORTAS_POMARES_JARDINS_PAISAGISMO("HORTAS, POMARES, JARDINS, PAISAGISMO (ÁREA &lt; 1 HA)", 49),
	LAVAGEM_DE_VEICULOS("LAVAGEM DE VEÍCULOS", 21),
	LAVANDERIA("LAVANDERIA", 44),
	PESQUISA_HIDROGEOLOGICA("PESQUISA HIDROGEOLÓGICA / TESTE DE BOMBEAMENTO", 29),
	PESQUISA_MINERAL("PESQUISA MINERAL", 28),
	POCO_DE_BOMBEAMENTO_DE_RECUPERACAO_AMBIENTAL("POÇO DE BOMBEAMENTO DE RECUPERAÇÃO AMBIENTAL", 14),
	POCO_DE_INJECAO_PARA_RECUPERACAO_AMBIENTAL("POÇO DE INJEÇÃO PARA RECUPERAÇÃO AMBIENTAL", 16),
	POCO_DE_MONITORAMENTO("POÇO DE MONITORAMENTO/PIEZOMETRO", 15),
	REBAIXAMENTO_DE_AQUIFERO("REBAIXAMENTO DE AQUÍFERO", 32),
	RECIRCULACAO_DE_AGUA("RECIRCULAÇÃO DE ÁGUA", 30),
	RECREACAO("RECREAÇÃO", 2),
	SALVAMENTO("SALVAMENTO", 3),
	SISTEMA_DE_RESFRIAMENTO("SISTEMA DE RESFRIAMENTO", 19),
	TESTE_HIDROSTATICO("TESTE HIDROSTÁTICO", 50),
	UMECTACAO_DE_VIAS("UMECTAÇÃO DE VIAS", 17),
	URBANIZACAO("URBANIZAÇÃO", 31),
	OUTRO("OUTRO", 53);
	
    private int chave;
    private String valor;

    TipoOutroUso(String valor, int chave){
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
