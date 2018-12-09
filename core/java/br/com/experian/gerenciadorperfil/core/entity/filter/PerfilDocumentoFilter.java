package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;

public class PerfilDocumentoFilter extends AbstractEntityFilter<PerfilDocumento, PerfilDocumentoFilter> {

	/**
	 *
	 */
	private static final long serialVersionUID = -761024380568037104L;

	public static final String ID_PERFIL_EQUALS = "idPerfilEquals";

	public static final String ID_PERFIL_IN = "idPerfilIn";

	public static final String ID_PERFIL_IN_SUBSELECT = "idPerfilInSubSelect";

	public static final String CONTAINS_DOCUMENTO_CNPJ = "containsDocumentoCnpj";

	private Long idPerfilEquals;

	private List<Long> idPerfilIn;

	private List<Long> idPerfilInSubSelect;

	private String containsDocumentoCnpj;

	public PerfilDocumentoFilter() {
		super(PerfilDocumentoFilter.class);
	}

	/**
	 * @return the idPerfilEquals
	 */
	public Long getIdPerfilEquals() {
		return idPerfilEquals;
	}

	/**
	 * @param idPerfilEquals the idPerfilEquals to set
	 */
	public PerfilDocumentoFilter setIdPerfilEquals(Long idPerfilEquals) {
		this.idPerfilEquals = idPerfilEquals;
		return this;
	}

	public String getContainsDocumentoCnpj() {
		return containsDocumentoCnpj;
	}

	public PerfilDocumentoFilter setContainsDocumentoCnpj(String containsDocumentoCnpj) {
		this.containsDocumentoCnpj = containsDocumentoCnpj;
		return this;
	}

	/**
	 * @return the idPerfilIn
	 */
	public List<Long> getIdPerfilIn() {
		return idPerfilIn;
	}

	/**
	 * @param idPerfilIn the idPerfilIn to set
	 * @return
	 */
	public PerfilDocumentoFilter setIdPerfilIn(List<Long> idPerfilIn) {
		this.idPerfilIn = idPerfilIn;
		return this;
	}

	/**
	 * @return the idPerfilInSubSelect
	 */
	public List<Long> getIdPerfilInSubSelect() {
		return idPerfilInSubSelect;
	}

	/**
	 * @param idPerfilInSubSelect the idPerfilInSubSelect to set
	 */
	public PerfilDocumentoFilter setIdPerfilInSubSelect(List<Long> idPerfilInSubSelect) {
		this.idPerfilInSubSelect = idPerfilInSubSelect;
		return this;
	}


}
