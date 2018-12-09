package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.Documento;

public class DocumentoFilter extends AbstractEntityFilter<Documento, DocumentoFilter> {

	public static final String ID_CAMPANHA_GRATUIDADE_EQUALS = "idCampanhaGratuidadeEquals";

	public static final String CNPJ_LIKE_BOTH = "cnpjLikeBoth";

	/**
	 *
	 */
	private static final long serialVersionUID = -7338924848416230371L;

	private Long idCampanhaGratuidadeEquals;

	private String cnpjLikeBoth;

	public DocumentoFilter() {
		super(DocumentoFilter.class);
	}

	/**
	 * @return the idCampanhaGratuidadeEquals
	 */
	public Long getIdCampanhaGratuidadeEquals() {
		return idCampanhaGratuidadeEquals;
	}

	/**
	 * @param idCampanhaGratuidadeEquals the idCampanhaGratuidadeEquals to set
	 */
	public DocumentoFilter setIdCampanhaGratuidadeEquals(Long idCampanhaGratuidadeEquals) {
		this.idCampanhaGratuidadeEquals = idCampanhaGratuidadeEquals;
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
	public DocumentoFilter setCnpjLikeBoth(String cnpjLikeBoth) {
		this.cnpjLikeBoth = cnpjLikeBoth;
		return this;
	}
}
