package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_AVISO_ALERTA")
public class AvisoDeAlerta extends EntityBase implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PK_PC_GEP_AVISO_ALERTA")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "FK_PC_GEP_PRODUTO")
	private Produto produto;

	@Column(name = "NU_DIAS_PARA_EMISSAO")
	private Integer diasParaEmissao;

	@Column(name = "DT_INICIO")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DS_TEXTO", columnDefinition = "VARCHAR2(2048)")
	private String texto;

	@Column(name = "DS_TEXTO_ING", columnDefinition = "VARCHAR2(2048)")
	private String textoOutrosIdiomas;

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
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the diasParaEmissao
	 */
	public Integer getDiasParaEmissao() {
		return diasParaEmissao;
	}

	/**
	 * @param diasParaEmissao the diasParaEmissao to set
	 */
	public void setDiasParaEmissao(Integer diasParaEmissao) {
		this.diasParaEmissao = diasParaEmissao;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode(id);
	}

	/**
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		AvisoDeAlerta other = (AvisoDeAlerta) obj;
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
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the textoOutrosIdiomas
	 */
	public String getTextoOutrosIdiomas() {
		return textoOutrosIdiomas;
	}

	/**
	 * @param textoOutrosIdiomas the textoOutrosIdiomas to set
	 */
	public void setTextoOutrosIdiomas(String textoOutrosIdiomas) {
		this.textoOutrosIdiomas = textoOutrosIdiomas;
	}
}
