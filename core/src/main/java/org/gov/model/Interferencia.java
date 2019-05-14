package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name= "tb_interferencia")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Interferencia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="int_id", columnDefinition="integer", nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "tb_interferencia_int_id_seq")
	private Integer int_id;

	@Column(name="apa_est_hidrologico", columnDefinition="boolean", nullable=false)
	private Boolean apa_est_hidrologico;

	@Column(name="fot_cap_lanc_geral", columnDefinition="text", nullable=false)
	private String fot_cap_lanc_geral;

	@Column(name="int_cr_latitude", columnDefinition="numeric(12,10)", nullable=false)
	private BigDecimal int_cr_latitude;

	@Column(name="int_cr_longitude", columnDefinition="numeric(12,10)", nullable=false)
	private BigDecimal int_cr_longitude;

	@Column(name="fot_cap_lanc_detalhe", columnDefinition="text", nullable=false)
	private String fot_cap_lanc_detalhe;

	@Column(name="fot_croqui_localizacao", columnDefinition="text", nullable=false)
	private String fot_croqui_localizacao;

	@Transient
	private String baseImagemGeral;

	@Transient
	private String baseImagemDetalhe;

	@Transient
	private String baseImagemCroqui;

	@Column(name="apa_curso_barragem", columnDefinition="character varying(150)", nullable=false)
	private String apa_curso_barragem;

	@Column(name="apa_manancial", columnDefinition="character varying(150)", nullable=false)
	private String apa_manancial;

	@Column(name="apa_barragem", columnDefinition="character varying(150)", nullable=false)
	private String apa_barragem;

	@Column(name="apa_cap_maxacumula", columnDefinition="numeric(14,5)", nullable=false)
	private BigDecimal apa_cap_maxacumula;

	@Column(name="apa_bacia", columnDefinition="character varying(150)", nullable=false)
	private String apa_bacia;

	@Column(name="cnarh_id", columnDefinition="character varying")
	private String cnarh_id;

	@Column(name="out_nu_processo", columnDefinition="character varying(150)")
	private String out_nu_processo;

	@Column(name="emp_id", columnDefinition="integer", nullable=false)
	private Integer emp_id;

	@Column(name="fin_tfn_cd", columnDefinition="character varying", nullable=false)
	private String fin_tfn_cd;

	@Column(name="fou_tou_cd", columnDefinition="character varying")
	private String fou_tou_cd;

	@Column(name="int_tin_cd", columnDefinition="character varying", nullable=false)
	private String int_tin_cd;

	@Column(name="fou_tou_tp_outro", columnDefinition="text")
	private String fou_tou_tp_outro;

	@Column(name="int_tsi_cd", columnDefinition="character varying(255)")
	private String int_tsi_cd;



	public Integer getInt_id() {
		return int_id;
	}

	public void setInt_id(Integer int_id) {
		this.int_id = int_id;
	}

	public Boolean getApa_est_hidrologico() {
		return apa_est_hidrologico;
	}

	public void setApa_est_hidrologico(Boolean apa_est_hidrologico) {
		this.apa_est_hidrologico = apa_est_hidrologico;
	}

	public String getFot_cap_lanc_geral() {
		return fot_cap_lanc_geral;
	}

	public void setFot_cap_lanc_geral(String fot_cap_lanc_geral) {
		this.fot_cap_lanc_geral = fot_cap_lanc_geral;
	}

	public BigDecimal getInt_cr_latitude() {
		return int_cr_latitude;
	}

	public void setInt_cr_latitude(BigDecimal int_cr_latitude) {
		this.int_cr_latitude = int_cr_latitude;
	}

	public BigDecimal getInt_cr_longitude() {
		return int_cr_longitude;
	}

	public void setInt_cr_longitude(BigDecimal int_cr_longitude) {
		this.int_cr_longitude = int_cr_longitude;
	}

	public String getFot_cap_lanc_detalhe() {
		return fot_cap_lanc_detalhe;
	}

	public void setFot_cap_lanc_detalhe(String fot_cap_lanc_detalhe) {
		this.fot_cap_lanc_detalhe = fot_cap_lanc_detalhe;
	}

	public String getFot_croqui_localizacao() {
		return fot_croqui_localizacao;
	}

	public void setFot_croqui_localizacao(String fot_croqui_localizacao) {
		this.fot_croqui_localizacao = fot_croqui_localizacao;
	}

	public String getApa_curso_barragem() {
		return apa_curso_barragem;
	}

	public void setApa_curso_barragem(String apa_curso_barragem) {
		this.apa_curso_barragem = apa_curso_barragem;
	}

	public String getApa_manancial() {
		return apa_manancial;
	}

	public void setApa_manancial(String apa_manancial) {
		this.apa_manancial = apa_manancial;
	}

	public String getApa_barragem() {
		return apa_barragem;
	}

	public void setApa_barragem(String apa_barragem) {
		this.apa_barragem = apa_barragem;
	}

	public BigDecimal getApa_cap_maxacumula() {
		return apa_cap_maxacumula;
	}

	public void setApa_cap_maxacumula(BigDecimal apa_cap_maxacumula) {
		this.apa_cap_maxacumula = apa_cap_maxacumula;
	}

	public String getApa_bacia() {
		return apa_bacia;
	}

	public void setApa_bacia(String apa_bacia) {
		this.apa_bacia = apa_bacia;
	}

	public String getCnarh_id() {
		return cnarh_id;
	}

	public void setCnarh_id(String cnarh_id) {
		this.cnarh_id = cnarh_id;
	}

	public String getOut_nu_processo() {
		return out_nu_processo;
	}

	public void setOut_nu_processo(String out_nu_processo) {
		this.out_nu_processo = out_nu_processo;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getFin_tfn_cd() {
		return fin_tfn_cd;
	}

	public void setFin_tfn_cd(String fin_tfn_cd) {
		this.fin_tfn_cd = fin_tfn_cd;
	}

	public String getFou_tou_cd() {
		return fou_tou_cd;
	}

	public void setFou_tou_cd(String fou_tou_cd) {
		this.fou_tou_cd = fou_tou_cd;
	}

	public String getInt_tin_cd() {
		return int_tin_cd;
	}

	public void setInt_tin_cd(String int_tin_cd) {
		this.int_tin_cd = int_tin_cd;
	}

	public String getFou_tou_tp_outro() {
		return fou_tou_tp_outro;
	}

	public void setFou_tou_tp_outro(String fou_tou_tp_outro) {
		this.fou_tou_tp_outro = fou_tou_tp_outro;
	}

	public String getInt_tsi_cd() {
		return int_tsi_cd;
	}

	public void setInt_tsi_cd(String int_tsi_cd) {
		this.int_tsi_cd = int_tsi_cd;
	}

	public String getBaseImagemGeral() {
		return baseImagemGeral;
	}

	public void setBaseImagemGeral(String baseImagemGeral) {
		this.baseImagemGeral = baseImagemGeral;
	}

	public String getBaseImagemDetalhe() {
		return baseImagemDetalhe;
	}

	public void setBaseImagemDetalhe(String baseImagemDetalhe) {
		this.baseImagemDetalhe = baseImagemDetalhe;
	}

	public String getBaseImagemCroqui() {
		return baseImagemCroqui;
	}

	public void setBaseImagemCroqui(String baseImagemCroqui) {
		this.baseImagemCroqui = baseImagemCroqui;
	}



}
