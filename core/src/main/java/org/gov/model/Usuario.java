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
@Table(name= "tb_usuario")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Usuario implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="usuario_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuario_id;

	@Column(name="emp_nm_usuario")
	private String emp_nm_usuario;

	@Column(name="emp_nm_apelido")
	private String emp_nm_apelido;

	@Column(name="emp_nu_cpfcnpj")
	private String emp_nu_cpfcnpj;

	@Column(name="emp_nu_obscpfcnpj")
	private String emp_nu_obscpfcnpj;

	@Column(name="emp_nu_ddd")
	private String emp_nu_ddd;

	@Column(name="emp_nu_telefone")
	private String emp_nu_telefone;

	@Column(name="emp_ds_emailresponsavel")
	private String emp_ds_emailresponsavel;

	@Column(name="emp_ds_tp_logradouro")
	private String emp_ds_tp_logradouro;

	@Column(name="emp_ds_nm_logradouro")
	private String emp_ds_nm_logradouro;

	@Column(name="emp_ds_logradouro")
	private String emp_ds_logradouro;

	@Column(name="emp_nu_logradouro", columnDefinition="numeric")
	private BigDecimal emp_nu_logradouro;

	@Column(name="emp_ds_complementoendereco")
	private String emp_ds_complementoendereco;

	@Column(name="emp_ds_bairrodistrito")
	private String emp_ds_bairrodistrito;

	@Column(name="emp_nu_caixapostal", columnDefinition="numeric")
	private BigDecimal emp_nu_caixapostal;

	@Column(name="emp_nu_cependereco")
	private String emp_nu_cependereco;

	@Column(name="apa_muni_correspondencia")
	private String apa_muni_correspondencia;

	@Column(name="emp_cd_codigoibgecorrespondencia", columnDefinition="numeric")
	private BigDecimal emp_cd_codigoibgecorrespondencia;

	@Column(name = "emp_ds_uf")
	private String emp_ds_uf;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "emp_ds_uf", columnDefinition = "emp_ds_uf_enum")
//	@Type(type = "pgsql_enum")
//	private Emp_ds_uf emp_ds_uf;

	@Column(name="emp_ds_relacaopropriedade")
	private String emp_ds_relacaopropriedade;

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getEmp_nm_usuario() {
		return emp_nm_usuario;
	}

	public void setEmp_nm_usuario(String emp_nm_usuario) {
		this.emp_nm_usuario = emp_nm_usuario;
	}

	public String getEmp_nm_apelido() {
		return emp_nm_apelido;
	}

	public void setEmp_nm_apelido(String emp_nm_apelido) {
		this.emp_nm_apelido = emp_nm_apelido;
	}

	public String getEmp_nu_cpfcnpj() {
		return emp_nu_cpfcnpj;
	}

	public void setEmp_nu_cpfcnpj(String emp_nu_cpfcnpj) {
		this.emp_nu_cpfcnpj = emp_nu_cpfcnpj;
	}

	public String getEmp_nu_obscpfcnpj() {
		return emp_nu_obscpfcnpj;
	}

	public void setEmp_nu_obscpfcnpj(String emp_nu_obscpfcnpj) {
		this.emp_nu_obscpfcnpj = emp_nu_obscpfcnpj;
	}

	public String getEmp_nu_ddd() {
		return emp_nu_ddd;
	}

	public void setEmp_nu_ddd(String emp_nu_ddd) {
		this.emp_nu_ddd = emp_nu_ddd;
	}

	public String getEmp_nu_telefone() {
		return emp_nu_telefone;
	}

	public void setEmp_nu_telefone(String emp_nu_telefone) {
		this.emp_nu_telefone = emp_nu_telefone;
	}

	public String getEmp_ds_emailresponsavel() {
		return emp_ds_emailresponsavel;
	}

	public void setEmp_ds_emailresponsavel(String emp_ds_emailresponsavel) {
		this.emp_ds_emailresponsavel = emp_ds_emailresponsavel;
	}

	public String getEmp_ds_tp_logradouro() {
		return emp_ds_tp_logradouro;
	}

	public void setEmp_ds_tp_logradouro(String emp_ds_tp_logradouro) {
		this.emp_ds_tp_logradouro = emp_ds_tp_logradouro;
	}

	public String getEmp_ds_nm_logradouro() {
		return emp_ds_nm_logradouro;
	}

	public void setEmp_ds_nm_logradouro(String emp_ds_nm_logradouro) {
		this.emp_ds_nm_logradouro = emp_ds_nm_logradouro;
	}

	public String getEmp_ds_logradouro() {
		return emp_ds_logradouro;
	}

	public void setEmp_ds_logradouro(String emp_ds_logradouro) {
		this.emp_ds_logradouro = emp_ds_logradouro;
	}

	public BigDecimal getEmp_nu_logradouro() {
		return emp_nu_logradouro;
	}

	public void setEmp_nu_logradouro(BigDecimal emp_nu_logradouro) {
		this.emp_nu_logradouro = emp_nu_logradouro;
	}

	public String getEmp_ds_complementoendereco() {
		return emp_ds_complementoendereco;
	}

	public void setEmp_ds_complementoendereco(String emp_ds_complementoendereco) {
		this.emp_ds_complementoendereco = emp_ds_complementoendereco;
	}

	public String getEmp_ds_bairrodistrito() {
		return emp_ds_bairrodistrito;
	}

	public void setEmp_ds_bairrodistrito(String emp_ds_bairrodistrito) {
		this.emp_ds_bairrodistrito = emp_ds_bairrodistrito;
	}

	public BigDecimal getEmp_nu_caixapostal() {
		return emp_nu_caixapostal;
	}

	public void setEmp_nu_caixapostal(BigDecimal emp_nu_caixapostal) {
		this.emp_nu_caixapostal = emp_nu_caixapostal;
	}

	public String getEmp_nu_cependereco() {
		return emp_nu_cependereco;
	}

	public void setEmp_nu_cependereco(String emp_nu_cependereco) {
		this.emp_nu_cependereco = emp_nu_cependereco;
	}

	public String getApa_muni_correspondencia() {
		return apa_muni_correspondencia;
	}

	public void setApa_muni_correspondencia(String apa_muni_correspondencia) {
		this.apa_muni_correspondencia = apa_muni_correspondencia;
	}

	public BigDecimal getEmp_cd_codigoibgecorrespondencia() {
		return emp_cd_codigoibgecorrespondencia;
	}

	public void setEmp_cd_codigoibgecorrespondencia(BigDecimal emp_cd_codigoibgecorrespondencia) {
		this.emp_cd_codigoibgecorrespondencia = emp_cd_codigoibgecorrespondencia;
	}

	public String getEmp_ds_uf() {
		return emp_ds_uf;
	}

	public void setEmp_ds_uf(String emp_ds_uf) {
		this.emp_ds_uf = emp_ds_uf;
	}

	public String getEmp_ds_relacaopropriedade() {
		return emp_ds_relacaopropriedade;
	}

	public void setEmp_ds_relacaopropriedade(String emp_ds_relacaopropriedade) {
		this.emp_ds_relacaopropriedade = emp_ds_relacaopropriedade;
	}
}
