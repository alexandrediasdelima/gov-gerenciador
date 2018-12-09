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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.Cascade;

@Entity
@Table(name = "PC_GEP_BOOK_URL")
@SequenceGenerator(name = "SEQ_PC_GEP_BOOK_URL", sequenceName = "SEQ_PC_GEP_BOOK_URL", allocationSize = 1, initialValue = 1)
public class BookURL extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 2035323910542586104L;

	public static final char CAMPANHA = '1';
	public static final char CARONA = '2';
	
	public static final String STATUS_ATIVO = "A";
	/**
	 * Campo C deve ser para inativo. ou cancelado
	 */
	public static final String STATUS_CANCELADO = "I";
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_BOOK_URL")
	@Column(name = "PK_PC_GEP_BOOK_URL")
	private Integer id;

	@Column(name = "TP_ACAO_ESTRATEGICA")
	private String tipoEstrategia;

	@Transient
	private String nomePublico;
	
	@Column(name = "TP_PESSOA")
	private int publico;
	
	@Column(name = "TP_STATUS")
	private String status;
	
	@ManyToOne( fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_PRODUTO", referencedColumnName="PK_PC_GEP_PRODUTO")
	private Produto produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature feature;
    
	@Column(name = "DS_NOME")
	private String nome;
	
	@Column(name = "DS_BANNER")
	private String banner;

	@Column(name = "DS_BANNER_ULTIMO_DIA")
	private String bannerUltimoDia;

	@Column(name = "DS_BANNER_POS_GRATUIDADE")
	private String bannerPosGratuidade;
	
	@Column(name = "DS_URL_IMG_FND_INFORMATIVO")
	private String urlImagemFundoInformativo;

	@Column(name = "DS_URL_TEXTO_INFORMATIVO")
	private String urlTextoInformativo;

	@Column(name = "DS_URL_BT_CNCIA_INFORMATIVO")
	private String urlBotaoCienciaInformativo;
    
	@Column(name = "DS_OBSERVACAO_INFORMATIVO")
	private String observacaoInformativo;

	
	@Column(name = "DS_URL_IMG_FND_LBOX_CARONA")
	private String urlImagemFundoLigthBoxCarona;
	
	@Column(name = "DS_URL_TEXTO_LBOX_CARONA")
	private String urlTextoLigthBoxCarona;
	
//	@Column(name = "DS_URL_BT_CNCIA_LBOX_CARONA")
//	private String urlBotaoCienciaCarona;
	
	@Column(name = "DS_URL_BT_AFIRM_LBOX_CARONA")
	private String urlBotaoSimCarona;
	
	@Column(name = "DS_URL_BT_NEGAT_LBOX_CARONA")
	private String urlBotaoNaoCarona;
    
	@Column(name = "DS_OBSERVACAO_LBOX_CARONA")
	private String observacaoLigthBoxCarona;
       
	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "DT_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	@Column(name = "DS_LOGIN_ALTERACAO")
	private String loginAlteracao;
    
	@Column(name = "DS_LOGIN_CRIACAO")
	private String loginCriacao;
		
	@Override
	protected BookURL clone() throws CloneNotSupportedException {
		return (BookURL) super.clone();
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
		if (!(obj instanceof BookURL)) {
			return false;
		}
		BookURL other = (BookURL) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoEstrategia() {
		return tipoEstrategia;
	}
	public void setTipoEstrategia(String tipoEstrategia) {
		this.tipoEstrategia = tipoEstrategia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getBannerUltimoDia() {
		return bannerUltimoDia;
	}
	public void setBannerUltimoDia(String bannerUltimoDia) {
		this.bannerUltimoDia = bannerUltimoDia;
	}
	public String getBannerPosGratuidade() {
		return bannerPosGratuidade;
	}
	public void setBannerPosGratuidade(String bannerPosGratuidade) {
		this.bannerPosGratuidade = bannerPosGratuidade;
	}
	public String getUrlImagemFundoInformativo() {
		return urlImagemFundoInformativo;
	}
	public void setUrlImagemFundoInformativo(String urlImagemFundoInformativo) {
		this.urlImagemFundoInformativo = urlImagemFundoInformativo;
	}
	public String getUrlTextoInformativo() {
		return urlTextoInformativo;
	}
	public void setUrlTextoInformativo(String urlTextoInformativo) {
		this.urlTextoInformativo = urlTextoInformativo;
	}
	public String getUrlBotaoCienciaInformativo() {
		return urlBotaoCienciaInformativo;
	}
	public void setUrlBotaoCienciaInformativo(String urlBotaoCienciaInformativo) {
		this.urlBotaoCienciaInformativo = urlBotaoCienciaInformativo;
	}
	public String getObservacaoInformativo() {
		return observacaoInformativo;
	}
	public void setObservacaoInformativo(String observacaoInformativo) {
		this.observacaoInformativo = observacaoInformativo;
	}
	public String getUrlImagemFundoLigthBoxCarona() {
		return urlImagemFundoLigthBoxCarona;
	}
	public void setUrlImagemFundoLigthBoxCarona(String urlImagemFundoLigthBoxCarona) {
		this.urlImagemFundoLigthBoxCarona = urlImagemFundoLigthBoxCarona;
	}
	public String getUrlTextoLigthBoxCarona() {
		return urlTextoLigthBoxCarona;
	}
	public void setUrlTextoLigthBoxCarona(String urlTextoLigthBoxCarona) {
		this.urlTextoLigthBoxCarona = urlTextoLigthBoxCarona;
	}
//	public String getUrlBotaoCienciaCarona() {
//		return urlBotaoCienciaCarona;
//	}
//	public void setUrlBotaoCienciaCarona(String urlBotaoCienciaCarona) {
//		this.urlBotaoCienciaCarona = urlBotaoCienciaCarona;
//	}
	public void setObservacaoLigthBoxCarona(String observacaoLigthBoxCarona) {
		this.observacaoLigthBoxCarona = observacaoLigthBoxCarona;
	}
	public String getObservacaoLigthBoxCarona() {
		return observacaoLigthBoxCarona;
	}	
	public int getPublico() {
		return publico;
	}
	public void setPublico(int publico) {
		this.publico = publico;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getLoginAlteracao() {
		return loginAlteracao;
	}
	public void setLoginAlteracao(String loginAlteracao) {
		this.loginAlteracao = loginAlteracao;
	}
	public String getLoginCriacao() {
		return loginCriacao;
	}
	public void setLoginCriacao(String loginCriacao) {
		this.loginCriacao = loginCriacao;
	}
	
	@Transient
	public String getNomePublico() {
		return nomePublico;
	}
	@Transient
	public void setNomePublico(String nomePublico) {
		this.nomePublico = nomePublico;
	}
	@Transient
	public String getUrlBotaoSimCarona() {
		return urlBotaoSimCarona;
	}
	@Transient
	public void setUrlBotaoSimCarona(String urlBotaoSimCarona) {
		this.urlBotaoSimCarona = urlBotaoSimCarona;
	}
	@Transient
	public String getUrlBotaoNaoCarona() {
		return urlBotaoNaoCarona;
	}
	@Transient
	public void setUrlBotaoNaoCarona(String urlBotaoNaoCarona) {
		this.urlBotaoNaoCarona = urlBotaoNaoCarona;
	}

	
}
