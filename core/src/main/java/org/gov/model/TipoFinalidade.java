package org.gov.model;

public enum TipoFinalidade {
	ABASTECIMENTO_PUBLICO("ABASTECIMENTO PÚBLICO", 1),
	APROVEITAMENTO_HIDROELETRICO("APROVEITAMENTO HIDROELÉTRICO", 10),
	AQUICULTURA_EM_TANQUE_ESCAVADO("AQUICULTURA EM TANQUE ESCAVADO", 7),
	AQUICULTURA_EM_TANQUE_REDE("AQUICULTURA EM TANQUE REDE", 18),
	CONSUMO_HUMANO("CONSUMO HUMANO", 12),
	CRIACAO_ANIMAL("CRIAÇÃO ANIMAL", 6),
	ESGOTAMENTO_SANITARIO("ESGOTAMENTO SANITÁRIO", 2),
	INDUSTRIA("INDÚSTRIA", 3),
	IRRIGACAO("IRRIGAÇÃO", 5),
	MINERACAO_EXTRACAO("MINERAÇÃO – EXTRAÇÃO DE AREIA/CASCALHO EM LEITO DE RIO", 4),
	MINERACAO_OUTROS("MINERAÇÃO – OUTROS PROCESSOS EXTRATIVOS", 13),
	OBRAS_HIDRAULICAS("OBRAS HIDRÁULICAS", 15),
	RESERVATORIO("RESERVATÓRIO/BARRAMENTO/REGULARIZAÇÃO DE VAZÕES PARA USOS MÚLTIPLOS", 11),
	SEM_FINALIDADE("SEM FINALIDADE", 0),
	SERVICOS("SERVIÇOS", 16),
	TERMOELETRICA("TERMOELÉTRICA", 8),
	TRANSPOSICAO("TRANSPOSIÇÃO", 9),
	OUTRAS("OUTRAS", 99);
	
	private int chave;
    private String valor;

    TipoFinalidade(String valor, int chave){
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
