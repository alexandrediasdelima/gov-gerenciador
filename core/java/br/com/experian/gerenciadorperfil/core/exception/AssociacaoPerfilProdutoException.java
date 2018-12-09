package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

public class AssociacaoPerfilProdutoException extends GerenciadorPerfilServiceException {

	private static final long serialVersionUID = 1L;

	private List<String> cnpjs;

	public AssociacaoPerfilProdutoException() {
		super();
	}

	public AssociacaoPerfilProdutoException(String message, List<String> cnpjs) {
		super(message);
		this.cnpjs = cnpjs;
	}

	/**
	 * @return the cnpjs
	 */
	public List<String> getCnpjs() {
		return cnpjs;
	}

	/**
	 * @param cnpjs the cnpjs to set
	 */
	public void setCnpjs(List<String> cnpjs) {
		this.cnpjs = cnpjs;
	}


}
