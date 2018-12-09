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

@Entity
@Table(name = "PC_GEP_OFERTA_HIST")
@SequenceGenerator(name = "SEQ_PC_GEP_OFERTA_HIST", sequenceName = "SEQ_PC_GEP_OFERTA_HIST", allocationSize = 1)
public class HistoricoOferta extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 6654332323690171378L;

	public static final String INSERT = "INSERT";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public HistoricoOferta(){}

	public HistoricoOferta(Oferta oferta, String tipoOperacao){

		setDataInicioHistorico  (oferta.getDataInicio());
		setDataFimHistorico		(oferta.getDataFim());
		setTipoHistorico		(oferta.getTipo());
		setNomeHistorico		(oferta.getNome());
		setHtmlTelaHistorico	(oferta.getHtmlTela());
		setProdutoHistorico		(oferta.getProduto());
		setFeatureHistorico		(oferta.getFeature());
		setDiasParaReexibicaoHistorico(oferta.getDiasParaReexibicao());
		setCancelamentoHistorico(oferta.getCancelamento());

		setCpfLogonHistorico	(oferta.getCpfLogon());
		setDataOperacaoHistorico(new Date());

		setOfertaHistorico		(oferta);
		setTipoOperacaoHistorico(tipoOperacao);

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_OFERTA_HIST")
	@Column(name = "PK_PC_GEP_OFERTA_HIST")
	private Integer id;

	@Column(name = "DS_CPF_LOGON")
	private String cpfLogonHistorico;

	@Column(name = "DS_OPERACAO")
	private String tipoOperacaoHistorico;

	@Column(name = "TS_OPERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOperacaoHistorico;

	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PC_GEP_OFERTA", referencedColumnName="PK_PC_GEP_OFERTA")
	private Oferta ofertaHistorico;

	@Column(name = "DT_INICIO")
	@Temporal(TemporalType.DATE)
	private Date dataInicioHistorico;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.DATE)
	private Date dataFimHistorico;

	@Column(name = "TP_TIPO")
	private char tipoHistorico;

	@Column(name = "DS_NOME")
	private String nomeHistorico;

	@Column(name = "DS_HTML_TELA", length = 4000)
	private String htmlTelaHistorico;

	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_PRODUTO", referencedColumnName="PK_PC_GEP_PRODUTO")
	private Produto produtoHistorico;

	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature featureHistorico;

	@Column(name = "NU_DIAS_PARA_REEXIBICAO")
	private Integer diasParaReexibicaoHistorico;

	@Column(name = "TS_CANCELAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelamentoHistorico;


	@Override
	protected HistoricoOferta clone() throws CloneNotSupportedException {
		return (HistoricoOferta) super.clone();
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
		if (!(obj instanceof HistoricoOferta)) {
			return false;
		}
		HistoricoOferta other = (HistoricoOferta) obj;
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
	 * @return the cpfLogonHistorico
	 */
	public String getCpfLogonHistorico() {
		return cpfLogonHistorico;
	}

	/**
	 * @param cpfLogonHistorico the cpfLogonHistorico to set
	 */
	public void setCpfLogonHistorico(String cpfLogonHistorico) {
		this.cpfLogonHistorico = cpfLogonHistorico;
	}

	/**
	 * @return the tipoOperacaoHistorico
	 */
	public String getTipoOperacaoHistorico() {
		return tipoOperacaoHistorico;
	}

	/**
	 * @param tipoOperacaoHistorico the tipoOperacaoHistorico to set
	 */
	public void setTipoOperacaoHistorico(String tipoOperacaoHistorico) {
		this.tipoOperacaoHistorico = tipoOperacaoHistorico;
	}

	/**
	 * @return the dataOperacaoHistorico
	 */
	public Date getDataOperacaoHistorico() {
		return dataOperacaoHistorico;
	}

	/**
	 * @param dataOperacaoHistorico the dataOperacaoHistorico to set
	 */
	public void setDataOperacaoHistorico(Date dataOperacaoHistorico) {
		this.dataOperacaoHistorico = dataOperacaoHistorico;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOfertaHistorico() {
		return ofertaHistorico;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOfertaHistorico(Oferta ofertaHistorico) {
		this.ofertaHistorico = ofertaHistorico;
	}

	/**
	 * @return the dataInicioHistorico
	 */
	public Date getDataInicioHistorico() {
		return dataInicioHistorico;
	}

	/**
	 * @param dataInicioHistorico the dataInicioHistorico to set
	 */
	public void setDataInicioHistorico(Date dataInicioHistorico) {
		this.dataInicioHistorico = dataInicioHistorico;
	}

	/**
	 * @return the dataFimHistorico
	 */
	public Date getDataFimHistorico() {
		return dataFimHistorico;
	}

	/**
	 * @param dataFimHistorico the dataFimHistorico to set
	 */
	public void setDataFimHistorico(Date dataFimHistorico) {
		this.dataFimHistorico = dataFimHistorico;
	}

	/**
	 * @return the tipoHistorico
	 */
	public char getTipoHistorico() {
		return tipoHistorico;
	}

	/**
	 * @param tipoHistorico the tipoHistorico to set
	 */
	public void setTipoHistorico(char tipoHistorico) {
		this.tipoHistorico = tipoHistorico;
	}

	/**
	 * @return the nomeHistorico
	 */
	public String getNomeHistorico() {
		return nomeHistorico;
	}

	/**
	 * @param nomeHistorico the nomeHistorico to set
	 */
	public void setNomeHistorico(String nomeHistorico) {
		this.nomeHistorico = nomeHistorico;
	}

	/**
	 * @return the htmlTelaHistorico
	 */
	public String getHtmlTelaHistorico() {
		return htmlTelaHistorico;
	}

	/**
	 * @param htmlTelaHistorico the htmlTelaHistorico to set
	 */
	public void setHtmlTelaHistorico(String htmlTelaHistorico) {
		this.htmlTelaHistorico = htmlTelaHistorico;
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
	public void setProdutoHistorico(Produto produtoHistorico) {
		this.produtoHistorico = produtoHistorico;
	}

	/**
	 * @return the feature
	 */
	public Feature getFeatureHistorico() {
		return featureHistorico;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeatureHistorico(Feature featureHistorico) {
		this.featureHistorico = featureHistorico;
	}

	/**
	 * @return the diasParaReexibicaoHistorico
	 */
	public Integer getDiasParaReexibicaoHistorico() {
		return diasParaReexibicaoHistorico;
	}

	/**
	 * @param diasParaReexibicaoHistorico the diasParaReexibicaoHistorico to set
	 */
	public void setDiasParaReexibicaoHistorico(Integer diasParaReexibicaoHistorico) {
		this.diasParaReexibicaoHistorico = diasParaReexibicaoHistorico;
	}

	/**
	 * @return the cancelamentoHistorico
	 */
	public Date getCancelamentoHistorico() {
		return cancelamentoHistorico;
	}

	/**
	 * @param cancelamentoHistorico the cancelamentoHistorico to set
	 */
	public void setCancelamentoHistorico(Date cancelamentoHistorico) {
		this.cancelamentoHistorico = cancelamentoHistorico;
	}


}
