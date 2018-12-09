package br.com.experian.gerenciadorperfil.core.service.vo;

import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;

public class CampanhaGratuidadeVO {

	private CampanhaGratuidade campanhaGratuidade;

	private String frase;

	/**
	 * @return the campanhaGratuidade
	 */
	public CampanhaGratuidade getCampanhaGratuidade() {
		return campanhaGratuidade;
	}

	/**
	 * @param campanhaGratuidade the campanhaGratuidade to set
	 */
	public void setCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) {
		this.campanhaGratuidade = campanhaGratuidade;
	}

	/**
	 * @return the frase
	 */
	public String getFrase() {
		return frase;
	}

	/**
	 * @param frase the frase to set
	 */
	public void setFrase(String frase) {
		this.frase = frase;
	}
}
