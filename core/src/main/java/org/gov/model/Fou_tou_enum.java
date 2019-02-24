package org.gov.model;

public enum Fou_tou_enum {

	ECLUSA("Eclusa"),
	RECREACAO("Recreação"),
	POCO_BOMBEAMENTO("Poço de bombeamento de recuperação ambiental"),
	POCO_MONITORACAO("Poço de monitoramento/Piezometro"),
	POCO_INJECAO("Poço de injeção para recuperação ambiental"),
	UMECTACAO_VIAS("Umectação de vias"),
	SISTEMA_RESFRIAMENTO("Sistema de Resfriamento"),
	LAVAGEM_VEICULOS("Lavagem de veículos"),
	CLARIFICACAO_AGUA("Clarificação da água"),
	DEPURACAO_EFLUENTES("Depuração de efluentes"),
	DISPOSICAO_REJEITOS("Disposição de rejeitos"),
	PESQUISA_MINERAL("Pesquisa mineral"),
	PESQUISA_HIDROGEOLOGICA("Pesquisa hidrogeológica / teste de bombeamento"),
	RECIRCULACAO_AGUA("Recirculação de água"),
	URBANIZACAO("Urbanização"),
	REBAIXAMENTO_AQUIFERO("Rebaixamento de aquífero"),
	BALNEARIO("Balneário - lazer e clube"),
	LAVANDERIA("Lavanderia"),
	COMBATE_INCENDIO("Combate a incêndio"),
	HORTAS_ETC("Hortas, pomares, jardins, paisagismo (área < 1 ha)"),
	TESTE_HIDROSTATICO("Teste hidrostático"),
	ABASTECIMENTO_PULVERIZADORES("Abastecimento de pulverizadores"),
	OUTRO("Outro"),
	CONSTRUCAO_CIVIL("Construção Civil");


	private String descricao;

	Fou_tou_enum(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
