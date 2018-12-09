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
@Table(name = "PC_GEP_CAMPANHA_DESC_HIST")
@SequenceGenerator(name = "SEQ_PC_GEP_CAMPANHA_DESC_HIST", sequenceName = "SEQ_PC_GEP_CAMPANHA_DESC_HIST", allocationSize = 1, initialValue = 1)
public class HistoricoCaronaFeature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 7087524775705726667L;
	
	public static final Character INSERT = 'I';
	public static final Character UPDATE = 'U';
	public static final Character DELETE = 'D';
	
	public HistoricoCaronaFeature(){
	}

	public HistoricoCaronaFeature(CaronaFeature caronaFeature, String logonOperacao, Character tipoOperacao) {

		setNomeHistorico				(caronaFeature.getNome());
		setDataInicioHistorico  		(caronaFeature.getDataInicio());
		setDataFimHistorico				(caronaFeature.getDataFim());
		setTipoOfertaHistorico			(caronaFeature.getTipoOferta());
		setIdFeatureHistorico			(caronaFeature.getFeature().getId());
		setIdCampanhaGratuidadeHistorico(caronaFeature.getCampanhaGratuidade() != null ? caronaFeature.getCampanhaGratuidade().getId() : null);
		setHtmlInformativoHistorico		(caronaFeature.getHtmlInformativo());
		setHtmlBannerHistorico			(caronaFeature.getHtmlBanner());
		setDiasReexibicaoHistorico		(caronaFeature.getDiasReexibicao());
		setStatusHistorico				(caronaFeature.getStatus());
		
		setLogonOperacao				(logonOperacao);
		setTipoOperacao					(tipoOperacao);
		setDataOperacao					(new Date());
		
		setCaronaFeatureHistorico	(caronaFeature);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_CAMPANHA_DESC_HIST")
	@Column(name = "PK_PC_GEP_CAMPANHA_DESC_HIST")
	private Long id;

	@Column(name = "DS_LOGON_OPERACAO")
	private String logonOperacao;
	
	@Column(name = "TP_OPERACAO")
	private Character tipoOperacao;
	
	@Column(name = "DT_OPERACAO")
	private Date dataOperacao;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PC_GEP_CAMPANHA_DESC", referencedColumnName="PK_PC_GEP_CAMPANHA_DESC")
	private CaronaFeature caronaFeatureHistorico;
	
	@Column(name = "DS_NOME")
	private String nomeHistorico;

	@Column(name = "DT_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioHistorico;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimHistorico;
	
	@Column(name = "TP_OFERTA")
	private String tipoOfertaHistorico;

	@Column(name = "FK_PC_GEP_FEATURE")
	private Integer idFeatureHistorico;
	
	@Column(name = "FK_PC_GEP_CAMPANHA")
	private Long idCampanhaGratuidadeHistorico;

	@Column(name = "DS_HTML_INFORMATIVO")
	private String htmlInformativoHistorico;
	
	@Column(name = "DS_HTML_BANNER")
	private String htmlBannerHistorico;

	@Column(name = "NU_DIAS_REEXIBICAO")
	private Integer diasReexibicaoHistorico;

	@Column(name = "NU_STATUS")
	private Integer statusHistorico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogonOperacao() {
		return logonOperacao;
	}

	public void setLogonOperacao(String logonOperacao) {
		this.logonOperacao = logonOperacao;
	}

	public Character getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(Character tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public CaronaFeature getCaronaFeatureHistorico() {
		return caronaFeatureHistorico;
	}

	public void setCaronaFeatureHistorico(
			CaronaFeature caronaFeatureHistorico) {
		this.caronaFeatureHistorico = caronaFeatureHistorico;
	}

	public String getNomeHistorico() {
		return nomeHistorico;
	}

	public void setNomeHistorico(String nomeHistorico) {
		this.nomeHistorico = nomeHistorico;
	}

	public Date getDataInicioHistorico() {
		return dataInicioHistorico;
	}

	public void setDataInicioHistorico(Date dataInicioHistorico) {
		this.dataInicioHistorico = dataInicioHistorico;
	}

	public Date getDataFimHistorico() {
		return dataFimHistorico;
	}

	public void setDataFimHistorico(Date dataFimHistorico) {
		this.dataFimHistorico = dataFimHistorico;
	}

	public String getTipoOfertaHistorico() {
		return tipoOfertaHistorico;
	}

	public void setTipoOfertaHistorico(String tipoOfertaHistorico) {
		this.tipoOfertaHistorico = tipoOfertaHistorico;
	}

	public Integer getIdFeatureHistorico() {
		return idFeatureHistorico;
	}

	public void setIdFeatureHistorico(Integer idFeatureHistorico) {
		this.idFeatureHistorico = idFeatureHistorico;
	}

	public Long getIdCampanhaGratuidadeHistorico() {
		return idCampanhaGratuidadeHistorico;
	}

	public void setIdCampanhaGratuidadeHistorico(Long idCampanhaGratuidadeHistorico) {
		this.idCampanhaGratuidadeHistorico = idCampanhaGratuidadeHistorico;
	}

	public String getHtmlInformativoHistorico() {
		return htmlInformativoHistorico;
	}

	public void setHtmlInformativoHistorico(String htmlInformativoHistorico) {
		this.htmlInformativoHistorico = htmlInformativoHistorico;
	}
	
	public String getHtmlBannerHistorico() {
		return htmlBannerHistorico;
	}

	public void setHtmlBannerHistorico(String htmlBannerHistorico) {
		this.htmlBannerHistorico = htmlBannerHistorico;
	}

	public Integer getDiasReexibicaoHistorico() {
		return diasReexibicaoHistorico;
	}

	public void setDiasReexibicaoHistorico(Integer diasReexibicaoHistorico) {
		this.diasReexibicaoHistorico = diasReexibicaoHistorico;
	}

	public Integer getStatusHistorico() {
		return statusHistorico;
	}

	public void setStatusHistorico(Integer statusHistorico) {
		this.statusHistorico = statusHistorico;
	}

}
