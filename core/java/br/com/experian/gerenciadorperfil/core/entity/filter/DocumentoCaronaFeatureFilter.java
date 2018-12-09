package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;

public class DocumentoCaronaFeatureFilter extends AbstractEntityFilter<DocumentoCaronaFeature, DocumentoCaronaFeatureFilter> {

	public static final String ID_CAMPANHA_DESCONTO_EQUALS = "idCaronaFeatureEquals";

	public static final String CNPJ_LIKE_BOTH = "cnpjLikeBoth";
	
	private static final long serialVersionUID = -1255348728730916143L;

	private Long idCaronaFeatureEquals;
	
	private String cnpjLikeBoth;
	
	public DocumentoCaronaFeatureFilter() {
		super(DocumentoCaronaFeatureFilter.class);
	}

	/**
	 * @return the idCaronaFeatureEquals
	 */
	public Long getIdCaronaFeatureEquals() {
		return idCaronaFeatureEquals;
	}

	/**
	 * @param idCaronaFeatureEquals the idCaronaFeatureEquals to set
	 */
	public DocumentoCaronaFeatureFilter setIdCaronaFeatureEquals(Long idCaronaFeatureEquals) {
		this.idCaronaFeatureEquals = idCaronaFeatureEquals;
		return this;
	}

	/**
	 * @return the cnpjLikeBoth
	 */
	public String getCnpjLikeBoth() {
		return cnpjLikeBoth;
	}

	/**
	 * @param cnpjLikeBoth the cnpjLikeBoth to set
	 */
	public DocumentoCaronaFeatureFilter setCnpjLikeBoth(String cnpjLikeBoth) {
		this.cnpjLikeBoth = cnpjLikeBoth;
		return this;
	}

}