package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;

public class DocumentosJaCadastradosEmCaronaFeatureException extends GerenciadorPerfilServiceException {

	private static final long serialVersionUID = -3234368972284227252L;

	public static final int MAXIMO_MOSTRADO_COMO_DUPLICIDADE = 50;

	private List<DocumentoCaronaFeature> documentos;
	
	public DocumentosJaCadastradosEmCaronaFeatureException(String message) {
		super(message);
	}

	/**
	 * @return the documentos
	 */
	public List<DocumentoCaronaFeature> getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<DocumentoCaronaFeature> documentos) {
		this.documentos = documentos;
	}
}
