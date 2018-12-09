package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "PC_GEP_CAMPANHA")
@SequenceGenerator(name = "SEQ_PC_GEP_CAMPANHA", sequenceName = "SEQ_PC_GEP_CAMPANHA", allocationSize = 1, initialValue = 1)
public class CampanhaGratuidade extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 2035323910542586104L;

	public static final Integer TIPO_CAMPANHA_PADRAO = 1;
	public static final Integer TIPO_CAMPANHA_LANCAMENTO = 2;

	public static final int STATUS_PROCESSANDO = 1;
	public static final int STATUS_ENVIADO_MF = 2;
	public static final int STATUS_RETORNO_COM_ERRO = 4;
	public static final int STATUS_PROCESSADA_COM_SUCESSO = 5;
	public static final int STATUS_CANCELANDO = 6;
	public static final int STATUS_CANCELADA = 7;
	public static final int STATUS_CANCELAMENTO_ENVIADO_MF = 8;
	public static final int STATUS_RETORNO_CANCELAMENTO_ERRO = 9;

	public static final Integer TIPO_COMPORTAMENTO_PADRAO = 0;
	public static final Integer TIPO_COMPORTAMENTO_SALVAR_FEATURES = 2;
	public static final Integer TIPO_COMPORTAMENTO_SALVAR_FEATURES_SEM_JURIDICO = 3;

	@Transient
	private String viewStatus;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_CAMPANHA")
	@Column(name = "PK_PC_GEP_CAMPANHA")
	private Long id;

	@Column(name = "NO_NOME")
	private String nome;

	@Column(name = "TP_TIPO")
	private Integer tipo;

	@Column(name = "TP_PERFIL")
	private Integer tipoComportamentoPerfil;

	@Column(name = "DS_BANNER", length = 2048)
	private String banner;

	@Column(name = "DS_BANNER_ULTIMO_DIA", length = 2048)
	private String bannerUltimoDia;

	@Column(name = "DS_BANNER_PJ", length = 2048)
	private String bannerPJ;

	@Column(name = "DS_BANNER_ULTIMO_DIA_PJ")
	private String bannerUltimoDiaPJ;

	@Column(name = "DS_BANNER_POS", length = 2048)
	private String bannerPosGratuidade;

	@Column(name = "DS_BANNER_POS_PJ")
	private String bannerPosGratuidadePJ;

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

	@Column(name = "DT_INICIO_GRATUIDADE")
	@Temporal(TemporalType.DATE)
	private Date dataInicioGratuidade;

	@Column(name = "DT_FIM_GRATUIDADE")
	@Temporal(TemporalType.DATE)
	private Date dataFimGratuidade;

	@Column(name = "DT_FIM_POS_GRATUIDADE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimPosGratuidade;

	@Column(name = "NU_STATUS")
	private Integer status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PC_GEP_CAMPANHA_FEATURE", joinColumns = {@JoinColumn(name = "FK_PC_GEP_CAMPANHA")}, inverseJoinColumns = {@JoinColumn(name = "FK_PC_GEP_FEATURE")})
	private Set<Feature> features;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_PRODUTO", referencedColumnName="PK_PC_GEP_PRODUTO")
	private Produto produto;
	
	@Transient
	private boolean ligthboxJuridico = true;

	
	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_MEIO_ACESSO", referencedColumnName="PK_PC_GEP_MEIO_ACESSO")
	private MeioAcesso meioAcesso; 
	
	@ManyToOne
	@JoinColumn(name = "FK_GEP_CLIENTE", referencedColumnName="PK_PC_GEP_CLIENTE")
	private Cliente tipoCliente; 
	
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
	 * @return the banner
	 */
	public String getBanner() {
		return banner;
	}

	/**
	 * @param banner the banner to set
	 */
	public void setBanner(String banner) {
		this.banner = banner;
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
		return dataCriacao != null ? new Date(dataCriacao.getTime()) : null;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao != null ? new Date(dataCriacao.getTime()) : null;
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
	 * @return the features
	 */
	public Set<Feature> getFeatures() {
		if (features == null) {
			features = new LinkedHashSet<Feature>();
		}
		return features;
	}

	/**
	 * @param features the features to set
	 */
	public void setFeatures(Set<Feature> features) {
		getFeatures().clear();
		if (features != null) {
			getFeatures().addAll(features);
		}
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
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode(id);
	}




	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the bannerUltimoDia
	 */
	public String getBannerUltimoDia() {
		return bannerUltimoDia;
	}

	/**
	 * @param bannerUltimoDia the bannerUltimoDia to set
	 */
	public void setBannerUltimoDia(String bannerUltimoDia) {
		this.bannerUltimoDia = bannerUltimoDia;
	}

	@Override
	public CampanhaGratuidade clone() throws CloneNotSupportedException {
		return (CampanhaGratuidade) super.clone();
	}

	/**
	 * @return the bannerPJ
	 */
	public String getBannerPJ() {
		return bannerPJ;
	}

	/**
	 * @param bannerPJ the bannerPJ to set
	 */
	public void setBannerPJ(String bannerPJ) {
		this.bannerPJ = bannerPJ;
	}

	/**
	 * @return the bannerUltimoDiaPJ
	 */
	public String getBannerUltimoDiaPJ() {
		return bannerUltimoDiaPJ;
	}

	/**
	 * @param bannerUltimoDiaPJ the bannerUltimoDiaPJ to set
	 */
	public void setBannerUltimoDiaPJ(String bannerUltimoDiaPJ) {
		this.bannerUltimoDiaPJ = bannerUltimoDiaPJ;
	}

	/**
	 * @return the bannerPosGratuidade
	 */
	public String getBannerPosGratuidade() {
		return bannerPosGratuidade;
	}

	/**
	 * @param bannerPosGratuidade the bannerPosGratuidade to set
	 */
	public void setBannerPosGratuidade(String bannerPosGratuidade) {
		this.bannerPosGratuidade = bannerPosGratuidade;
	}

	/**
	 * @return the bannerPosGratuidadePJ
	 */
	public String getBannerPosGratuidadePJ() {
		return bannerPosGratuidadePJ;
	}

	/**
	 * @param bannerPosGratuidadePJ the bannerPosGratuidadePJ to set
	 */
	public void setBannerPosGratuidadePJ(String bannerPosGratuidadePJ) {
		this.bannerPosGratuidadePJ = bannerPosGratuidadePJ;
	}

	/**
	 * @return the viewStatus
	 */
	public String getViewStatus() {
		return viewStatus;
	}

	/**
	 * @param viewStatus the viewStatus to set
	 */
	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	/**
	 * @return the dataInicioGratuidade
	 */
	public Date getDataInicioGratuidade() {
		return dataInicioGratuidade;
	}

	/**
	 * @param dataInicioGratuidade the dataInicioGratuidade to set
	 */
	public void setDataInicioGratuidade(Date dataInicioGratuidade) {
		this.dataInicioGratuidade = dataInicioGratuidade;
	}

	/**
	 * @return the dataFimGratuidade
	 */
	public Date getDataFimGratuidade() {
		return dataFimGratuidade;
	}

	/**
	 * @param dataFimGratuidade the dataFimGratuidade to set
	 */
	public void setDataFimGratuidade(Date dataFimGratuidade) {
		this.dataFimGratuidade = dataFimGratuidade;
	}

	/**
	 * @return the dataFimPosGratuidade
	 */
	public Date getDataFimPosGratuidade() {
		return dataFimPosGratuidade;
	}

	/**
	 * @param dataFimPosGratuidade the dataFimPosGratuidade to set
	 */
	public void setDataFimPosGratuidade(Date dataFimPosGratuidade) {
		this.dataFimPosGratuidade = dataFimPosGratuidade;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the tipoComportamentoPerfil
	 */
	public Integer getTipoComportamentoPerfil() {
		return tipoComportamentoPerfil;
	}

	/**
	 * @param tipoComportamentoPerfil the tipoComportamentoPerfil to set
	 */
	public void setTipoComportamentoPerfil(Integer tipoComportamentoPerfil) {
		this.tipoComportamentoPerfil = tipoComportamentoPerfil;
	}

	public boolean isLigthboxJuridico() {
		return ligthboxJuridico;
	}

	public void setLigthboxJuridico(boolean ligthboxJuridico) {
		this.ligthboxJuridico = ligthboxJuridico;
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

	
	
}