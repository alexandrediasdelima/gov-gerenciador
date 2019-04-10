package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_outras_informacoes")
public class OutraInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Column (name="oi_emp_pfk", nullable=false)
	@Id
	private Integer oi_emp_pfk;

	@Column (name="cam_agua_servida_destino")
	private String cam_agua_servida_destino;

	@Column (name="cam_captacao_agua_subt", columnDefinition="boolean")
	private Boolean cam_captacao_agua_subt;

	@Column (name="cam_tp_poco")
	private String cam_tp_poco;

	@Column (name="cam_profundidade_poco")
	private String cam_profundidade_poco;

	@Column (name="asb_nu_profundidadefinal", columnDefinition="numeric")
	private BigDecimal asb_nu_profundidadefinal;

	@Column (name="cam_utilizacao_poco")
	private String cam_utilizacao_poco;

	@Column (name="cam_realizacao_car", nullable=false)
	private String cam_realizacao_car;

	@Column (name="cam_captacoes_comple", nullable=false)
	private String cam_captacoes_comple;

	@Column (name="cam_capta_lanca_futuro", nullable=false)
	private String cam_capta_lanca_futuro;

	
	
	public Integer getOi_emp_pfk() {
		return oi_emp_pfk;
	}

	public void setOi_emp_pfk(Integer oi_emp_pfk) {
		this.oi_emp_pfk = oi_emp_pfk;
	}

	public String getCam_agua_servida_destino() {
		return cam_agua_servida_destino;
	}

	public void setCam_agua_servida_destino(String cam_agua_servida_destino) {
		this.cam_agua_servida_destino = cam_agua_servida_destino;
	}

	public Boolean getCam_captacao_agua_subt() {
		return cam_captacao_agua_subt;
	}

	public void setCam_captacao_agua_subt(Boolean cam_captacao_agua_subt) {
		this.cam_captacao_agua_subt = cam_captacao_agua_subt;
	}

	public String getCam_tp_poco() {
		return cam_tp_poco;
	}

	public void setCam_tp_poco(String cam_tp_poco) {
		this.cam_tp_poco = cam_tp_poco;
	}

	public String getCam_profundidade_poco() {
		return cam_profundidade_poco;
	}

	public void setCam_profundidade_poco(String cam_profundidade_poco) {
		this.cam_profundidade_poco = cam_profundidade_poco;
	}

	public BigDecimal getAsb_nu_profundidadefinal() {
		return asb_nu_profundidadefinal;
	}

	public void setAsb_nu_profundidadefinal(BigDecimal asb_nu_profundidadefinal) {
		this.asb_nu_profundidadefinal = asb_nu_profundidadefinal;
	}

	public String getCam_utilizacao_poco() {
		return cam_utilizacao_poco;
	}

	public void setCam_utilizacao_poco(String cam_utilizacao_poco) {
		this.cam_utilizacao_poco = cam_utilizacao_poco;
	}

	public String getCam_realizacao_car() {
		return cam_realizacao_car;
	}

	public void setCam_realizacao_car(String cam_realizacao_car) {
		this.cam_realizacao_car = cam_realizacao_car;
	}

	public String getCam_captacoes_comple() {
		return cam_captacoes_comple;
	}

	public void setCam_captacoes_comple(String cam_captacoes_comple) {
		this.cam_captacoes_comple = cam_captacoes_comple;
	}

	public String getCam_capta_lanca_futuro() {
		return cam_capta_lanca_futuro;
	}

	public void setCam_capta_lanca_futuro(String cam_capta_lanca_futuro) {
		this.cam_capta_lanca_futuro = cam_capta_lanca_futuro;
	}
}
