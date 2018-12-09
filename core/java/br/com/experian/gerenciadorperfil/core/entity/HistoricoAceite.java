package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;


public class HistoricoAceite extends HistoricoReport implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String cnpj;

	private String ip;


	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}
