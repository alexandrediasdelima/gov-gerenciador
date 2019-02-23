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
@Table(name="tb_tstbomb")
@TypeDef(
    name="pgsql_enum",
    typeClass = PostgreSQLEnumType.class)
public class TesteBombeamento implements Serializable {
	/**
	 *
	 */
	private  static final long serialVersionUID = 1L;
	
	@Column(name="tstbomb_int_pfk", nullable=false)
	@Id
	private int tstbomb_int_pfk; 
	  
	@Column(name="tst_nu_coeficientearmazenamento", columnDefinition="numeric")
	private BigDecimal tst_nu_coeficientearmazenamento; 
	  
	@Column(name="tst_nu_condutividadehidraulica", columnDefinition="numeric")
	private BigDecimal tst_nu_condutividadehidraulica; 
	  
	@Column(name="tst_dt", columnDefinition="timestamp without time zone")
	private Date tst_dt; 
	  
	@Column(name="tst_ds_tempoduracao")
	private String tst_ds_tempoduracao; 
	  
	@Column(name="tst_nu_nd", columnDefinition="numeric")
	private BigDecimal tst_nu_nd; 
	  
	@Column(name="tst_nu_ne", columnDefinition="numeric")
	private BigDecimal tst_nu_ne; 
	  
	@Column(name="tst_nu_permeabilidade", columnDefinition="numeric")
	private BigDecimal tst_nu_permeabilidade; 
	  
	@Column(name="tst_nu_transmissividade", columnDefinition="numeric")
	private BigDecimal tst_nu_transmissividade; 
	  
	@Column(name="tst_vz_estabilizacao", columnDefinition="numeric")
	private BigDecimal tst_vz_estabilizacao; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="tst_ttb_cd", columnDefinition = "tst_ttb_enum")
	@Type(type = "pgsql_enum")
	private Tst_ttb_cd tst_ttb_cd; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="tst_tmi_cd", columnDefinition = "tst_tmi_enum")
	@Type(type = "pgsql_enum")
	private Tst_tmi_cd tst_tmi_cd;
	
	

	public int getTstbomb_int_pfk() {
		return tstbomb_int_pfk;
	}

	public void setTstbomb_int_pfk(int tstbomb_int_pfk) {
		this.tstbomb_int_pfk = tstbomb_int_pfk;
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

	public Date getTst_dt() {
		return tst_dt;
	}

	public void setTst_dt(Date tst_dt) {
		this.tst_dt = tst_dt;
	}

	public String getTst_ds_tempoduracao() {
		return tst_ds_tempoduracao;
	}

	public void setTst_ds_tempoduracao(String tst_ds_tempoduracao) {
		this.tst_ds_tempoduracao = tst_ds_tempoduracao;
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

	public BigDecimal getTst_vz_estabilizacao() {
		return tst_vz_estabilizacao;
	}

	public void setTst_vz_estabilizacao(BigDecimal tst_vz_estabilizacao) {
		this.tst_vz_estabilizacao = tst_vz_estabilizacao;
	}

	public Tst_ttb_cd getTst_ttb_cd() {
		return tst_ttb_cd;
	}

	public void setTst_ttb_cd(Tst_ttb_cd tst_ttb_cd) {
		this.tst_ttb_cd = tst_ttb_cd;
	}

	public Tst_tmi_cd getTst_tmi_cd() {
		return tst_tmi_cd;
	}

	public void setTst_tmi_cd(Tst_tmi_cd tst_tmi_cd) {
		this.tst_tmi_cd = tst_tmi_cd;
	}
}