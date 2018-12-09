package br.com.experian.gerenciadorperfil.core.util.enumeration;

public enum EnumTipoAssociacao {
	
	ISOLADA      ("I", "Consulta Isolada"),
	RECIPROCIDADE("R", "Reciprocidade");
	
	private String tipo;
	private String nome;
	
	EnumTipoAssociacao(String tipo, String nome){
		this.tipo = tipo;
		this.nome= nome;
	}
	
	public static EnumTipoAssociacao getEnumPorTipo(String tipo){
		
		for(EnumTipoAssociacao e : EnumTipoAssociacao.values()){
			if(e.getTipo().equals(tipo)){
				return e;
			}
		}
		
		return null;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}
}
