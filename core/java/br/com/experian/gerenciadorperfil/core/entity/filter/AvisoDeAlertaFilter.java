package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;

public class AvisoDeAlertaFilter extends AbstractEntityFilter<AvisoDeAlerta, AvisoDeAlertaFilter> {

	/**
	 *
	 */
	private static final long serialVersionUID = 5430565113780928100L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	private Integer idProdutoEquals;

	public AvisoDeAlertaFilter() {
		super(AvisoDeAlertaFilter.class);
	}

	/**
	 * @return the idProdutoEquals
	 */
	public Integer getIdProdutoEquals() {
		return idProdutoEquals;
	}

	/**
	 * @param idProdutoEquals the idProdutoEquals to set
	 */
	public AvisoDeAlertaFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}
}
