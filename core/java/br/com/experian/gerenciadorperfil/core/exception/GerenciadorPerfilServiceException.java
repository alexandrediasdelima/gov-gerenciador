package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

public class GerenciadorPerfilServiceException extends Exception {

	private static final long serialVersionUID = 1L;


	public GerenciadorPerfilServiceException() {
		super();
	}

	public GerenciadorPerfilServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GerenciadorPerfilServiceException(String message) {
		super(message);
	}

	public GerenciadorPerfilServiceException(Throwable cause) {
		super(cause);
	}

	public GerenciadorPerfilServiceException(List<String> messages) {
		super(getConcatMessage(messages));
	}

	public static String getConcatMessage(List<String> messages) {
		StringBuilder message = new StringBuilder();
		for(String msg: messages){
			message.append(msg);
			message.append("<br /><br />");
		}
		return message.toString();
	}



}
