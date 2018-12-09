package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_HIST_AVISO_ALE")
@SequenceGenerator(name = "SEQ_PC_GEP_PC_GEP_HIST_AVISO", sequenceName = "SEQ_PC_GEP_PC_GEP_HIST_AVISO", allocationSize = 1, initialValue = 1)
public class HistoricoAvisoDeAlerta extends EntityBase implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4484295298638191402L;

	public static final String INSERT = "I";

	public static final String UPDATE = "U";

	public static final String DELETE = "D";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_PC_GEP_HIST_AVISO")
	@Column(name = "PK_PC_GEP_HIST_AVISO")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_PRODUTO")
	private Produto produtoHistorico;

	@Column(name = "DS_TEXTO", columnDefinition = "VARCHAR2(2048)")
	private String textoHistorico;

	@Column(name = "DS_TEXTO_ING", columnDefinition = "VARCHAR2(2048)")
	private String textoOutrosIdiomasHistorico;

	@Column(name = "DS_LOGIN_CRIACAO")
	private String loginCriacaoHistorico;

	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoHistorico;

	@Column(name = "DS_ACAO")
	private String acao;

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
	 * @return the produto
	 */
	public Produto getProdutoHistorico() {
		return produtoHistorico;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProdutoHistorico(Produto produto) {
		this.produtoHistorico = produto;
	}

	/**
	 * @return the texto
	 */
	public String getTextoHistorico() {
		return textoHistorico;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTextoHistorico(String texto) {
		this.textoHistorico = texto;
	}

	/**
	 * @return the loginCriacao
	 */
	public String getLoginCriacaoHistorico() {
		return loginCriacaoHistorico;
	}

	/**
	 * @param loginCriacao the loginCriacao to set
	 */
	public void setLoginCriacaoHistorico(String loginCriacao) {
		this.loginCriacaoHistorico = loginCriacao;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacaoHistorico() {
		return dataCriacaoHistorico;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacaoHistorico(Date dataCriacao) {
		this.dataCriacaoHistorico = dataCriacao;
	}

	/**
	 * @return the acao
	 */
	public String getAcao() {
		return acao;
	}

	/**
	 * @param acao the acao to set
	 */
	public void setAcao(String acao) {
		this.acao = acao;
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		HistoricoAvisoDeAlerta other = (HistoricoAvisoDeAlerta) obj;
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
	 * @return the textoOutrosIdiomas
	 */
	public String getTextoOutrosIdiomasHistorico() {
		return textoOutrosIdiomasHistorico;
	}

	/**
	 * @param textoOutrosIdiomas the textoOutrosIdiomas to set
	 */
	public void setTextoOutrosIdiomasHistorico(String textoOutrosIdiomas) {
		this.textoOutrosIdiomasHistorico = textoOutrosIdiomas;
	}
}
