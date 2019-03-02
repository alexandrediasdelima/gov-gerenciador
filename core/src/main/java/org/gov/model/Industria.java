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
@Table(name="tb_industria")
@TypeDef(
	    name="pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Industria implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="ind_int_pfk", nullable=false)
	@Id
	private Integer ind_int_pfk;
	
	@Column(name="cam_indus_tp")
	private String cam_indus_tp;
	
	@Column(name="cam_indus_nu_empregados", columnDefinition="numeric")
	private BigDecimal cam_indus_nu_empregados;
	
	@Column(name="cam_indus_materia_prima")
	private String cam_indus_materia_prima;
	
	@Column(name="cam_qt_pdt_an", columnDefinition="real")
	private BigDecimal cam_qt_pdt_an;
	
	@Column(name="cam_qt_pdt_an_uni")
	private String cam_qt_pdt_an_uni;

	
	
	public Integer getInd_int_pfk() {
		return ind_int_pfk;
	}

	public void setInd_int_pfk(Integer ind_int_pfk) {
		this.ind_int_pfk = ind_int_pfk;
	}

	public String getCam_indus_tp() {
		return cam_indus_tp;
	}

	public void setCam_indus_tp(String cam_indus_tp) {
		this.cam_indus_tp = cam_indus_tp;
	}

	public BigDecimal getCam_indus_nu_empregados() {
		return cam_indus_nu_empregados;
	}

	public void setCam_indus_nu_empregados(BigDecimal cam_indus_nu_empregados) {
		this.cam_indus_nu_empregados = cam_indus_nu_empregados;
	}

	public String getCam_indus_materia_prima() {
		return cam_indus_materia_prima;
	}

	public void setCam_indus_materia_prima(String cam_indus_materia_prima) {
		this.cam_indus_materia_prima = cam_indus_materia_prima;
	}

	public BigDecimal getCam_qt_pdt_an() {
		return cam_qt_pdt_an;
	}

	public void setCam_qt_pdt_an(BigDecimal cam_qt_pdt_an) {
		this.cam_qt_pdt_an = cam_qt_pdt_an;
	}

	public String getCam_qt_pdt_an_uni() {
		return cam_qt_pdt_an_uni;
	}

	public void setCam_qt_pdt_an_uni(String cam_qt_pdt_an_uni) {
		this.cam_qt_pdt_an_uni = cam_qt_pdt_an_uni;
	}
}