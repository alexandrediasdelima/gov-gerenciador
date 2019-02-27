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

	@Column(name="cnarh_id")
	private String cnarh_id;

	@Column(name="out_nu_processo")
	private String numeroProcesso;

	@Column(name="emp_id")
	private Integer idEmpreendimento;

	@Column(name ="int_tsi_cd")
	private String codigoIdentificadorSituacaoInterferencia;

	@Column(name ="fin_tfn_cd")
	private String codigoIdentificadorTipoFinalidade;

	@Column(name ="fou_tou_cd")
	private String codigoIdentificadorTipoOutroUso;

	@Column(name ="int_tin_cd")
	private String codigoIdentificadorTipoInterferencia;

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

	public void setLinkFotoPontoCapturaVisaoGeral(String linkFotoPontoCapturaVisaoGeral) {
		this.linkFotoPontoCapturaVisaoGeral = linkFotoPontoCapturaVisaoGeral;
	}

	public BigDecimal getLatitudeLocalizacaoPontoInterferencia() {
		return latitudeLocalizacaoPontoInterferencia;
	}

	public void setLatitudeLocalizacaoPontoInterferencia(BigDecimal latitudeLocalizacaoPontoInterferencia) {
		this.latitudeLocalizacaoPontoInterferencia = latitudeLocalizacaoPontoInterferencia;
	}

	public BigDecimal getLongitudeLocalizacaoPontoInterferencia() {
		return longitudeLocalizacaoPontoInterferencia;
	}

	public void setLongitudeLocalizacaoPontoInterferencia(BigDecimal longitudeLocalizacaoPontoInterferencia) {
		this.longitudeLocalizacaoPontoInterferencia = longitudeLocalizacaoPontoInterferencia;
	}

	public String getLinkFotoPontoCapturaVisaoDetalhada() {
		return linkFotoPontoCapturaVisaoDetalhada;
	}

	public void setLinkFotoPontoCapturaVisaoDetalhada(String linkFotoPontoCapturaVisaoDetalhada) {
		this.linkFotoPontoCapturaVisaoDetalhada = linkFotoPontoCapturaVisaoDetalhada;
	}

	public String getLinkImagemCroquiLocalizacao() {
		return linkImagemCroquiLocalizacao;
	}

	public void setLinkImagemCroquiLocalizacao(String linkImagemCroquiLocalizacao) {
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

	public void setPresencaAusenciaBarramentoParaCaptacao(Boolean presencaAusenciaBarramentoParaCaptacao) {
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

	public void setBaciaHidrograficaOndeEstaInseridaCaptacao(String baciaHidrograficaOndeEstaInseridaCaptacao) {
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

	public String getCodigoIdentificadorSituacaoInterferencia() {
		return codigoIdentificadorSituacaoInterferencia;
	}

	public void setCodigoIdentificadorSituacaoInterferencia(String codigoIdentificadorSituacaoInterferencia) {
		this.codigoIdentificadorSituacaoInterferencia = codigoIdentificadorSituacaoInterferencia;
	}

	public String getCodigoIdentificadorTipoFinalidade() {
		return codigoIdentificadorTipoFinalidade;
	}

	public void setCodigoIdentificadorTipoFinalidade(String codigoIdentificadorTipoFinalidade) {
		this.codigoIdentificadorTipoFinalidade = codigoIdentificadorTipoFinalidade;
	}

	public String getCodigoIdentificadorTipoOutroUso() {
		return codigoIdentificadorTipoOutroUso;
	}

	public void setCodigoIdentificadorTipoOutroUso(String codigoIdentificadorTipoOutroUso) {
		this.codigoIdentificadorTipoOutroUso = codigoIdentificadorTipoOutroUso;
	}

	public String getCodigoIdentificadorTipoInterferencia() {
		return codigoIdentificadorTipoInterferencia;
	}

	public void setCodigoIdentificadorTipoInterferencia(String codigoIdentificadorTipoInterferencia) {
		this.codigoIdentificadorTipoInterferencia = codigoIdentificadorTipoInterferencia;
	}

	public String getTipoFinalidadeTipoDoUsoAusente() {
		return tipoFinalidadeTipoDoUsoAusente;
	}

	public void setTipoFinalidadeTipoDoUsoAusente(String tipoFinalidadeTipoDoUsoAusente) {
		this.tipoFinalidadeTipoDoUsoAusente = tipoFinalidadeTipoDoUsoAusente;
	}

}
