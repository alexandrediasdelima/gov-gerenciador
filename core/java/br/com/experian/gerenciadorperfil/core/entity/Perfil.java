package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_PERFIL")
@SequenceGenerator(name = "SEQ_PC_GEP_PERFIL", sequenceName = "SEQ_PC_GEP_PERFIL", allocationSize = 1, initialValue = 1)
public class Perfil extends EntityBase implements Serializable {

	private static final long serialVersionUID = 2035323910542586104L;

	public static final char CLIENTE_ANTIGO = 'A';
	public static final char CLIENTE_WHITELIST = 'W';
	public static final char CLIENTE_PRECLICADO = 'P';

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_PERFIL")
	@Column(name = "PK_PC_GEP_PERFIL")
	private Long id;

	@Column(name = "NO_NOME")
	private String nome;

	@Column(name = "TP_TIPO")
	private char tipo;

	@Column(name = "DS_LOGIN_CRIACAO")
	private String loginCriacao;

	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "DS_LOGIN_ALTERACAO")
	private String loginAlteracao;

	@Column(name = "DT_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	@ManyToMany(mappedBy="perfis", fetch=FetchType.EAGER)
	private Set<Produto> produtos;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public char getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the loginCriacao
	 */
	public String getLoginCriacao() {
		return loginCriacao;
	}

	/**
	 * @param loginCriacao the loginCriacao to set
	 */
	public void setLoginCriacao(String loginCriacao) {
		this.loginCriacao = loginCriacao;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the loginAlteracao
	 */
	public String getLoginAlteracao() {
		return loginAlteracao;
	}

	/**
	 * @param loginAlteracao the loginAlteracao to set
	 */
	public void setLoginAlteracao(String loginAlteracao) {
		this.loginAlteracao = loginAlteracao;
	}

	/**
	 * @return the dataAlteracao
	 */
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * @param dataAlteracao the dataAlteracao to set
	 */
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * @return the produtos
	 */
	public Set<Produto> getProdutos() {
		if (produtos == null) {
			produtos = new LinkedHashSet<Produto>();
		}
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(Set<Produto> produtos) {
		getProdutos().clear();
		if (produtos != null) {
			getProdutos().addAll(produtos);
		}
	}
	
	public List<Produto> getProdutosAsList() {
		return new ArrayList<Produto>(getProdutos());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode(id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Perfil)) {
			return false;
		}
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}