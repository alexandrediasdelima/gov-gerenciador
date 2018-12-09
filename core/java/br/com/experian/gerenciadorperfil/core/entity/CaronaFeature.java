package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Entity
@Table(name = "PC_GEP_CAMPANHA_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_CAMPANHA_DESC", sequenceName = "SEQ_PC_GEP_CAMPANHA_DESC", allocationSize = 1, initialValue = 1)
public class CaronaFeature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final String TIPO_OFERTA_OPTIN = "I";
	public static final String TIPO_OFERTA_OPTOUT = "O";
	public static final String TIPO_OFERTA_TURBO = "T";

	public static final int STATUS_PROCESSANDO = 1;
	public static final int STATUS_RETORNO_COM_ERRO = 2;
	public static final int STATUS_PROCESSADA_COM_SUCESSO = 3;
	public static final int STATUS_CANCELANDO = 4;
	public static final int STATUS_CANCELADA_COM_SUCESSO = 5;
	public static final int STATUS_RETORNO_CANCELAMENTO_ERRO = 6;
	public static final int STATUS_ENVIADO_MF = 7;
	public static final int STATUS_CANCELAMENTO_ENVIADO_MF = 8;
	
	@Transient
	private String logonOperacao;
	
	@Transient
	private Date dataCancelamento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_CAMPANHA_DESC")
	@Column(name = "PK_PC_GEP_CAMPANHA_DESC")
	private Long id;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "DT_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column(name = "DT_FIM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;
	
	@Column(name = "TP_OFERTA")
	private String tipoOferta;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature feature;
	
	@OneToOne
	@JoinColumn(name = "FK_PC_GEP_CAMPANHA", referencedColumnName="PK_PC_GEP_CAMPANHA")
	private CampanhaGratuidade campanhaGratuidade;

	@Transient
	private boolean contemInformativo;
	
	@Column(name = "DS_HTML_INFORMATIVO")
	private String htmlInformativo;
	
	@Column(name = "DS_HTML_BANNER")
	private String htmlBanner;
	
	@Column(name="DS_BANNER_INFORMATIVO")
	private String bannerOptOut;

	@Column(name = "NU_DIAS_REEXIBICAO")
	private Integer diasReexibicao;

	@Column(name = "NU_STATUS")
	private Integer status;

	@Transient
	private String viewStatus;
	
	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_MEIO_ACESSO", referencedColumnName="PK_PC_GEP_MEIO_ACESSO")
	private MeioAcesso meioAcesso; 
	
	@ManyToOne
	@JoinColumn(name = "FK_GEP_CLIENTE", referencedColumnName="PK_PC_GEP_CLIENTE")
	private Cliente tipoCliente; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(StringUtils.isNotBlank(nome))
			this.nome = nome.trim();
		else
			this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(String tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public CampanhaGratuidade getCampanhaGratuidade() {
		return campanhaGratuidade;
	}

	public void setCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) {
		this.campanhaGratuidade = campanhaGratuidade;
	}

	public boolean isContemInformativo() {
		return contemInformativo;
	}

	public void setContemInformativo(boolean contemInformativo) {
		this.contemInformativo = contemInformativo;
	}
	
	public String getHtmlInformativo() {
		return htmlInformativo;
	}

	public void setHtmlInformativo(String htmlInformativo) {
		this.htmlInformativo = htmlInformativo;
	}
	
	public String getHtmlBanner() {
		return htmlBanner;
	}

	public void setHtmlBanner(String htmlBanner) {
		this.htmlBanner = htmlBanner;
	}

	public Integer getDiasReexibicao() {
		return diasReexibicao;
	}

	public void setDiasReexibicao(Integer diasReexibicao) {
		this.diasReexibicao = diasReexibicao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getLogonOperacao() {
		return logonOperacao;
	}

	public void setLogonOperacao(String logonOperacao) {
		this.logonOperacao = logonOperacao;
	}
	
	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	
	public String getBannerOptOut() {
		return bannerOptOut;
	}

	public void setBannerOptOut(String bannerOptOut) {
		this.bannerOptOut = bannerOptOut;
	}
	
	public boolean isOptIn(){
		return tipoOferta != null ? tipoOferta.equals(TIPO_OFERTA_OPTIN) : false;
	}
	
	public boolean isOptOut(){
		return tipoOferta != null ? tipoOferta.equals(TIPO_OFERTA_OPTOUT) : false;
	}

	public boolean isTurbo(){
		return tipoOferta != null ? tipoOferta.equals(TIPO_OFERTA_TURBO) : false;
	}

	public boolean isVigente() {
		
		if(status != null && (STATUS_PROCESSADA_COM_SUCESSO == status.intValue() && DateCompare.between(new Date(), dataInicio, dataFim))) {
			return true;
		}
		
		return false;
	}
	
	//DateCompare.after(hoje, dataFim)
	
	public boolean isFinalizada() {		
		if(status != null && (STATUS_PROCESSADA_COM_SUCESSO == status.intValue() && DateCompare.after(new Date(), dataFim))) {
			return true;
		}
		
		return false;
	}
	
	public boolean isPosGratuidade() {
		
		if (status != null && (STATUS_PROCESSADA_COM_SUCESSO == status.intValue() && campanhaGratuidade != null && campanhaGratuidade.getDataFimPosGratuidade() != null)) {
			if (DateCompare.between(new Date(), dataFim, campanhaGratuidade.getDataFimPosGratuidade())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isProgramada() {
		
		if (status != null && (STATUS_PROCESSADA_COM_SUCESSO == status.intValue() && DateCompare.before(new Date(), dataInicio))){
			return true;
		}
		
		return false;
	}
	
	public String getViewStatus(){
		
		switch (status) {
		case STATUS_PROCESSANDO:
			return StatusViewEnum.PROCESSANDO.getViewStatus();
		case STATUS_ENVIADO_MF:
			return StatusViewEnum.ENVIADO_MF.getViewStatus();
		case STATUS_CANCELADA_COM_SUCESSO:
			return StatusViewEnum.CANCELADA.getViewStatus();
		case STATUS_CANCELAMENTO_ENVIADO_MF:
			return StatusViewEnum.CANCELAMENTO_ENVIADO_MF.getViewStatus();
		case STATUS_CANCELANDO:
			return StatusViewEnum.CANCELANDO.getViewStatus();
		case STATUS_RETORNO_COM_ERRO:
			return StatusViewEnum.ERRO.getViewStatus();
		case STATUS_RETORNO_CANCELAMENTO_ERRO:
			return StatusViewEnum.ERRO_CANCELAMENTO.getViewStatus();
		case STATUS_PROCESSADA_COM_SUCESSO:
			Date hoje = Calendar.getInstance().getTime();
			
			
			if(campanhaGratuidade != null){
				
				if(DateCompare.between(hoje, campanhaGratuidade.getDataInicioGratuidade(), dataFim)){
					return StatusViewEnum.VIGENTE.getViewStatus();
				}
				
				if(DateCompare.before(hoje, campanhaGratuidade.getDataInicioGratuidade())){
					return StatusViewEnum.PROGRAMADA.getViewStatus();
				}
				
				if(DateCompare.after(hoje, dataFim)){
					return StatusViewEnum.FINALIZADA.getViewStatus();
				}
				
			}else{
				
				if (DateCompare.between(hoje, getDataInicio(), getDataFim())){
					return StatusViewEnum.VIGENTE.getViewStatus();
				}
				
				if (DateCompare.before(hoje, getDataInicio())){
					return StatusViewEnum.PROGRAMADA.getViewStatus();
				}
				
				if(DateCompare.after(hoje, dataFim)){
					return StatusViewEnum.FINALIZADA.getViewStatus();
				}
			}

		default:
			return StringUtils.EMPTY;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaronaFeature other = (CaronaFeature) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNomeUpperCase() {
		return this.nome.toUpperCase();
	}

	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	public MeioAcesso getMeioAcesso() {
		return meioAcesso;
	}

	public void setMeioAcesso(MeioAcesso meioAcesso) {
		this.meioAcesso = meioAcesso;
	}

	public Cliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Cliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "CaronaFeature [logonOperacao=" + logonOperacao + ", dataCancelamento=" + dataCancelamento + ", id="
				+ id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", tipoOferta="
				+ tipoOferta + ", contemInformativo=" + contemInformativo + ", diasReexibicao=" + diasReexibicao + ", status="
				+ status + "]";
	}
}
