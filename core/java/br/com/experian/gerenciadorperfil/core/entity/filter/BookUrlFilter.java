package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.io.Serializable;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.Produto;

public class BookUrlFilter extends AbstractEntityFilter<BookURL, BookUrlFilter> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String NOME_LIKE_RIGHT = "nomeLikeRight";

	public static final String NOME_EQUALS = "nomeEquals";

	public static final String ID_NOT_EQUALS = "idNotEquals";

	public static final String ID_EQUALS = "idEquals";
	
	public static final String PRODUTO_EQUALS = "ProdutoEquals";
	
	public static final String ACAO_ESTRATEGICA_EQUALS = "AcaoEstrategicaEquals";
	
	private Produto produtoEquals;

	private String nomeLikeRight;

	private String nomeEquals;

	private Integer idEquals;

	private Integer idNotEquals;
	
	private boolean orderByIdDesc;
	
	private String acaoEstategicaEquals;
	
	private boolean orderByName = true;

	public BookUrlFilter() {
		super(BookUrlFilter.class);
	}

	public String getNomeLikeRight() {
		return nomeLikeRight;
	}

	public BookUrlFilter setNomeLikeRight(String nomeLikeRight) {
		this.nomeLikeRight = nomeLikeRight;
		return this;
	}

	public String getNomeEquals() {
		return nomeEquals;
	}

	public BookUrlFilter setNomeEquals(String nomeEquals) {
		this.nomeEquals = nomeEquals;
		return this;
	}

	public Integer getIdNotEquals() {
		return idNotEquals;
	}

	public BookUrlFilter setIdNotEquals(Integer idNotEquals) {
		this.idNotEquals = idNotEquals;
		return this;
	}

	public Integer getIdEquals() {
		return idEquals;
	}

	public BookUrlFilter setIdEquals(Integer idEquals) {
		this.idEquals = idEquals;
		return this;
	}

	public boolean isOrderByIdDesc() {
		return orderByIdDesc;
	}

	public BookUrlFilter setOrderByIdDesc(boolean orderByIdDesc) {
		this.orderByIdDesc = orderByIdDesc;
		return this;
	}

	public boolean isOrderByName() {
		return orderByName;
	}

	public BookUrlFilter setOrderByName(boolean orderByName) {
		this.orderByName = orderByName;
		return this;
	}
	
	public Produto getProdutoEquals() {
		return produtoEquals;
	}

	public BookUrlFilter setProdutoEquals(Produto produtoEquals) {
		this.produtoEquals = produtoEquals;
		return this;
	}

	public String getAcaoEstategicaEquals() {
		return acaoEstategicaEquals;
	}

	public void setAcaoEstategicaEquals(String acaoEstategicaEquals) {
		this.acaoEstategicaEquals = acaoEstategicaEquals;
	}

}
