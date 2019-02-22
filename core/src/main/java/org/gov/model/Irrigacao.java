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
@Table(name="tb_irrigacao")
@TypeDef(
	    name="pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Irrigacao implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
		
	@Column(name="irr_int_pfk", nullable=false)
	@Id
	private int irr_int_pfk;
	
	@Column(name="sir_ar_irrigada", columnDefinition="numeric")
	private BigDecimal sir_ar_irrigada;
	
	@Column(name="sir_ar_irrigada_uni")
	private String sir_ar_irrigada_uni;
	
	@Column(name="sir_ar_irrigada_outra", columnDefinition="boolean")
	private Boolean sir_ar_irrigada_outra;
	
	@Column(name="sir_tsi_cd_2_", columnDefinition="numeric")
	private BigDecimal sir_tsi_cd_2_;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tct_cd_2", columnDefinition="sir_tct_enum")
	@Type(type = "pgsql_enum")
	private Sir_tct_cd sir_tct_cd_2;
	
	@Column(name="sir_ar_irrigada_2", columnDefinition="numeric")
	private BigDecimal sir_ar_irrigada_2;
	
	@Column(name="sir_ar_irrigada_uni_2")
	private String sir_ar_irrigada_uni_2;
	
	@Column(name="sir_ar_irrigada_outra_2", columnDefinition="boolean")
	private Boolean sir_ar_irrigada_outra_2;
	
	@Column(name="sir_tsi_cd_3_", columnDefinition="numeric")
	private BigDecimal sir_tsi_cd_3_;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tct_cd_3", columnDefinition = "sir_tct_enum")
	@Type(type = "pgsql_enum")
	private Sir_tct_cd sir_tct_cd_3;
	
	@Column(name="sir_ar_irrigada_3", columnDefinition="numeric")
	private BigDecimal sir_ar_irrigada_3;
	
	@Column(name="sir_ar_irrigada_uni_3")
	private String sir_ar_irrigada_uni_3;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tsi_cd", columnDefinition = "sir_tsi_enum")
	@Type(type = "pgsql_enum")
	private Sir_tsi_cd sir_tsi_cd;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tct_cd", columnDefinition = "sir_tct_enum")
	@Type(type = "pgsql_enum")
	private Sir_tct_cd sir_tct_cd;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tsi_cd_2", columnDefinition = "sir_tsi_enum")
	@Type(type = "pgsql_enum")
	private Sir_tsi_cd sir_tsi_cd_2;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sir_tsi_cd_3", columnDefinition = "sir_tsi_enum")
	@Type(type = "pgsql_enum")
	private Sir_tsi_cd sir_tsi_cd_3;

	
	
	public int getIrr_int_pfk() {
		return irr_int_pfk;
	}

	public void setIrr_int_pfk(int irr_int_pfk) {
		this.irr_int_pfk = irr_int_pfk;
	}

	public BigDecimal getSir_ar_irrigada() {
		return sir_ar_irrigada;
	}

	public void setSir_ar_irrigada(BigDecimal sir_ar_irrigada) {
		this.sir_ar_irrigada = sir_ar_irrigada;
	}

	public String getSir_ar_irrigada_uni() {
		return sir_ar_irrigada_uni;
	}

	public void setSir_ar_irrigada_uni(String sir_ar_irrigada_uni) {
		this.sir_ar_irrigada_uni = sir_ar_irrigada_uni;
	}

	public Boolean getSir_ar_irrigada_outra() {
		return sir_ar_irrigada_outra;
	}

	public void setSir_ar_irrigada_outra(Boolean sir_ar_irrigada_outra) {
		this.sir_ar_irrigada_outra = sir_ar_irrigada_outra;
	}

	public BigDecimal getSir_tsi_cd_2_() {
		return sir_tsi_cd_2_;
	}

	public void setSir_tsi_cd_2_(BigDecimal sir_tsi_cd_2_) {
		this.sir_tsi_cd_2_ = sir_tsi_cd_2_;
	}

	public Sir_tct_cd getSir_tct_cd_2() {
		return sir_tct_cd_2;
	}

	public void setSir_tct_cd_2(Sir_tct_cd sir_tct_cd_2) {
		this.sir_tct_cd_2 = sir_tct_cd_2;
	}

	public BigDecimal getSir_ar_irrigada_2() {
		return sir_ar_irrigada_2;
	}

	public void setSir_ar_irrigada_2(BigDecimal sir_ar_irrigada_2) {
		this.sir_ar_irrigada_2 = sir_ar_irrigada_2;
	}

	public String getSir_ar_irrigada_uni_2() {
		return sir_ar_irrigada_uni_2;
	}

	public void setSir_ar_irrigada_uni_2(String sir_ar_irrigada_uni_2) {
		this.sir_ar_irrigada_uni_2 = sir_ar_irrigada_uni_2;
	}

	public Boolean getSir_ar_irrigada_outra_2() {
		return sir_ar_irrigada_outra_2;
	}

	public void setSir_ar_irrigada_outra_2(Boolean sir_ar_irrigada_outra_2) {
		this.sir_ar_irrigada_outra_2 = sir_ar_irrigada_outra_2;
	}

	public BigDecimal getSir_tsi_cd_3_() {
		return sir_tsi_cd_3_;
	}

	public void setSir_tsi_cd_3_(BigDecimal sir_tsi_cd_3_) {
		this.sir_tsi_cd_3_ = sir_tsi_cd_3_;
	}

	public Sir_tct_cd getSir_tct_cd_3() {
		return sir_tct_cd_3;
	}

	public void setSir_tct_cd_3(Sir_tct_cd sir_tct_cd_3) {
		this.sir_tct_cd_3 = sir_tct_cd_3;
	}

	public BigDecimal getSir_ar_irrigada_3() {
		return sir_ar_irrigada_3;
	}

	public void setSir_ar_irrigada_3(BigDecimal sir_ar_irrigada_3) {
		this.sir_ar_irrigada_3 = sir_ar_irrigada_3;
	}

	public String getSir_ar_irrigada_uni_3() {
		return sir_ar_irrigada_uni_3;
	}

	public void setSir_ar_irrigada_uni_3(String sir_ar_irrigada_uni_3) {
		this.sir_ar_irrigada_uni_3 = sir_ar_irrigada_uni_3;
	}

	public Sir_tsi_cd getSir_tsi_cd() {
		return sir_tsi_cd;
	}

	public void setSir_tsi_cd(Sir_tsi_cd sir_tsi_cd) {
		this.sir_tsi_cd = sir_tsi_cd;
	}

	public Sir_tct_cd getSir_tct_cd() {
		return sir_tct_cd;
	}

	public void setSir_tct_cd(Sir_tct_cd sir_tct_cd) {
		this.sir_tct_cd = sir_tct_cd;
	}

	public Sir_tsi_cd getSir_tsi_cd_2() {
		return sir_tsi_cd_2;
	}

	public void setSir_tsi_cd_2(Sir_tsi_cd sir_tsi_cd_2) {
		this.sir_tsi_cd_2 = sir_tsi_cd_2;
	}

	public Sir_tsi_cd getSir_tsi_cd_3() {
		return sir_tsi_cd_3;
	}

	public void setSir_tsi_cd_3(Sir_tsi_cd sir_tsi_cd_3) {
		this.sir_tsi_cd_3 = sir_tsi_cd_3;
	}
}