package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
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
@Table(name="tb_vazao")
@TypeDef(
    name="pgsql_enum",
    typeClass = PostgreSQLEnumType.class)
public class Vazao implements Serializable {
	/**
	 *
	 */
	private  static final long serialVersionUID = 1L;

	@Column(name="vz_int_pfk", nullable=false)
	@Id
	private Integer vz_int_pfk ;

	@Column(name="int_vz_maxima", columnDefinition="numeric", nullable=false)
	private BigDecimal int_vz_maxima ;

	@Column(name="cam_vz_afe", columnDefinition="numeric", nullable=false)
	private BigDecimal cam_vz_afe ;

	@Column(name="ope_qt_horasjan", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasjan ;

	@Column(name="ope_qt_horasfev", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasfev ;

	@Column(name="ope_qt_horasmar", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasmar ;

	@Column(name="ope_qt_horasabr", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasabr ;

	@Column(name="ope_qt_horasmai", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasmai ;

	@Column(name="ope_qt_horasjun", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasjun ;

	@Column(name="ope_qt_horasjul", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasjul ;

	@Column(name="ope_qt_horasago", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasago ;

	@Column(name="ope_qt_horasset", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasset ;

	@Column(name="ope_qt_horasout", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasout ;

	@Column(name="ope_qt_horasnov", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasnov ;

	@Column(name="ope_qt_horasdez", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_qt_horasdez ;

	@Column(name="ope_qt_diajan", nullable=false)
	private Integer ope_qt_diajan ;

	@Column(name="ope_qt_diafev", nullable=false)
	private Integer ope_qt_diafev ;

	@Column(name="ope_qt_diamar", nullable=false)
	private Integer ope_qt_diamar ;

	@Column(name="ope_qt_diaabr", nullable=false)
	private Integer ope_qt_diaabr ;

	@Column(name="ope_qt_diamai", nullable=false)
	private Integer ope_qt_diamai ;

	@Column(name="ope_qt_diajun", nullable=false)
	private Integer ope_qt_diajun ;

	@Column(name="ope_qt_diajul", nullable=false)
	private Integer ope_qt_diajul ;

	@Column(name="ope_qt_diaago", nullable=false)
	private Integer ope_qt_diaago ;

	@Column(name="ope_qt_diaset", nullable=false)
	private Integer ope_qt_diaset ;

	@Column(name="ope_qt_diaout", nullable=false)
	private Integer ope_qt_diaout ;

	@Column(name="ope_qt_dianov", nullable=false)
	private Integer ope_qt_dianov ;

	@Column(name="ope_qt_diadez", nullable=false)
	private Integer ope_qt_diadez ;

	@Column(name="ope_vz_mesjan", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesjan ;

	@Column(name="ope_vz_mesfev", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesfev ;

	@Column(name="ope_vz_mesmar", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesmar ;

	@Column(name="ope_vz_mesabr", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesabr ;

	@Column(name="ope_vz_mesmai", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesmai ;

	@Column(name="ope_vz_mesjul", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesjul ;

	@Column(name="ope_vz_mesjun", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesjun ;

	@Column(name="ope_vz_mesago", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesago ;

	@Column(name="ope_vz_mesout", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesout ;

	@Column(name="ope_vz_messet", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_messet ;

	@Column(name="ope_vz_mesnov", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesnov ;

	@Column(name="ope_vz_mesdez", columnDefinition="numeric", nullable=false)
	private BigDecimal ope_vz_mesdez ;

	public Integer getVz_int_pfk() {
		return vz_int_pfk;
	}

	public void setVz_int_pfk(Integer vz_int_pfk) {
		this.vz_int_pfk = vz_int_pfk;
	}

	public BigDecimal getInt_vz_maxima() {
		return int_vz_maxima;
	}

	public void setInt_vz_maxima(BigDecimal int_vz_maxima) {
		this.int_vz_maxima = int_vz_maxima;
	}

	public BigDecimal getCam_vz_afe() {
		return cam_vz_afe;
	}

	public void setCam_vz_afe(BigDecimal cam_vz_afe) {
		this.cam_vz_afe = cam_vz_afe;
	}

	public BigDecimal getOpe_qt_horasjan() {
		return ope_qt_horasjan;
	}

	public void setOpe_qt_horasjan(BigDecimal ope_qt_horasjan) {
		this.ope_qt_horasjan = ope_qt_horasjan;
	}

	public BigDecimal getOpe_qt_horasfev() {
		return ope_qt_horasfev;
	}

	public void setOpe_qt_horasfev(BigDecimal ope_qt_horasfev) {
		this.ope_qt_horasfev = ope_qt_horasfev;
	}

	public BigDecimal getOpe_qt_horasmar() {
		return ope_qt_horasmar;
	}

	public void setOpe_qt_horasmar(BigDecimal ope_qt_horasmar) {
		this.ope_qt_horasmar = ope_qt_horasmar;
	}

	public BigDecimal getOpe_qt_horasabr() {
		return ope_qt_horasabr;
	}

	public void setOpe_qt_horasabr(BigDecimal ope_qt_horasabr) {
		this.ope_qt_horasabr = ope_qt_horasabr;
	}

	public BigDecimal getOpe_qt_horasmai() {
		return ope_qt_horasmai;
	}

	public void setOpe_qt_horasmai(BigDecimal ope_qt_horasmai) {
		this.ope_qt_horasmai = ope_qt_horasmai;
	}

	public BigDecimal getOpe_qt_horasjun() {
		return ope_qt_horasjun;
	}

	public void setOpe_qt_horasjun(BigDecimal ope_qt_horasjun) {
		this.ope_qt_horasjun = ope_qt_horasjun;
	}

	public BigDecimal getOpe_qt_horasjul() {
		return ope_qt_horasjul;
	}

	public void setOpe_qt_horasjul(BigDecimal ope_qt_horasjul) {
		this.ope_qt_horasjul = ope_qt_horasjul;
	}

	public BigDecimal getOpe_qt_horasago() {
		return ope_qt_horasago;
	}

	public void setOpe_qt_horasago(BigDecimal ope_qt_horasago) {
		this.ope_qt_horasago = ope_qt_horasago;
	}

	public BigDecimal getOpe_qt_horasset() {
		return ope_qt_horasset;
	}

	public void setOpe_qt_horasset(BigDecimal ope_qt_horasset) {
		this.ope_qt_horasset = ope_qt_horasset;
	}

	public BigDecimal getOpe_qt_horasout() {
		return ope_qt_horasout;
	}

	public void setOpe_qt_horasout(BigDecimal ope_qt_horasout) {
		this.ope_qt_horasout = ope_qt_horasout;
	}

	public BigDecimal getOpe_qt_horasnov() {
		return ope_qt_horasnov;
	}

	public void setOpe_qt_horasnov(BigDecimal ope_qt_horasnov) {
		this.ope_qt_horasnov = ope_qt_horasnov;
	}

	public BigDecimal getOpe_qt_horasdez() {
		return ope_qt_horasdez;
	}

	public void setOpe_qt_horasdez(BigDecimal ope_qt_horasdez) {
		this.ope_qt_horasdez = ope_qt_horasdez;
	}

	public Integer getOpe_qt_diajan() {
		return ope_qt_diajan;
	}

	public void setOpe_qt_diajan(Integer ope_qt_diajan) {
		this.ope_qt_diajan = ope_qt_diajan;
	}

	public Integer getOpe_qt_diafev() {
		return ope_qt_diafev;
	}

	public void setOpe_qt_diafev(Integer ope_qt_diafev) {
		this.ope_qt_diafev = ope_qt_diafev;
	}

	public Integer getOpe_qt_diamar() {
		return ope_qt_diamar;
	}

	public void setOpe_qt_diamar(Integer ope_qt_diamar) {
		this.ope_qt_diamar = ope_qt_diamar;
	}

	public Integer getOpe_qt_diaabr() {
		return ope_qt_diaabr;
	}

	public void setOpe_qt_diaabr(Integer ope_qt_diaabr) {
		this.ope_qt_diaabr = ope_qt_diaabr;
	}

	public Integer getOpe_qt_diamai() {
		return ope_qt_diamai;
	}

	public void setOpe_qt_diamai(Integer ope_qt_diamai) {
		this.ope_qt_diamai = ope_qt_diamai;
	}

	public Integer getOpe_qt_diajun() {
		return ope_qt_diajun;
	}

	public void setOpe_qt_diajun(Integer ope_qt_diajun) {
		this.ope_qt_diajun = ope_qt_diajun;
	}

	public Integer getOpe_qt_diajul() {
		return ope_qt_diajul;
	}

	public void setOpe_qt_diajul(Integer ope_qt_diajul) {
		this.ope_qt_diajul = ope_qt_diajul;
	}

	public Integer getOpe_qt_diaago() {
		return ope_qt_diaago;
	}

	public void setOpe_qt_diaago(Integer ope_qt_diaago) {
		this.ope_qt_diaago = ope_qt_diaago;
	}

	public Integer getOpe_qt_diaset() {
		return ope_qt_diaset;
	}

	public void setOpe_qt_diaset(Integer ope_qt_diaset) {
		this.ope_qt_diaset = ope_qt_diaset;
	}

	public Integer getOpe_qt_diaout() {
		return ope_qt_diaout;
	}

	public void setOpe_qt_diaout(Integer ope_qt_diaout) {
		this.ope_qt_diaout = ope_qt_diaout;
	}

	public Integer getOpe_qt_dianov() {
		return ope_qt_dianov;
	}

	public void setOpe_qt_dianov(Integer ope_qt_dianov) {
		this.ope_qt_dianov = ope_qt_dianov;
	}

	public Integer getOpe_qt_diadez() {
		return ope_qt_diadez;
	}

	public void setOpe_qt_diadez(Integer ope_qt_diadez) {
		this.ope_qt_diadez = ope_qt_diadez;
	}

	public BigDecimal getOpe_vz_mesjan() {
		return ope_vz_mesjan;
	}

	public void setOpe_vz_mesjan(BigDecimal ope_vz_mesjan) {
		this.ope_vz_mesjan = ope_vz_mesjan;
	}

	public BigDecimal getOpe_vz_mesfev() {
		return ope_vz_mesfev;
	}

	public void setOpe_vz_mesfev(BigDecimal ope_vz_mesfev) {
		this.ope_vz_mesfev = ope_vz_mesfev;
	}

	public BigDecimal getOpe_vz_mesmar() {
		return ope_vz_mesmar;
	}

	public void setOpe_vz_mesmar(BigDecimal ope_vz_mesmar) {
		this.ope_vz_mesmar = ope_vz_mesmar;
	}

	public BigDecimal getOpe_vz_mesabr() {
		return ope_vz_mesabr;
	}

	public void setOpe_vz_mesabr(BigDecimal ope_vz_mesabr) {
		this.ope_vz_mesabr = ope_vz_mesabr;
	}

	public BigDecimal getOpe_vz_mesmai() {
		return ope_vz_mesmai;
	}

	public void setOpe_vz_mesmai(BigDecimal ope_vz_mesmai) {
		this.ope_vz_mesmai = ope_vz_mesmai;
	}

	public BigDecimal getOpe_vz_mesjul() {
		return ope_vz_mesjul;
	}

	public void setOpe_vz_mesjul(BigDecimal ope_vz_mesjul) {
		this.ope_vz_mesjul = ope_vz_mesjul;
	}

	public BigDecimal getOpe_vz_mesjun() {
		return ope_vz_mesjun;
	}

	public void setOpe_vz_mesjun(BigDecimal ope_vz_mesjun) {
		this.ope_vz_mesjun = ope_vz_mesjun;
	}

	public BigDecimal getOpe_vz_mesago() {
		return ope_vz_mesago;
	}

	public void setOpe_vz_mesago(BigDecimal ope_vz_mesago) {
		this.ope_vz_mesago = ope_vz_mesago;
	}

	public BigDecimal getOpe_vz_mesout() {
		return ope_vz_mesout;
	}

	public void setOpe_vz_mesout(BigDecimal ope_vz_mesout) {
		this.ope_vz_mesout = ope_vz_mesout;
	}

	public BigDecimal getOpe_vz_messet() {
		return ope_vz_messet;
	}

	public void setOpe_vz_messet(BigDecimal ope_vz_messet) {
		this.ope_vz_messet = ope_vz_messet;
	}

	public BigDecimal getOpe_vz_mesnov() {
		return ope_vz_mesnov;
	}

	public void setOpe_vz_mesnov(BigDecimal ope_vz_mesnov) {
		this.ope_vz_mesnov = ope_vz_mesnov;
	}

	public BigDecimal getOpe_vz_mesdez() {
		return ope_vz_mesdez;
	}

	public void setOpe_vz_mesdez(BigDecimal ope_vz_mesdez) {
		this.ope_vz_mesdez = ope_vz_mesdez;
	}


}