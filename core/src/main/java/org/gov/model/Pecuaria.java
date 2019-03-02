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
@Table(name="tb_pecuaria")
@TypeDef(
    name="pgsql_enum",
    typeClass = PostgreSQLEnumType.class)
public class Pecuaria implements Serializable {
	/**
	 *
	 */
	private  static final long serialVersionUID = 1L;
	
	@Column(name="pec_int_pfk", nullable=false)
	@Id
	private Integer pec_int_pfk;
	
	@Column(name="cam_qt_equideo")
	private Integer cam_qt_equideo;
	
	@Column(name="cam_qt_bovino")
	private Integer cam_qt_bovino;
	
	@Column(name="cam_qt_ovino")
	private Integer cam_qt_ovino;
	
	@Column(name="cam_qt_caprino")
	private Integer cam_qt_caprino;
	
	@Column(name="cam_qt_suino")
	private Integer cam_qt_suino;
	
	@Column(name="cam_qt_ave")
	private Integer cam_qt_ave;
	
	@Column(name="cam_pec_outro")
	private String cam_pec_outro;
	
	@Column(name="cam_qt_outro")
	private Integer cam_qt_outro;

	public Integer getPec_int_pfk() {
		return pec_int_pfk;
	}

	public void setPec_int_pfk(Integer pec_int_pfk) {
		this.pec_int_pfk = pec_int_pfk;
	}

	public Integer getCam_qt_equideo() {
		return cam_qt_equideo;
	}

	public void setCam_qt_equideo(Integer cam_qt_equideo) {
		this.cam_qt_equideo = cam_qt_equideo;
	}

	public Integer getCam_qt_bovino() {
		return cam_qt_bovino;
	}

	public void setCam_qt_bovino(Integer cam_qt_bovino) {
		this.cam_qt_bovino = cam_qt_bovino;
	}

	public Integer getCam_qt_ovino() {
		return cam_qt_ovino;
	}

	public void setCam_qt_ovino(Integer cam_qt_ovino) {
		this.cam_qt_ovino = cam_qt_ovino;
	}

	public Integer getCam_qt_caprino() {
		return cam_qt_caprino;
	}

	public void setCam_qt_caprino(Integer cam_qt_caprino) {
		this.cam_qt_caprino = cam_qt_caprino;
	}

	public Integer getCam_qt_suino() {
		return cam_qt_suino;
	}

	public void setCam_qt_suino(Integer cam_qt_suino) {
		this.cam_qt_suino = cam_qt_suino;
	}

	public Integer getCam_qt_ave() {
		return cam_qt_ave;
	}

	public void setCam_qt_ave(Integer cam_qt_ave) {
		this.cam_qt_ave = cam_qt_ave;
	}

	public String getCam_pec_outro() {
		return cam_pec_outro;
	}

	public void setCam_pec_outro(String cam_pec_outro) {
		this.cam_pec_outro = cam_pec_outro;
	}

	public Integer getCam_qt_outro() {
		return cam_qt_outro;
	}

	public void setCam_qt_outro(Integer cam_qt_outro) {
		this.cam_qt_outro = cam_qt_outro;
	}

	
}