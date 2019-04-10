package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name="tb_cnarh")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)

public class Cnarh implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="cnarh_id")
	@Id
	private String cnarh_id;

	@Column(name="ius_nu_alturares", columnDefinition="numeric")
	private BigDecimal ius_nu_alturares;

	@Column(name="ius_ar_resmax", columnDefinition="numeric")
	private BigDecimal ius_ar_resmax;

	@Column(name="int_nu_siagas")
	private String int_nu_siagas;

	@Column(name="ius_vo_resmax", columnDefinition="numeric")
	private BigDecimal ius_vo_resmax;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name="asb_tnp_cd", columnDefinition="asb_tnp_enum")
//	@Type(type="pgsql_enum")
//	@Transient
//	private Asb_tnp_cd asb_tnp_cd;

	public String getCnarh_id() {
		return cnarh_id;
	}

	public void setCnarh_id(String cnarh_id) {
		this.cnarh_id = cnarh_id;
	}

	public BigDecimal getIus_nu_alturares() {
		return ius_nu_alturares;
	}

	public void setIus_nu_alturares(BigDecimal ius_nu_alturares) {
		this.ius_nu_alturares = ius_nu_alturares;
	}

	public BigDecimal getIus_ar_resmax() {
		return ius_ar_resmax;
	}

	public void setIus_ar_resmax(BigDecimal ius_ar_resmax) {
		this.ius_ar_resmax = ius_ar_resmax;
	}

	public String getInt_nu_siagas() {
		return int_nu_siagas;
	}

	public void setInt_nu_siagas(String int_nu_siagas) {
		this.int_nu_siagas = int_nu_siagas;
	}

	public BigDecimal getIus_vo_resmax() {
		return ius_vo_resmax;
	}

	public void setIus_vo_resmax(BigDecimal ius_vo_resmax) {
		this.ius_vo_resmax = ius_vo_resmax;
	}
}
