package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.Feature;

public class FeatureFilter extends AbstractEntityFilter<Feature, FeatureFilter> {

	/**
	 *
	 */
	private static final long serialVersionUID = -761024380568037104L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	public static final String NOME_LIKE_RIGHT = "nomeLikeRight";

	public static final String NOME_EQUALS = "nomeEquals";

	public static final String TRANSACAO_EQUALS = "transacaoEquals";

	public static final String TRANSACAO_LIKE_RIGHT = "transacaoLikeRight";

	private boolean transacaoAssociadaIsNull;

	private String transacaoEquals;

	private String transacaoLikeRight;

	private Integer idProdutoEquals;

	private String nomeLikeRight;

	private String nomeEquals;

	public FeatureFilter() {
		super(FeatureFilter.class);
	}

	/**
	 * @return the nomeEquals
	 */
	public String getNomeEquals() {
		return nomeEquals;
	}

	/**
	 * @param nomeEquals the nomeEquals to set
	 */
	public FeatureFilter setNomeEquals(String nomeEquals) {
		this.nomeEquals = nomeEquals;
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
	public FeatureFilter setTransacaoEquals(String transacaoEquals) {
		this.transacaoEquals = transacaoEquals;
		return this;
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
	public FeatureFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}

	/**
	 * @return the nomeLikeRight
	 */
	public String getNomeLikeRight() {
		return nomeLikeRight;
	}

	/**
	 * @param nomeLikeRight the nomeLikeRight to set
	 */
	public FeatureFilter setNomeLikeRight(String nomeLikeRight) {
		this.nomeLikeRight = nomeLikeRight;
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
	public FeatureFilter setTransacaoLikeRight(String transacaoLikeRight) {
		this.transacaoLikeRight = transacaoLikeRight;
		return this;
	}

	public FeatureFilter setTransacaoAssociadaIsNull(boolean transacaoAssociadaIsNull) {
		this.transacaoAssociadaIsNull = transacaoAssociadaIsNull;
		return this;
	}

	public boolean isTransacaoAssociadaIsNull() {
		return transacaoAssociadaIsNull;
	}
}
