<<<<<<< HEAD
package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name= "tb_apac")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
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
	private Boolean outorgaValidaJaneiro;

	@Column(name = "apa_outorga_fev")
	private Boolean outorgaValidaFevereiro;

	@Column(name = "apa_outorga_mar")
	private Boolean outorgaValidaMarco;

	@Column(name = "apa_outorga_abr")
	private Boolean outorgaValidaAbril;

	@Column(name = "apa_outorga_mai")
	private Boolean outorgaValidaMaio;

	@Column(name = "apa_outorga_jun")
	private Boolean outorgaValidaJunho;

	@Column(name = "apa_outorga_jul")
	private Boolean outorgaValidaJulho;

	@Column(name = "apa_outorga_ago")
	private Boolean outorgaValidaAgosto;

	@Column(name = "apa_outorga_set")
	private Boolean outorgaValidaSetembro;

	@Column(name = "apa_outorga_out")
	private Boolean outorgaValidaOutubro;

	@Column(name = "apa_outorga_nov")
	private Boolean outorgaValidaNovembro;

	@Column(name = "apa_outorga_dez")
	private Boolean outorgaValidaDezembro;

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

	@Enumerated(EnumType.STRING)
	@Column(name = "out_tpo_cd")
	@Type( type = "pgsql_enum" )
	@Transient
	private Out_tpo_cd out_tpo_cd = Out_tpo_cd.LICENCA_AUTORIZACAO_PERFURACAO_POCOS;

	@Column(name = "out_tsp_cd", columnDefinition="out_tsp_enum")
	@Enumerated
	@Transient
	private String out_tsp_cd;


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

	public Boolean getOutorgaValidaJaneiro() {
		return outorgaValidaJaneiro;
	}

	public void setOutorgaValidaJaneiro(Boolean outorgaValidaJaneiro) {
		this.outorgaValidaJaneiro = outorgaValidaJaneiro;
	}

	public Boolean getOutorgaValidaFevereiro() {
		return outorgaValidaFevereiro;
	}

	public void setOutorgaValidaFevereiro(Boolean outorgaValidaFevereiro) {
		this.outorgaValidaFevereiro = outorgaValidaFevereiro;
	}

	public Boolean getOutorgaValidaMarco() {
		return outorgaValidaMarco;
	}

	public void setOutorgaValidaMarco(Boolean outorgaValidaMarco) {
		this.outorgaValidaMarco = outorgaValidaMarco;
	}

	public Boolean getOutorgaValidaAbril() {
		return outorgaValidaAbril;
	}

	public void setOutorgaValidaAbril(Boolean outorgaValidaAbril) {
		this.outorgaValidaAbril = outorgaValidaAbril;
	}

	public Boolean getOutorgaValidaMaio() {
		return outorgaValidaMaio;
	}

	public void setOutorgaValidaMaio(Boolean outorgaValidaMaio) {
		this.outorgaValidaMaio = outorgaValidaMaio;
	}

	public Boolean getOutorgaValidaJunho() {
		return outorgaValidaJunho;
	}

	public void setOutorgaValidaJunho(Boolean outorgaValidaJunho) {
		this.outorgaValidaJunho = outorgaValidaJunho;
	}

	public Boolean getOutorgaValidaJulho() {
		return outorgaValidaJulho;
	}

	public void setOutorgaValidaJulho(Boolean outorgaValidaJulho) {
		this.outorgaValidaJulho = outorgaValidaJulho;
	}

	public Boolean getOutorgaValidaAgosto() {
		return outorgaValidaAgosto;
	}

	public void setOutorgaValidaAgosto(Boolean outorgaValidaAgosto) {
		this.outorgaValidaAgosto = outorgaValidaAgosto;
	}

	public Boolean getOutorgaValidaSetembro() {
		return outorgaValidaSetembro;
	}

	public void setOutorgaValidaSetembro(Boolean outorgaValidaSetembro) {
		this.outorgaValidaSetembro = outorgaValidaSetembro;
	}

	public Boolean getOutorgaValidaOutubro() {
		return outorgaValidaOutubro;
	}

	public void setOutorgaValidaOutubro(Boolean outorgaValidaOutubro) {
		this.outorgaValidaOutubro = outorgaValidaOutubro;
	}

	public Boolean getOutorgaValidaNovembro() {
		return outorgaValidaNovembro;
	}

	public void setOutorgaValidaNovembro(Boolean outorgaValidaNovembro) {
		this.outorgaValidaNovembro = outorgaValidaNovembro;
	}

	public Boolean getOutorgaValidaDezembro() {
		return outorgaValidaDezembro;
	}

	public void setOutorgaValidaDezembro(Boolean outorgaValidaDezembro) {
		this.outorgaValidaDezembro = outorgaValidaDezembro;
	}

	public Out_tpo_cd getOut_tpo_cd() {
		return out_tpo_cd;
	}

	public void setOut_tpo_cd(Out_tpo_cd out_tpo_cd) {
		this.out_tpo_cd = out_tpo_cd;
	}

}
=======
package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name= "tb_apac")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
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
	private Boolean outorgaValidaJaneiro;

	@Column(name = "apa_outorga_fev")
	private Boolean outorgaValidaFevereiro;

	@Column(name = "apa_outorga_mar")
	private Boolean outorgaValidaMarco;

	@Column(name = "apa_outorga_abr")
	private Boolean outorgaValidaAbril;

	@Column(name = "apa_outorga_mai")
	private Boolean outorgaValidaMaio;

	@Column(name = "apa_outorga_jun")
	private Boolean outorgaValidaJunho;

	@Column(name = "apa_outorga_jul")
	private Boolean outorgaValidaJulho;

	@Column(name = "apa_outorga_ago")
	private Boolean outorgaValidaAgosto;

	@Column(name = "apa_outorga_set")
	private Boolean outorgaValidaSetembro;

	@Column(name = "apa_outorga_out")
	private Boolean outorgaValidaOutubro;

	@Column(name = "apa_outorga_nov")
	private Boolean outorgaValidaNovembro;

	@Column(name = "apa_outorga_dez")
	private Boolean outorgaValidaDezembro;

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


	//Problema
	@Enumerated(EnumType.STRING)
	@Column(name = "out_tpo_cd", columnDefinition = "varchar(50)")
	@Type(type = "org.gov.util.PostgreSQLEnumType")
//	@Transient
	private Out_tpo_cd out_tpo_cd = Out_tpo_cd.CADASTRO;

	//Ignorar
	@Column(name = "out_tsp_cd", columnDefinition="out_tsp_enum")
	@Enumerated
	@Transient
	private String out_tsp_cd;


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

	public Boolean getOutorgaValidaJaneiro() {
		return outorgaValidaJaneiro;
	}

	public void setOutorgaValidaJaneiro(Boolean outorgaValidaJaneiro) {
		this.outorgaValidaJaneiro = outorgaValidaJaneiro;
	}

	public Boolean getOutorgaValidaFevereiro() {
		return outorgaValidaFevereiro;
	}

	public void setOutorgaValidaFevereiro(Boolean outorgaValidaFevereiro) {
		this.outorgaValidaFevereiro = outorgaValidaFevereiro;
	}

	public Boolean getOutorgaValidaMarco() {
		return outorgaValidaMarco;
	}

	public void setOutorgaValidaMarco(Boolean outorgaValidaMarco) {
		this.outorgaValidaMarco = outorgaValidaMarco;
	}

	public Boolean getOutorgaValidaAbril() {
		return outorgaValidaAbril;
	}

	public void setOutorgaValidaAbril(Boolean outorgaValidaAbril) {
		this.outorgaValidaAbril = outorgaValidaAbril;
	}

	public Boolean getOutorgaValidaMaio() {
		return outorgaValidaMaio;
	}

	public void setOutorgaValidaMaio(Boolean outorgaValidaMaio) {
		this.outorgaValidaMaio = outorgaValidaMaio;
	}

	public Boolean getOutorgaValidaJunho() {
		return outorgaValidaJunho;
	}

	public void setOutorgaValidaJunho(Boolean outorgaValidaJunho) {
		this.outorgaValidaJunho = outorgaValidaJunho;
	}

	public Boolean getOutorgaValidaJulho() {
		return outorgaValidaJulho;
	}

	public void setOutorgaValidaJulho(Boolean outorgaValidaJulho) {
		this.outorgaValidaJulho = outorgaValidaJulho;
	}

	public Boolean getOutorgaValidaAgosto() {
		return outorgaValidaAgosto;
	}

	public void setOutorgaValidaAgosto(Boolean outorgaValidaAgosto) {
		this.outorgaValidaAgosto = outorgaValidaAgosto;
	}

	public Boolean getOutorgaValidaSetembro() {
		return outorgaValidaSetembro;
	}

	public void setOutorgaValidaSetembro(Boolean outorgaValidaSetembro) {
		this.outorgaValidaSetembro = outorgaValidaSetembro;
	}

	public Boolean getOutorgaValidaOutubro() {
		return outorgaValidaOutubro;
	}

	public void setOutorgaValidaOutubro(Boolean outorgaValidaOutubro) {
		this.outorgaValidaOutubro = outorgaValidaOutubro;
	}

	public Boolean getOutorgaValidaNovembro() {
		return outorgaValidaNovembro;
	}

	public void setOutorgaValidaNovembro(Boolean outorgaValidaNovembro) {
		this.outorgaValidaNovembro = outorgaValidaNovembro;
	}

	public Boolean getOutorgaValidaDezembro() {
		return outorgaValidaDezembro;
	}

	public void setOutorgaValidaDezembro(Boolean outorgaValidaDezembro) {
		this.outorgaValidaDezembro = outorgaValidaDezembro;
	}

	public Out_tpo_cd getOut_tpo_cd() {
		return out_tpo_cd;
	}

	public void setOut_tpo_cd(Out_tpo_cd out_tpo_cd) {
		this.out_tpo_cd = out_tpo_cd;
	}

}
>>>>>>> 9e3196cc05d2f8ea32495748eea0c8419f2ba301
