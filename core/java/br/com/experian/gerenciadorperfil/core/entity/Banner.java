package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

public class Banner implements Serializable {

	private static final long serialVersionUID = 3958815572649416567L;

	public static final String REPLACE_DATA_FIM_GRATUIDADE = "%DATA_FIM_GRATUIDADE%";
	
	public static final String REPLACE_LINK_AUTOATENDIMENTO = "%LINK_AUTOATENDIMENTO%";

	public static final String OBS_LIGHTBOX_OPTIN = "* O valor da feature será cobrado em todas as consultas, adicional ao valor do relatório.";

	public static final String OBS_LIGHTBOX_OPTOUT = "* Para cancelar esta oferta basta acessar o <a href='" + REPLACE_LINK_AUTOATENDIMENTO + "'>Autoatendimento.</a>";
	
	public static final String OBS_LIGHTBOX_OPTIN_GRATUIDADE = "* O valor da feature será cobrado em todas as consultas após " + REPLACE_DATA_FIM_GRATUIDADE + ", adicional ao valor do relatório.";
	
	public static final String OBS_LIGHTBOX_OPTOUT_GRATUIDADE = "* Para cancelar esta oferta basta acessar o <a href='" + REPLACE_LINK_AUTOATENDIMENTO + "'>Autoatendimento.</a>";
	
	public static final String OBS_LIGHTBOX_INFORMATIVO = "* Todas as consultas da informação adicional serão gratuitas até " + REPLACE_DATA_FIM_GRATUIDADE + ". Após este período, sujeito a cobrança.";
	
	/**
	 * LIGHTBOX CARONA DE FEATURES
	 */

	private String urlImagemFundo;

	private String urlTexto;

	private String urlBotaoSim;

	private String urlBotaoNao;
	
	private String urlBotaoCiencia;

	private String observacoesLightbox;

	/**
	 * LIGHTBOX INFORMATIVO DE CARONA DE FEATURES
	 */

	private String urlImagemFundoInformativo;

	private String urlTextoInformativo;

	private String urlBotaoCienciaInformativo;

	private String observacoesLightboxInformativo;

	/**
	 * BANNER
	 */

	private String bannerGratuidade;

	private String bannerUltimoDiaGratuidade;

	private String bannerPosGratuidade;
	
	private String bannerOptOut;

	public String getUrlImagemFundo() {
		return urlImagemFundo;
	}

	public void setUrlImagemFundo(String urlImagemFundo) {
		this.urlImagemFundo = urlImagemFundo;
	}

	public String getUrlTexto() {
		return urlTexto;
	}

	public void setUrlTexto(String urlTexto) {
		this.urlTexto = urlTexto;
	}

	public String getUrlBotaoSim() {
		return urlBotaoSim;
	}

	public void setUrlBotaoSim(String urlBotaoSim) {
		this.urlBotaoSim = urlBotaoSim;
	}

	public String getUrlBotaoNao() {
		return urlBotaoNao;
	}

	public void setUrlBotaoNao(String urlBotaoNao) {
		this.urlBotaoNao = urlBotaoNao;
	}

	public String getObservacoesLightbox() {
		return observacoesLightbox;
	}

	public void setObservacoesLightbox(String observacoesLightbox) {
		this.observacoesLightbox = observacoesLightbox;
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

	public String getObservacoesLightboxInformativo() {
		return observacoesLightboxInformativo;
	}

	public void setObservacoesLightboxInformativo(String observacoesLightboxInformativo) {
		this.observacoesLightboxInformativo = observacoesLightboxInformativo;
	}

	public String getBannerGratuidade() {
		return bannerGratuidade;
	}

	public void setBannerGratuidade(String bannerGratuidade) {
		this.bannerGratuidade = bannerGratuidade;
	}

	public String getBannerUltimoDiaGratuidade() {
		return bannerUltimoDiaGratuidade;
	}

	public void setBannerUltimoDiaGratuidade(String bannerUltimoDiaGratuidade) {
		this.bannerUltimoDiaGratuidade = bannerUltimoDiaGratuidade;
	}

	public String getBannerPosGratuidade() {
		return bannerPosGratuidade;
	}

	public void setBannerPosGratuidade(String bannerPosGratuidade) {
		this.bannerPosGratuidade = bannerPosGratuidade;
	}

	public String getBannerOptOut() {
		return bannerOptOut;
	}

	public void setBannerOptOut(String bannerOptOut) {
		this.bannerOptOut = bannerOptOut;
	}

	public String getUrlBotaoCiencia() {
		return urlBotaoCiencia;
	}

	public void setUrlBotaoCiencia(String urlBotaoCiencia) {
		this.urlBotaoCiencia = urlBotaoCiencia;
	}

}