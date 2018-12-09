package br.com.experian.gerenciadorperfil.core.service.relatorio;

import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public class RelatorioServiceException extends GerenciadorPerfilServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3095839506395885213L;

	public RelatorioServiceException() {
		super();
	}

	public RelatorioServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RelatorioServiceException(String message) {
		super(message);
	}

	public RelatorioServiceException(Throwable cause) {
		super(cause);
	}
}
