package br.com.experian.gerenciadorperfil.core.exception;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;

public class DocumentosCienciaPendenteCaronaFeatureException extends GerenciadorPerfilServiceException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1096413289243089994L;

	public static final int MAXIMO_DOCUMENTOS_MOSTRADO = 50;

	private List<DocumentoCaronaFeature> documentos;
	
	public DocumentosCienciaPendenteCaronaFeatureException(String message) {
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
