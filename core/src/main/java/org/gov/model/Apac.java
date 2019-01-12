package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name= "tb_apac")
public class Apac implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name ="out_nu_processo")
	@Id
	private String numeroProcesso;

	@Column(name = "apa_analista")
	private String analistaResponsavel;

	@Column(name = "out_ds_ato")
	private String atoAdministrativoPublicacaoInstrumento;

	@Column(name = "apa_dt_vistoria")
	@Temporal(TemporalType.DATE)
	private Date dataVistoria;

	@Column(name = "apa_dt_contrato_concessao")
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoContrato;

	@Column(name = "apa_entr_apac")
	@Temporal(TemporalType.DATE)
	private Date dataEntradaProcessoApac;

	@Column(name = "apa_entr_cprh")
	@Temporal(TemporalType.DATE)
	private Date dataEntradaProcessoCprh;

	@Column(name = "out_dt_inicial")
	@Temporal(TemporalType.DATE)
	private Date dataInicioPrazoOutorga;

	@Column(name = "out_dt_final")
	@Temporal(TemporalType.DATE)
	private Date dataTerminoPrazoOutorga;

	@Column(name = "apa_garantia")
	private String garantia;

	@Column(name = "apa_nm_obra")
	private String nomeObra;

	@Column(name = "out_nu_ato")
	private String numeroAto;

	@Column(name = "apa_nu_notificacao")
	private String numeroNotificacaoIrregularidadeApac;

	@Column(name = "apa_nu_notificacao_isencao")
	private String numeroNotificacaoIsencaoApac;

	@Column(name = "apa_vz_requerida_horas_dia", columnDefinition ="numeric")
	private BigDecimal horasRequeridaParaCaptacaoPorDia;

	@Column(name = "apa_nu_termo")
	private String numeroTermo;

	@Column(name = "apa_outorga_jan")
	private boolean outorgaValidaJaneiro;

	@Column(name = "apa_outorga_fev")
	private boolean outorgaValidaFevereiro;

	@Column(name = "apa_outorga_mar")
	private boolean outorgaValidaMarco;

	@Column(name = "apa_outorga_abr")
	private boolean outorgaValidaAbril;

	@Column(name = "apa_outorga_mai")
	private boolean outorgaValidaMaio;

	@Column(name = "apa_outorga_jun")
	private boolean outorgaValidaJunho;

	@Column(name = "apa_outorga_jul")
	private boolean outorgaValidaJulho;

	@Column(name = "apa_outorga_ago")
	private boolean outorgaValidaAgosto;

	@Column(name = "apa_outorga_set")
	private boolean outorgaValidaSetembro;

	@Column(name = "apa_outorga_out")
	private boolean outorgaValidaOutubro;

	@Column(name = "apa_outorga_nov")
	private boolean outorgaValidaNovembro;

	@Column(name = "apa_outorga_dez")
	private boolean outorgaValidaDezembro;

	@Column(name = "apa_prazo_notificacao")
	@Temporal(TemporalType.DATE)
	private Date prazoNotificacao;

	@Column(name = "apa_prot_cprh")
	private String numeroProcessoNaCprh;

	@Column(name = "apa_obra_tp")
	private String tipoObra;

	@Column(name = "apa_vz_outorga_ls", columnDefinition="numeric")
	private BigDecimal vazaoOutorgada;

	@Column(name = "apa_vz_outorga_m3dia", columnDefinition="numeric")
	private BigDecimal vazaoOutorgadaMedia;

	@Column(name = "apa_vz_requerida_ls", columnDefinition="numeric")
	private BigDecimal vazaoRequiridaLs;

	@Column(name = "apa_vz_requerida_m3dia", columnDefinition="numeric")
	private BigDecimal vazaoRequiridaMediaDia;

	@Column(name = "out_tpo_cd", columnDefinition="out_tpo_enum")
	@Enumerated
	@Transient
	private CodigoIdentificador codigoIdentificador = CodigoIdentificador.CINCO;

	@Column(name = "out_tsp_cd", columnDefinition="out_tsp_enum")
	@Enumerated
	@Transient
	private CodigoIdentificador codigoIdentificadorAtoAdministrativo = CodigoIdentificador.SEIS;



	public String getAnalistaResponsavel() {
		return analistaResponsavel;
	}

	public void setAnalistaResponsavel(String analistaResponsavel) {
		this.analistaResponsavel = analistaResponsavel;
	}

	public String getAtoAdministrativoPublicacaoInstrumento() {
		return atoAdministrativoPublicacaoInstrumento;
	}

	public void setAtoAdministrativoPublicacaoInstrumento(
			String atoAdministrativoPublicacaoInstrumento) {
		this.atoAdministrativoPublicacaoInstrumento = atoAdministrativoPublicacaoInstrumento;
	}

	public Date getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public Date getDataVencimentoContrato() {
		return dataVencimentoContrato;
	}

	public void setDataVencimentoContrato(Date dataVencimentoContrato) {
		this.dataVencimentoContrato = dataVencimentoContrato;
	}

	public Date getDataEntradaProcessoApac() {
		return dataEntradaProcessoApac;
	}

	public void setDataEntradaProcessoApac(Date dataEntradaProcessoApac) {
		this.dataEntradaProcessoApac = dataEntradaProcessoApac;
	}

	public Date getDataEntradaProcessoCprh() {
		return dataEntradaProcessoCprh;
	}

	public void setDataEntradaProcessoCprh(Date dataEntradaProcessoCprh) {
		this.dataEntradaProcessoCprh = dataEntradaProcessoCprh;
	}

	public Date getDataInicioPrazoOutorga() {
		return dataInicioPrazoOutorga;
	}

	public void setDataInicioPrazoOutorga(Date dataInicioPrazoOutorga) {
		this.dataInicioPrazoOutorga = dataInicioPrazoOutorga;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public Date getDataTerminoPrazoOutorga() {
		return dataTerminoPrazoOutorga;
	}

	public void setDataTerminoPrazoOutorga(Date dataTerminoPrazoOutorga) {
		this.dataTerminoPrazoOutorga = dataTerminoPrazoOutorga;
	}

	public String getNomeObra() {
		return nomeObra;
	}

	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}

	public String getNumeroAto() {
		return numeroAto;
	}

	public void setNumeroAto(String numeroAto) {
		this.numeroAto = numeroAto;
	}

	public String getNumeroNotificacaoIrregularidadeApac() {
		return numeroNotificacaoIrregularidadeApac;
	}

	public void setNumeroNotificacaoIrregularidadeApac(
			String numeroNotificacaoIrregularidadeApac) {
		this.numeroNotificacaoIrregularidadeApac = numeroNotificacaoIrregularidadeApac;
	}

	public String getNumeroNotificacaoIsencaoApac() {
		return numeroNotificacaoIsencaoApac;
	}

	public void setNumeroNotificacaoIsencaoApac(
			String numeroNotificacaoIsencaoApac) {
		this.numeroNotificacaoIsencaoApac = numeroNotificacaoIsencaoApac;
	}

	public BigDecimal getHorasRequeridaParaCaptacaoPorDia() {
		return horasRequeridaParaCaptacaoPorDia;
	}

	public void setHorasRequeridaParaCaptacaoPorDia(
			BigDecimal horasRequeridaParaCaptacaoPorDia) {
		this.horasRequeridaParaCaptacaoPorDia = horasRequeridaParaCaptacaoPorDia;
	}

	public boolean isOutorgaValidaJaneiro() {
		return outorgaValidaJaneiro;
	}

	public void setOutorgaValidaJaneiro(boolean outorgaValidaJaneiro) {
		this.outorgaValidaJaneiro = outorgaValidaJaneiro;
	}

	public boolean isOutorgaValidaFevereiro() {
		return outorgaValidaFevereiro;
	}

	public void setOutorgaValidaFevereiro(boolean outorgaValidaFevereiro) {
		this.outorgaValidaFevereiro = outorgaValidaFevereiro;
	}

	public boolean isOutorgaValidaMarco() {
		return outorgaValidaMarco;
	}

	public void setOutorgaValidaMarco(boolean outorgaValidaMarco) {
		this.outorgaValidaMarco = outorgaValidaMarco;
	}

	public boolean isOutorgaValidaAbril() {
		return outorgaValidaAbril;
	}

	public void setOutorgaValidaAbril(boolean outorgaValidaAbril) {
		this.outorgaValidaAbril = outorgaValidaAbril;
	}

	public boolean isOutorgaValidaMaio() {
		return outorgaValidaMaio;
	}

	public void setOutorgaValidaMaio(boolean outorgaValidaMaio) {
		this.outorgaValidaMaio = outorgaValidaMaio;
	}

	public boolean isOutorgaValidaJunho() {
		return outorgaValidaJunho;
	}

	public void setOutorgaValidaJunho(boolean outorgaValidaJunho) {
		this.outorgaValidaJunho = outorgaValidaJunho;
	}

	public boolean isOutorgaValidaJulho() {
		return outorgaValidaJulho;
	}

	public void setOutorgaValidaJulho(boolean outorgaValidaJulho) {
		this.outorgaValidaJulho = outorgaValidaJulho;
	}

	public boolean isOutorgaValidaAgosto() {
		return outorgaValidaAgosto;
	}

	public void setOutorgaValidaAgosto(boolean outorgaValidaAgosto) {
		this.outorgaValidaAgosto = outorgaValidaAgosto;
	}

	public boolean isOutorgaValidaSetembro() {
		return outorgaValidaSetembro;
	}

	public void setOutorgaValidaSetembro(boolean outorgaValidaSetembro) {
		this.outorgaValidaSetembro = outorgaValidaSetembro;
	}

	public boolean isOutorgaValidaOutubro() {
		return outorgaValidaOutubro;
	}

	public void setOutorgaValidaOutubro(boolean outorgaValidaOutubro) {
		this.outorgaValidaOutubro = outorgaValidaOutubro;
	}

	public boolean isOutorgaValidaNovembro() {
		return outorgaValidaNovembro;
	}

	public void setOutorgaValidaNovembro(boolean outorgaValidaNovembro) {
		this.outorgaValidaNovembro = outorgaValidaNovembro;
	}

	public boolean isOutorgaValidaDezembro() {
		return outorgaValidaDezembro;
	}

	public void setOutorgaValidaDezembro(boolean outorgaValidaDezembro) {
		this.outorgaValidaDezembro = outorgaValidaDezembro;
	}

	public Date getPrazoNotificacao() {
		return prazoNotificacao;
	}

	public void setPrazoNotificacao(Date prazoNotificacao) {
		this.prazoNotificacao = prazoNotificacao;
	}

	public String getNumeroProcessoNaCprh() {
		return numeroProcessoNaCprh;
	}

	public void setNumeroProcessoNaCprh(String numeroProcessoNaCprh) {
		this.numeroProcessoNaCprh = numeroProcessoNaCprh;
	}

	public String getTipoObra() {
		return tipoObra;
	}

	public void setTipoObra(String tipoObra) {
		this.tipoObra = tipoObra;
	}

	public BigDecimal getVazaoOutorgada() {
		return vazaoOutorgada;
	}

	public void setVazaoOutorgada(BigDecimal vazaoOutorgada) {
		this.vazaoOutorgada = vazaoOutorgada;
	}

	public BigDecimal getVazaoRequiridaLs() {
		return vazaoRequiridaLs;
	}

	public void setVazaoRequiridaLs(BigDecimal vazaoRequiridaLs) {
		this.vazaoRequiridaLs = vazaoRequiridaLs;
	}

	public BigDecimal getVazaoRequiridaMediaDia() {
		return vazaoRequiridaMediaDia;
	}

	public void setVazaoRequiridaMediaDia(BigDecimal vazaoRequiridaMediaDia) {
		this.vazaoRequiridaMediaDia = vazaoRequiridaMediaDia;
	}

	public CodigoIdentificador getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public void setCodigoIdentificador(CodigoIdentificador codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}

	public CodigoIdentificador getCodigoIdentificadorAtoAdministrativo() {
		return codigoIdentificadorAtoAdministrativo;
	}

	public void setCodigoIdentificadorAtoAdministrativo(
			CodigoIdentificador codigoIdentificadorAtoAdministrativo) {
		this.codigoIdentificadorAtoAdministrativo = codigoIdentificadorAtoAdministrativo;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getNumeroTermo() {
		return numeroTermo;
	}

	public void setNumeroTermo(String numeroTermo) {
		this.numeroTermo = numeroTermo;
	}

	public BigDecimal getVazaoOutorgadaMedia() {
		return vazaoOutorgadaMedia;
	}

	public void setVazaoOutorgadaMedia(BigDecimal vazaoOutorgadaMedia) {
		this.vazaoOutorgadaMedia = vazaoOutorgadaMedia;
	}

}
