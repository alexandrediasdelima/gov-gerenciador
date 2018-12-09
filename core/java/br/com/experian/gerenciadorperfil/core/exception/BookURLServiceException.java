package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

public class BookURLServiceException extends Exception {

	private static final long serialVersionUID = 1L;


	public BookURLServiceException() {
		super();
	}

	public BookURLServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookURLServiceException(String message) {
		super(message);
	}

	public BookURLServiceException(Throwable cause) {
		super(cause);
	}

	public BookURLServiceException(List<String> messages) {
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
