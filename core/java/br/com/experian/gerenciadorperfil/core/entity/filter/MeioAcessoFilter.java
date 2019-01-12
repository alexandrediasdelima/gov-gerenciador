package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.io.Serializable;

import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;

public class MeioAcessoFilter extends AbstractEntityFilter<MeioAcesso, MeioAcessoFilter> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String NOME_LIKE_RIGHT = "nomeLikeRight";

	public static final String NOME_EQUALS = "nomeEquals";

	public static final String ID_NOT_EQUALS = "idNotEquals";

	public static final String ID_EQUALS = "idEquals";

	private String nomeLikeRight;

	private String nomeEquals;

	private Integer idEquals;

	private Integer idNotEquals;
	
	private boolean orderByIdDesc;
	
	private boolean orderByIdAsc;
	
	private boolean orderByName = true;

	public MeioAcessoFilter() {
		super(MeioAcessoFilter.class);
	}

	public String getNomeLikeRight() {
		return nomeLikeRight;
	}

	public MeioAcessoFilter setNomeLikeRight(String nomeLikeRight) {
		this.nomeLikeRight = nomeLikeRight;
		return this;
	}

	public String getNomeEquals() {
		return nomeEquals;
	}

	public MeioAcessoFilter setNomeEquals(String nomeEquals) {
		this.nomeEquals = nomeEquals;
		return this;
	}

	public Integer getIdNotEquals() {
		return idNotEquals;
	}

	public MeioAcessoFilter setIdNotEquals(Integer idNotEquals) {
		this.idNotEquals = idNotEquals;
		return this;
	}

	public Integer getIdEquals() {
		return idEquals;
	}

	public MeioAcessoFilter setIdEquals(Integer idEquals) {
		this.idEquals = idEquals;
		return this;
	}

	public boolean isOrderByIdDesc() {
		return orderByIdDesc;
	}

	public MeioAcessoFilter setOrderByIdDesc(boolean orderByIdDesc) {
		this.orderByIdDesc = orderByIdDesc;
		return this;
	}

	public boolean isOrderByName() {
		return orderByName;
	}

	public MeioAcessoFilter setOrderByName(boolean orderByName) {
		this.orderByName = orderByName;
		return this;
	}

	public boolean isOrderByIdAsc() {
		return orderByIdAsc;
	}

	public void setOrderByIdAsc(boolean orderByIdAsc) {
		this.orderByIdAsc = orderByIdAsc;
	}
	
}