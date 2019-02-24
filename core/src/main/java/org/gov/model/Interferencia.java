package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name= "tb_interferencia")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Interferencia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name ="int_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "tb_interferencia_int_id_seq")
	private Integer id;

	@Column(name="apa_est_hidrologico")
	private Boolean haEstudoHidrologicoDaArea;

	@Column(name="fot_cap_lanc_geral", columnDefinition="text")
	private String linkFotoPontoCapturaVisaoGeral;

	@Column(name="int_cr_latitude")
	private BigDecimal latitudeLocalizacaoPontoInterferencia;

	@Column(name="int_cr_longitude")
	private BigDecimal longitudeLocalizacaoPontoInterferencia;

	@Column(name="fot_cap_lanc_detalhe", columnDefinition="text")
	private String linkFotoPontoCapturaVisaoDetalhada;

	@Column(name="fot_croqui_localizacao", columnDefinition="text")
	private String linkImagemCroquiLocalizacao;

	@Column(name="apa_curso_barragem")
	private String localInterferencia;

	@Column(name="apa_curso")
	private String nomeCursoAgua;

	@Column(name="apa_presenca_barramento")
	private Boolean presencaAusenciaBarramentoParaCaptacao;

	@Column(name="apa_barragem")
	private String barragemOndeFeitaCaptacao;

	@Column(name="apa_cap_maxacumula")
	private BigDecimal capacidadeMaximaAcumulacao;

	@Column(name="apa_bacia")
	private String baciaHidrograficaOndeEstaInseridaCaptacao;

	private String cnarh_id;

	@Column(name="out_nu_processo")
	private String numeroProcesso;

	@Column(name="emp_id")
	private Integer idEmpreendimento;


	@Enumerated(EnumType.STRING)
	@Column(name ="int_tsi_cd", columnDefinition="int_tsi_enum")
	@Type(type = "pgsql_enum")
	@Transient
	private Int_tsi_cd codigoIdentificadorSituacaoInterferencia;

	@Enumerated(EnumType.STRING)
	@Column(name ="fin_tfn_cd", columnDefinition="fin_tfn_enum")
	@Type(type = "pgsql_enum")
	@Transient
	private Fin_tfn_cd codigoIdentificadorTipoFinalidade;


	@Enumerated(EnumType.STRING)
	@Column(name ="fou_tou_cd", columnDefinition="fou_tou_enum")
	@Type(type = "pgsql_enum")
	@Transient
	private Fou_tou_cd codigoIdentificadorTipoOutroUso;


	@Enumerated(EnumType.STRING)
	@Column(name ="int_tin_cd", columnDefinition="int_tin_enum")
	@Type(type = "pgsql_enum")
	@Transient
	private Int_tin_cd codigoIdentificadorTipoInterferencia;

	@Column(name="fou_tou_tp_outro", columnDefinition="text")
	private String tipoFinalidadeTipoDoUsoAusente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getHaEstudoHidrologicoDaArea() {
		return haEstudoHidrologicoDaArea;
	}

	public void setHaEstudoHidrologicoDaArea(Boolean haEstudoHidrologicoDaArea) {
		this.haEstudoHidrologicoDaArea = haEstudoHidrologicoDaArea;
	}

	public String getLinkFotoPontoCapturaVisaoGeral() {
		return linkFotoPontoCapturaVisaoGeral;
	}

	public void setLinkFotoPontoCapturaVisaoGeral(
			String linkFotoPontoCapturaVisaoGeral) {
		this.linkFotoPontoCapturaVisaoGeral = linkFotoPontoCapturaVisaoGeral;
	}

	public BigDecimal getLatitudeLocalizacaoPontoInterferencia() {
		return latitudeLocalizacaoPontoInterferencia;
	}

	public void setLatitudeLocalizacaoPontoInterferencia(
			BigDecimal latitudeLocalizacaoPontoInterferencia) {
		this.latitudeLocalizacaoPontoInterferencia = latitudeLocalizacaoPontoInterferencia;
	}

	public BigDecimal getLongitudeLocalizacaoPontoInterferencia() {
		return longitudeLocalizacaoPontoInterferencia;
	}

	public void setLongitudeLocalizacaoPontoInterferencia(
			BigDecimal longitudeLocalizacaoPontoInterferencia) {
		this.longitudeLocalizacaoPontoInterferencia = longitudeLocalizacaoPontoInterferencia;
	}

	public String getLinkFotoPontoCapturaVisaoDetalhada() {
		return linkFotoPontoCapturaVisaoDetalhada;
	}

	public void setLinkFotoPontoCapturaVisaoDetalhada(
			String linkFotoPontoCapturaVisaoDetalhada) {
		this.linkFotoPontoCapturaVisaoDetalhada = linkFotoPontoCapturaVisaoDetalhada;
	}

	public String getLinkImagemCroquiLocalizacao() {
		return linkImagemCroquiLocalizacao;
	}

	public void setLinkImagemCroquiLocalizacao(
			String linkImagemCroquiLocalizacao) {
		this.linkImagemCroquiLocalizacao = linkImagemCroquiLocalizacao;
	}

	public String getLocalInterferencia() {
		return localInterferencia;
	}

	public void setLocalInterferencia(String localInterferencia) {
		this.localInterferencia = localInterferencia;
	}

	public String getNomeCursoAgua() {
		return nomeCursoAgua;
	}

	public void setNomeCursoAgua(String nomeCursoAgua) {
		this.nomeCursoAgua = nomeCursoAgua;
	}

	public Boolean getPresencaAusenciaBarramentoParaCaptacao() {
		return presencaAusenciaBarramentoParaCaptacao;
	}

	public void setPresencaAusenciaBarramentoParaCaptacao(
			Boolean presencaAusenciaBarramentoParaCaptacao) {
		this.presencaAusenciaBarramentoParaCaptacao = presencaAusenciaBarramentoParaCaptacao;
	}

	public String getBarragemOndeFeitaCaptacao() {
		return barragemOndeFeitaCaptacao;
	}

	public void setBarragemOndeFeitaCaptacao(String barragemOndeFeitaCaptacao) {
		this.barragemOndeFeitaCaptacao = barragemOndeFeitaCaptacao;
	}

	public BigDecimal getCapacidadeMaximaAcumulacao() {
		return capacidadeMaximaAcumulacao;
	}

	public void setCapacidadeMaximaAcumulacao(BigDecimal capacidadeMaximaAcumulacao) {
		this.capacidadeMaximaAcumulacao = capacidadeMaximaAcumulacao;
	}

	public String getBaciaHidrograficaOndeEstaInseridaCaptacao() {
		return baciaHidrograficaOndeEstaInseridaCaptacao;
	}

	public void setBaciaHidrograficaOndeEstaInseridaCaptacao(
			String baciaHidrograficaOndeEstaInseridaCaptacao) {
		this.baciaHidrograficaOndeEstaInseridaCaptacao = baciaHidrograficaOndeEstaInseridaCaptacao;
	}

	public String getCnarh_id() {
		return cnarh_id;
	}

	public void setCnarh_id(String cnarh_id) {
		this.cnarh_id = cnarh_id;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Integer getIdEmpreendimento() {
		return idEmpreendimento;
	}

	public void setIdEmpreendimento(Integer idEmpreendimento) {
		this.idEmpreendimento = idEmpreendimento;
	}

	public Int_tsi_cd getCodigoIdentificadorSituacaoInterferencia() {
		return codigoIdentificadorSituacaoInterferencia;
	}

	public void setCodigoIdentificadorSituacaoInterferencia(
			Int_tsi_cd codigoIdentificadorSituacaoInterferencia) {
		this.codigoIdentificadorSituacaoInterferencia = codigoIdentificadorSituacaoInterferencia;
	}

	public Fin_tfn_cd getCodigoIdentificadorTipoFinalidade() {
		return codigoIdentificadorTipoFinalidade;
	}

	public void setCodigoIdentificadorTipoFinalidade(
			Fin_tfn_cd codigoIdentificadorTipoFinalidade) {
		this.codigoIdentificadorTipoFinalidade = codigoIdentificadorTipoFinalidade;
	}

	public Fou_tou_cd getCodigoIdentificadorTipoOutroUso() {
		return codigoIdentificadorTipoOutroUso;
	}

	public void setCodigoIdentificadorTipoOutroUso(
			Fou_tou_cd codigoIdentificadorTipoOutroUso) {
		this.codigoIdentificadorTipoOutroUso = codigoIdentificadorTipoOutroUso;
	}

	public Int_tin_cd getCodigoIdentificadorTipoInterferencia() {
		return codigoIdentificadorTipoInterferencia;
	}

	public void setCodigoIdentificadorTipoInterferencia(
			Int_tin_cd codigoIdentificadorTipoInterferencia) {
		this.codigoIdentificadorTipoInterferencia = codigoIdentificadorTipoInterferencia;
	}

	public String getTipoFinalidadeTipoDoUsoAusente() {
		return tipoFinalidadeTipoDoUsoAusente;
	}

	public void setTipoFinalidadeTipoDoUsoAusente(
			String tipoFinalidadeTipoDoUsoAusente) {
		this.tipoFinalidadeTipoDoUsoAusente = tipoFinalidadeTipoDoUsoAusente;
	}




}
