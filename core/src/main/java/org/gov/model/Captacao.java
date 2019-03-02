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
@Table(name="tb_captacao")
@TypeDef(
	    name="pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Captacao implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="cap_int_pfk", nullable=false)
	@Id
	private Integer cap_int_pfk;
	
	@Column(name="cam_info_adici_consumo", nullable=false)
	private String cam_info_adici_consumo;

	@Column(name="int_tsu_cd", nullable=false)
	private String int_tsu_cd;

//	@Enumerated(EnumType.STRING)
//	@Column(name="int_tsu_cd", columnDefinition = "int_tsu_enum", nullable=false)
//	@Type(type = "pgsql_enum")
//	private Int_tsu_cd int_tsu_cd;

	
	
	public Integer getCap_int_pfk() {
		return cap_int_pfk;
	}

	public void setCap_int_pfk(Integer cap_int_pfk) {
		this.cap_int_pfk = cap_int_pfk;
	}

	public String getCam_info_adici_consumo() {
		return cam_info_adici_consumo;
	}

	public void setCam_info_adici_consumo(String cam_info_adici_consumo) {
		this.cam_info_adici_consumo = cam_info_adici_consumo;
	}

	public String getInt_tsu_cd() {
		return int_tsu_cd;
	}

	public void setInt_tsu_cd(String int_tsu_cd) {
		this.int_tsu_cd = int_tsu_cd;
	}
}