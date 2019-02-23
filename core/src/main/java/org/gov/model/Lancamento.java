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
@Table(name="tb_lancamento")
@TypeDef(
	    name="pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Lancamento implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="lan_int_pfk", nullable=false)
	@Id
	private int lan_int_pfk;
	
	@Column(name="cam_lanc_dbo5", columnDefinition="numeric")
	private BigDecimal cam_lanc_dbo5;
	
	@Column(name="cam_lanc_dbo20", columnDefinition="numeric")
	private BigDecimal cam_lanc_dbo20;
	
	@Column(name="efl_qt_dbobruto", columnDefinition="numeric")
	private BigDecimal efl_qt_dbobruto;
	
	@Column(name="efl_qt_dbotratado", columnDefinition="numeric")
	private BigDecimal efl_qt_dbotratado;
	
	@Column(name="efl_qt_fosforobruto", columnDefinition="numeric")
	private BigDecimal efl_qt_fosforobruto;
	
	@Column(name="efl_qt_fosforotratado", columnDefinition="numeric")
	private BigDecimal efl_qt_fosforotratado;
	
	@Column(name="efl_qt_nitrogeniobruto", columnDefinition="numeric")
	private BigDecimal efl_qt_nitrogeniobruto;
	
	@Column(name="efl_qt_nitrogeniotratado", columnDefinition="numeric")
	private BigDecimal efl_qt_nitrogeniotratado;

	
	
	public int getLan_int_pfk() {
		return lan_int_pfk;
	}

	public void setLan_int_pfk(int lan_int_pfk) {
		this.lan_int_pfk = lan_int_pfk;
	}

	public BigDecimal getCam_lanc_dbo5() {
		return cam_lanc_dbo5;
	}

	public void setCam_lanc_dbo5(BigDecimal cam_lanc_dbo5) {
		this.cam_lanc_dbo5 = cam_lanc_dbo5;
	}

	public BigDecimal getCam_lanc_dbo20() {
		return cam_lanc_dbo20;
	}

	public void setCam_lanc_dbo20(BigDecimal cam_lanc_dbo20) {
		this.cam_lanc_dbo20 = cam_lanc_dbo20;
	}

	public BigDecimal getEfl_qt_dbobruto() {
		return efl_qt_dbobruto;
	}

	public void setEfl_qt_dbobruto(BigDecimal efl_qt_dbobruto) {
		this.efl_qt_dbobruto = efl_qt_dbobruto;
	}

	public BigDecimal getEfl_qt_dbotratado() {
		return efl_qt_dbotratado;
	}

	public void setEfl_qt_dbotratado(BigDecimal efl_qt_dbotratado) {
		this.efl_qt_dbotratado = efl_qt_dbotratado;
	}

	public BigDecimal getEfl_qt_fosforobruto() {
		return efl_qt_fosforobruto;
	}

	public void setEfl_qt_fosforobruto(BigDecimal efl_qt_fosforobruto) {
		this.efl_qt_fosforobruto = efl_qt_fosforobruto;
	}

	public BigDecimal getEfl_qt_fosforotratado() {
		return efl_qt_fosforotratado;
	}

	public void setEfl_qt_fosforotratado(BigDecimal efl_qt_fosforotratado) {
		this.efl_qt_fosforotratado = efl_qt_fosforotratado;
	}

	public BigDecimal getEfl_qt_nitrogeniobruto() {
		return efl_qt_nitrogeniobruto;
	}

	public void setEfl_qt_nitrogeniobruto(BigDecimal efl_qt_nitrogeniobruto) {
		this.efl_qt_nitrogeniobruto = efl_qt_nitrogeniobruto;
	}

	public BigDecimal getEfl_qt_nitrogeniotratado() {
		return efl_qt_nitrogeniotratado;
	}

	public void setEfl_qt_nitrogeniotratado(BigDecimal efl_qt_nitrogeniotratado) {
		this.efl_qt_nitrogeniotratado = efl_qt_nitrogeniotratado;
	}
}