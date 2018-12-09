package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Documento;

public class DocumentosJaCadastradosEmCampanhaGratuidadeException extends GerenciadorPerfilServiceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 71541807424818441L;

	public static final int MAXIMO_MOSTRADO_COMO_DUPLICIDADE = 50;

	private List<Documento> documentos;

	public DocumentosJaCadastradosEmCampanhaGratuidadeException(String message) {
		super(message);
	}

	/**
	 * @return the documentos
	 */
	public List<Documento> getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
}
