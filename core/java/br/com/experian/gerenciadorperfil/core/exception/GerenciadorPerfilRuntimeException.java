package br.com.experian.gerenciadorperfil.core.exception;

public class GerenciadorPerfilRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GerenciadorPerfilRuntimeException() {
		super();
	}

	public GerenciadorPerfilRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public GerenciadorPerfilRuntimeException(String message) {
		super(message);
	}

	public GerenciadorPerfilRuntimeException(Throwable cause) {
		super(cause);
	}
}
