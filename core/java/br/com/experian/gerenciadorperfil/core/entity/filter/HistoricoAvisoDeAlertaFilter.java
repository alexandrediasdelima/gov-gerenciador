package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoAvisoDeAlerta;

public class HistoricoAvisoDeAlertaFilter extends AbstractEntityFilter<HistoricoAvisoDeAlerta, HistoricoAvisoDeAlertaFilter> {

	/**
	 *
	 */
	private static final long serialVersionUID = 7956538839315378793L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	private Integer idProdutoEquals;

	public HistoricoAvisoDeAlertaFilter() {
		super(HistoricoAvisoDeAlertaFilter.class);
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
	public HistoricoAvisoDeAlertaFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}
}
