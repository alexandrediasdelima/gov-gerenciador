package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.experian.gerenciadorperfil.core.service.common.SimNao;

@Entity
@Table(name = "PC_GEP_PRODUTO")
@SequenceGenerator(name = "SEQ_PC_GEP_PRODUTO", sequenceName = "SEQ_PC_GEP_PRODUTO", allocationSize = 1, initialValue = 1)
public class Produto extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 2035323910542586104L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_PRODUTO")
	@Column(name = "PK_PC_GEP_PRODUTO")
	private Integer id;

	@Column(name = "NO_NOME")
	private String nome;

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

	@Column(name = "NU_LOGA_TODAS_AS_CONSULTAS")
	private Integer logaTodasAsConsultas = SimNao.SIM;

	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
		name = "PC_GEP_PERFIL_PRODUTO",
		joinColumns = {@JoinColumn(name = "FK_PC_GEP_PRODUTO",referencedColumnName="PK_PC_GEP_PRODUTO")},
	    inverseJoinColumns={@JoinColumn(name="FK_PC_GEP_PERFIL",referencedColumnName="PK_PC_GEP_PERFIL")}
	)
	
	
	
	private Set<Perfil> perfis;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
		if (dataCriacao != null) {
			return new Date(dataCriacao.getTime());
		} else {
			return null;
		}
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		if (dataCriacao != null) {
			this.dataCriacao = new Date(dataCriacao.getTime());
		} else {
			this.dataCriacao = null;
		}
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
		if (dataAlteracao != null) {
			return new Date(dataAlteracao.getTime());
		} else {
			return null;
		}
	}

	/**
	 * @param dataAlteracao the dataAlteracao to set
	 */
	public void setDataAlteracao(Date dataAlteracao) {
		if (dataAlteracao != null) {
			this.dataAlteracao = new Date(dataAlteracao.getTime());
		} else {
			this.dataAlteracao = null;
		}
	}

	/**
	 * @return the logaTodasAsConsultas
	 */
	public Integer getLogaTodasAsConsultas() {
		return logaTodasAsConsultas;
	}

	/**
	 * @param logaTodasAsConsultas the logaTodasAsConsultas to set
	 */
	public void setLogaTodasAsConsultas(Integer logaTodasAsConsultas) {
		this.logaTodasAsConsultas = logaTodasAsConsultas;
	}

	@Override
	protected Produto clone() throws CloneNotSupportedException {
		return (Produto) super.clone();
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
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}



	/**
	 * @return the perfis
	 */
	public Set<Perfil> getPerfis() {
		if (perfis == null) {
			perfis = new TreeSet<Perfil>();
		}
		return perfis;
	}

	/**
	 * @param perfis the perfis to set
	 */
	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	public List<Perfil> getPerfisAsList() {
		return new ArrayList<Perfil>(getPerfis());
	}
	
}
