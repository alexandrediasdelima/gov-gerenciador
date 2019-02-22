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
@Table(name= "tb_asbtst")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Asbtst implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="tst_int_pfk", nullable=false)
	@Id
	private int tst_int_pfk;
	
	@Column(name="asb_aqp_cd", columnDefinition="numeric")
	private BigDecimal asb_aqp_cd;
	
	@Column(name="asb_dt_instalacao", columnDefinition="date")
	private Date asb_dt_instalacao;
	
	@Column(name="asb_nu_alturabocatubo", columnDefinition="numeric")
	private BigDecimal asb_nu_alturabocatubo;
	
	@Column(name="asb_nu_base", columnDefinition="numeric")
	private BigDecimal asb_nu_base;
	
	@Column(name="asb_nu_cotaterreno", columnDefinition="numeric")
	private BigDecimal asb_nu_cotaterreno;
	
	@Column(name="asb_nu_diametrofiltro", columnDefinition="numeric")
	private BigDecimal asb_nu_diametrofiltro;
	
	@Column(name="asb_nu_diametroperfuracao", columnDefinition="numeric")
	private BigDecimal asb_nu_diametroperfuracao;
	
	@Column(name="asb_nu_topo", columnDefinition="numeric")
	private BigDecimal asb_nu_topo;
	
	@Column(name="asb_tca_cd", columnDefinition="numeric")
	private BigDecimal asb_tca_cd;
	
	@Column(name="asb_tnp_cd", columnDefinition="numeric")
	private BigDecimal asb_tnp_cd;
	
	@Column(name="asb_tpn_cd", columnDefinition="numeric")
	private BigDecimal asb_tpn_cd;
	
	@Column(name="tst_ds_tempoduracao")
	private String tst_ds_tempoduracao;
	
	@Column(name="tst_dt", columnDefinition="date")
	private Date tst_dt;
	
	@Column(name="tst_nu_coeficientearmazenamento", columnDefinition="numeric")
	private BigDecimal tst_nu_coeficientearmazenamento;
	
	@Column(name="tst_nu_condutividadehidraulica", columnDefinition="numeric")
	private BigDecimal tst_nu_condutividadehidraulica;
	
	@Column(name="tst_nu_nd", columnDefinition="numeric")
	private BigDecimal tst_nu_nd;
	
	@Column(name="tst_nu_ne", columnDefinition="numeric")
	private BigDecimal tst_nu_ne;
	
	@Column(name="tst_nu_permeabilidade", columnDefinition="numeric")
	private BigDecimal tst_nu_permeabilidade;
	
	@Column(name="tst_nu_transmissividade", columnDefinition="numeric")
	private BigDecimal tst_nu_transmissividade;
	
	@Column(name="tst_tmi_cd", columnDefinition="numeric")
	private BigDecimal tst_tmi_cd;
	
	@Column(name="tst_ttb_cd", columnDefinition="numeric")
	private BigDecimal tst_ttb_cd;
	
	@Column(name="tst_vz_estabilizacao", columnDefinition="numeric")
	private BigDecimal tst_vz_estabilizacao;

	public int getTst_int_pfk() {
		return tst_int_pfk;
	}

	public void setTst_int_pfk(int tst_int_pfk) {
		this.tst_int_pfk = tst_int_pfk;
	}

	public BigDecimal getAsb_aqp_cd() {
		return asb_aqp_cd;
	}

	public void setAsb_aqp_cd(BigDecimal asb_aqp_cd) {
		this.asb_aqp_cd = asb_aqp_cd;
	}

	public Date getAsb_dt_instalacao() {
		return asb_dt_instalacao;
	}

	public void setAsb_dt_instalacao(Date asb_dt_instalacao) {
		this.asb_dt_instalacao = asb_dt_instalacao;
	}

	public BigDecimal getAsb_nu_alturabocatubo() {
		return asb_nu_alturabocatubo;
	}

	public void setAsb_nu_alturabocatubo(BigDecimal asb_nu_alturabocatubo) {
		this.asb_nu_alturabocatubo = asb_nu_alturabocatubo;
	}

	public BigDecimal getAsb_nu_base() {
		return asb_nu_base;
	}

	public void setAsb_nu_base(BigDecimal asb_nu_base) {
		this.asb_nu_base = asb_nu_base;
	}

	public BigDecimal getAsb_nu_cotaterreno() {
		return asb_nu_cotaterreno;
	}

	public void setAsb_nu_cotaterreno(BigDecimal asb_nu_cotaterreno) {
		this.asb_nu_cotaterreno = asb_nu_cotaterreno;
	}

	public BigDecimal getAsb_nu_diametrofiltro() {
		return asb_nu_diametrofiltro;
	}

	public void setAsb_nu_diametrofiltro(BigDecimal asb_nu_diametrofiltro) {
		this.asb_nu_diametrofiltro = asb_nu_diametrofiltro;
	}

	public BigDecimal getAsb_nu_diametroperfuracao() {
		return asb_nu_diametroperfuracao;
	}

	public void setAsb_nu_diametroperfuracao(BigDecimal asb_nu_diametroperfuracao) {
		this.asb_nu_diametroperfuracao = asb_nu_diametroperfuracao;
	}

	public BigDecimal getAsb_nu_topo() {
		return asb_nu_topo;
	}

	public void setAsb_nu_topo(BigDecimal asb_nu_topo) {
		this.asb_nu_topo = asb_nu_topo;
	}

	public BigDecimal getAsb_tca_cd() {
		return asb_tca_cd;
	}

	public void setAsb_tca_cd(BigDecimal asb_tca_cd) {
		this.asb_tca_cd = asb_tca_cd;
	}

	public BigDecimal getAsb_tnp_cd() {
		return asb_tnp_cd;
	}

	public void setAsb_tnp_cd(BigDecimal asb_tnp_cd) {
		this.asb_tnp_cd = asb_tnp_cd;
	}

	public BigDecimal getAsb_tpn_cd() {
		return asb_tpn_cd;
	}

	public void setAsb_tpn_cd(BigDecimal asb_tpn_cd) {
		this.asb_tpn_cd = asb_tpn_cd;
	}

	public String getTst_ds_tempoduracao() {
		return tst_ds_tempoduracao;
	}

	public void setTst_ds_tempoduracao(String tst_ds_tempoduracao) {
		this.tst_ds_tempoduracao = tst_ds_tempoduracao;
	}

	public Date getTst_dt() {
		return tst_dt;
	}

	public void setTst_dt(Date tst_dt) {
		this.tst_dt = tst_dt;
	}

	public BigDecimal getTst_nu_coeficientearmazenamento() {
		return tst_nu_coeficientearmazenamento;
	}

	public void setTst_nu_coeficientearmazenamento(BigDecimal tst_nu_coeficientearmazenamento) {
		this.tst_nu_coeficientearmazenamento = tst_nu_coeficientearmazenamento;
	}

	public BigDecimal getTst_nu_condutividadehidraulica() {
		return tst_nu_condutividadehidraulica;
	}

	public void setTst_nu_condutividadehidraulica(BigDecimal tst_nu_condutividadehidraulica) {
		this.tst_nu_condutividadehidraulica = tst_nu_condutividadehidraulica;
	}

	public BigDecimal getTst_nu_nd() {
		return tst_nu_nd;
	}

	public void setTst_nu_nd(BigDecimal tst_nu_nd) {
		this.tst_nu_nd = tst_nu_nd;
	}

	public BigDecimal getTst_nu_ne() {
		return tst_nu_ne;
	}

	public void setTst_nu_ne(BigDecimal tst_nu_ne) {
		this.tst_nu_ne = tst_nu_ne;
	}

	public BigDecimal getTst_nu_permeabilidade() {
		return tst_nu_permeabilidade;
	}

	public void setTst_nu_permeabilidade(BigDecimal tst_nu_permeabilidade) {
		this.tst_nu_permeabilidade = tst_nu_permeabilidade;
	}

	public BigDecimal getTst_nu_transmissividade() {
		return tst_nu_transmissividade;
	}

	public void setTst_nu_transmissividade(BigDecimal tst_nu_transmissividade) {
		this.tst_nu_transmissividade = tst_nu_transmissividade;
	}

	public BigDecimal getTst_tmi_cd() {
		return tst_tmi_cd;
	}

	public void setTst_tmi_cd(BigDecimal tst_tmi_cd) {
		this.tst_tmi_cd = tst_tmi_cd;
	}

	public BigDecimal getTst_ttb_cd() {
		return tst_ttb_cd;
	}

	public void setTst_ttb_cd(BigDecimal tst_ttb_cd) {
		this.tst_ttb_cd = tst_ttb_cd;
	}

	public BigDecimal getTst_vz_estabilizacao() {
		return tst_vz_estabilizacao;
	}

	public void setTst_vz_estabilizacao(BigDecimal tst_vz_estabilizacao) {
		this.tst_vz_estabilizacao = tst_vz_estabilizacao;
	}
			
}