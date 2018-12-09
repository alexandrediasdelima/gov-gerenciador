package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;

public class FeatureDescontoFilter extends AbstractEntityFilter<FeatureDesconto, FeatureDescontoFilter> {

	private static final long serialVersionUID = -7568166391372723148L;

	public static final String ID_FEATURE_EQUALS = "idFeatureEquals";

	public static final String TRANSACAO_EQUALS = "transacaoEquals";

	public static final String TRANSACAO_LIKE_RIGHT = "transacaoLikeRight";

	private Integer idFeatureEquals;

	private String transacaoEquals;

	private String transacaoLikeRight;

	public FeatureDescontoFilter() {
		super(FeatureDescontoFilter.class);
	}

	/**
	 * @return the idProdutoEquals
	 */
	public Integer getIdFeatureEquals() {
		return idFeatureEquals;
	}

	/**
	 * @param idProdutoEquals the idProdutoEquals to set
	 */
	public FeatureDescontoFilter setIdFeatureEquals(Integer idFeatureEquals) {
		this.idFeatureEquals = idFeatureEquals;
		return this;
	}
	
	/**
	 * @return the transacaoEquals
	 */
	public String getTransacaoEquals() {
		return transacaoEquals;
	}

	/**
	 * @param transacaoEquals the transacaoEquals to set
	 */
	public FeatureDescontoFilter setTransacaoEquals(String transacaoEquals) {
		this.transacaoEquals = transacaoEquals;
		return this;
	}

	/**
	 * @return the transacaoLikeRight
	 */
	public String getTransacaoLikeRight() {
		return transacaoLikeRight;
	}

	/**
	 * @param transacaoLikeRight the transacaoLikeRight to set
	 */
	public FeatureDescontoFilter setTransacaoLikeRight(String transacaoLikeRight) {
		this.transacaoLikeRight = transacaoLikeRight;
		return this;
	}

}
