package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.Perfil;

public class PerfilFilter extends AbstractEntityFilter<Perfil, PerfilFilter> {

	/**
	 *
	 */
	private static final long serialVersionUID = -761024380568037104L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	public static final String NOME_LIKE_RIGHT = "nomeLikeRight";

	public static final String TIPO_EQUALS = "tipoEquals";

	private Integer idProdutoEquals;

	private String nomeLikeRight;
	
	private char tipoEquals;
	
	private boolean orderByIdDesc;
	
	private boolean orderByName = true;

	public PerfilFilter() {
		super(PerfilFilter.class);
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
	public PerfilFilter setIdProdutoEquals(Integer idProdutoEquals) {
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
	public PerfilFilter setNomeLikeRight(String nomeLikeRight) {
		this.nomeLikeRight = nomeLikeRight;
		return this;
	}

	/**
	 * @return the tipoEquals
	 */
	public char getTipoEquals() {
		return tipoEquals;
	}

	/**
	 * @param tipoEquals the tipoEquals to set
	 */
	public PerfilFilter setTipoEquals(char tipoEquals) {
		this.tipoEquals = tipoEquals;
		return this;
	}
	
	public boolean isOrderByIdDesc() {
		return orderByIdDesc;
	}

	public PerfilFilter setOrderByIdDesc(boolean orderByIdDesc) {
		this.orderByIdDesc = orderByIdDesc;
		return this;
	}

	public boolean isOrderByName() {
		return orderByName;
	}

	public PerfilFilter setOrderByName(boolean orderByName) {
		this.orderByName = orderByName;
		return this;
	}
	
}
