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
@Table(name= "tb_fornecedor")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Fornecedor implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Column (name="forn_id", nullable=false)
	@Id
	@GeneratedValue
	private Integer forn_id;

	@Column (name="forn_info_nm", nullable=false)
	private String forn_info_nm;

	@Column (name="forn_info_cargo", nullable=false)
	private String forn_info_cargo;

	@Column (name="forn_info_departamento", nullable=false)
	private String forn_info_departamento;

	@Column (name="forn_info_contato_inst", nullable=false)
	private String forn_info_contato_inst;

	@Column (name="usuario_id", nullable=false)
	private Integer usuario_id;

	public Integer getForn_id() {
		return forn_id;
	}

	public void setForn_id(Integer forn_id) {
		this.forn_id = forn_id;
	}

	public String getForn_info_nm() {
		return forn_info_nm;
	}

	public void setForn_info_nm(String forn_info_nm) {
		this.forn_info_nm = forn_info_nm;
	}

	public String getForn_info_cargo() {
		return forn_info_cargo;
	}

	public void setForn_info_cargo(String forn_info_cargo) {
		this.forn_info_cargo = forn_info_cargo;
	}

	public String getForn_info_departamento() {
		return forn_info_departamento;
	}

	public void setForn_info_departamento(String forn_info_departamento) {
		this.forn_info_departamento = forn_info_departamento;
	}

	public String getForn_info_contato_inst() {
		return forn_info_contato_inst;
	}

	public void setForn_info_contato_inst(String forn_info_contato_inst) {
		this.forn_info_contato_inst = forn_info_contato_inst;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
}
