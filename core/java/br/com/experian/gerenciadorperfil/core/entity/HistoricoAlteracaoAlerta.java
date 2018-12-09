package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;


public class HistoricoAlteracaoAlerta extends HistoricoReport implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String acao;


	/**
	 * @return the acao
	 */
	public String getAcao() {
		return acao;
	}

	/**
	 * @param acao the acao to set
	 */
	public void setAcao(String acao) {
		this.acao = acao;
	}


}
