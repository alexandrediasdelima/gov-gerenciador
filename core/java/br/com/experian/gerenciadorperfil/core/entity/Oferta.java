package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Entity
@Table(name = "PC_GEP_OFERTA")
@SequenceGenerator(name = "SEQ_PC_GEP_OFERTA", sequenceName = "SEQ_PC_GEP_OFERTA", allocationSize = 1)
public class Oferta extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 8096354857317220646L;

	public static final char PESSOA_FISICA		='F';
	public static final char PESSOA_JURIDICA	='J';
	public static final char PESSOA_AMBOS	='A';

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_OFERTA")
	@Column(name = "PK_PC_GEP_OFERTA")
	private Integer id;

	@Column(name = "DT_INICIO")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@Column(name = "TP_TIPO")
	private char tipo;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "DS_HTML_TELA", length = 4000)
	private String htmlTela;

	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_PRODUTO", referencedColumnName="PK_PC_GEP_PRODUTO")
	private Produto produto;

	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature feature;

	@Column(name = "NU_DIAS_PARA_REEXIBICAO")
	private Integer diasParaReexibicao;

	@Column(name = "TS_CANCELAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelamento;

	//campos correspondentes a entidade HistoricoOferta
	@Transient	private String 	cpfLogon;
	@Transient	private String 	tipoOperacao;

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
	 * @return the dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim the dataFim to set
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
	 * @return the htmlTela
	 */
	public String getHtmlTela() {
		return htmlTela;
	}

	/**
	 * @param htmlTela the htmlTela to set
	 */
	public void setHtmlTela(String htmlTela) {
		this.htmlTela = htmlTela;
	}

	/**
	 * @return the feature
	 */
	public Feature getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(Feature feature) {
		this.feature = feature;
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
	 * @return the diasParaReexibicao
	 */
	public Integer getDiasParaReexibicao() {
		return diasParaReexibicao;
	}

	/**
	 * @param diasParaReexibicao the diasParaReexibicao to set
	 */
	public void setDiasParaReexibicao(Integer diasParaReexibicao) {
		this.diasParaReexibicao = diasParaReexibicao;
	}

	/**
	 * @return the cancelamento
	 */
	public Date getCancelamento() {
		return cancelamento;
	}

	/**
	 * @param cancelamento the cancelamento to set
	 */
	public void setCancelamento(Date cancelamento) {
		this.cancelamento = cancelamento;
	}

	/**
	 * @return the cpfLogon
	 */
	public String getCpfLogon() {
		return cpfLogon;
	}

	/**
	 * @param cpfLogon the cpfLogon to set
	 */
	public void setCpfLogon(String cpfLogon) {
		this.cpfLogon = cpfLogon;
	}

	/**
	 * @return the tipoOperacao
	 */
	public String getTipoOperacao() {
		return tipoOperacao;
	}

	/**
	 * @param tipoOperacao the tipoOperacao to set
	 */
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	public boolean isVigente() {
		return getCancelamento() == null && !DateCompare.before(getDataFim(), new Date());
	}

	@Override
	protected Oferta clone() throws CloneNotSupportedException {
		return (Oferta) super.clone();
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
		if (!(obj instanceof Oferta)) {
			return false;
		}
		Oferta other = (Oferta) obj;
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
