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
@Table(name= "tb_asbama")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Asbama implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ama_int_pfk", nullable=false)
	@Id
	private Integer ama_int_pfk;
	
	@Column(name="ama_qt_calcio", columnDefinition="numeric")
	private BigDecimal ama_qt_calcio;
	
	@Column(name="ama_qt_cloreto", columnDefinition="numeric")
	private BigDecimal ama_qt_cloreto;
	
	@Column(name="ama_qt_carbonato", columnDefinition="numeric")
	private BigDecimal ama_qt_carbonato;
	
	@Column(name="ama_qt_durezatotal", columnDefinition="numeric")
	private BigDecimal ama_qt_durezatotal;
	
	@Column(name="ama_qt_fluoretos", columnDefinition="numeric")
	private BigDecimal ama_qt_fluoretos;
	
	@Column(name="ama_qt_ferrototal", columnDefinition="numeric")
	private BigDecimal ama_qt_ferrototal;
	
	@Column(name="ama_qt_bicarbonato", columnDefinition="numeric")
	private BigDecimal ama_qt_bicarbonato;
	
	@Column(name="ama_qt_potassio", columnDefinition="numeric")
	private BigDecimal ama_qt_potassio;
	
	@Column(name="ama_qt_magnesio", columnDefinition="numeric")
	private BigDecimal ama_qt_magnesio;
	
	@Column(name="ama_qt_sodio", columnDefinition="numeric")
	private BigDecimal ama_qt_sodio;
	
	@Column(name="ama_qt_nitritos", columnDefinition="numeric")
	private BigDecimal ama_qt_nitritos;
	
	@Column(name="ama_qt_nitratos", columnDefinition="numeric")
	private BigDecimal ama_qt_nitratos;
	
	@Column(name="ama_qt_sulfato", columnDefinition="numeric")
	private BigDecimal ama_qt_sulfato;
	
	@Column(name="ama_nu_condutividadeeletrica", columnDefinition="numeric")
	private BigDecimal ama_nu_condutividadeeletrica;
	
	@Column(name="ama_dt_analise", columnDefinition="timestamp without time zone")
	private Date ama_dt_analise;
	
	@Column(name="ama_dt_coleta", columnDefinition="timestamp without time zone")
	private Date ama_dt_coleta;
	
	@Column(name="ama_qt_coliformesfecais", columnDefinition="numeric")
	private BigDecimal ama_qt_coliformesfecais;
	
	@Column(name="ama_qt_coliformestotais", columnDefinition="numeric")
	private BigDecimal ama_qt_coliformestotais;
	
	@Column(name="ama_qt_ph", columnDefinition="numeric")
	private BigDecimal ama_qt_ph;
	
	@Column(name="ama_qt_std", columnDefinition="numeric")
	private BigDecimal ama_qt_std;
	
	@Column(name="ama_qt_temperatura", columnDefinition="numeric")
	private BigDecimal ama_qt_temperatura;
	
	

	public Integer getAma_int_pfk() {
		return ama_int_pfk;
	}

	public void setAma_int_pfk(Integer ama_int_pfk) {
		this.ama_int_pfk = ama_int_pfk;
	}

	public BigDecimal getAma_qt_calcio() {
		return ama_qt_calcio;
	}

	public void setAma_qt_calcio(BigDecimal ama_qt_calcio) {
		this.ama_qt_calcio = ama_qt_calcio;
	}

	public BigDecimal getAma_qt_cloreto() {
		return ama_qt_cloreto;
	}

	public void setAma_qt_cloreto(BigDecimal ama_qt_cloreto) {
		this.ama_qt_cloreto = ama_qt_cloreto;
	}

	public BigDecimal getAma_qt_carbonato() {
		return ama_qt_carbonato;
	}

	public void setAma_qt_carbonato(BigDecimal ama_qt_carbonato) {
		this.ama_qt_carbonato = ama_qt_carbonato;
	}

	public BigDecimal getAma_qt_durezatotal() {
		return ama_qt_durezatotal;
	}

	public void setAma_qt_durezatotal(BigDecimal ama_qt_durezatotal) {
		this.ama_qt_durezatotal = ama_qt_durezatotal;
	}

	public BigDecimal getAma_qt_fluoretos() {
		return ama_qt_fluoretos;
	}

	public void setAma_qt_fluoretos(BigDecimal ama_qt_fluoretos) {
		this.ama_qt_fluoretos = ama_qt_fluoretos;
	}

	public BigDecimal getAma_qt_ferrototal() {
		return ama_qt_ferrototal;
	}

	public void setAma_qt_ferrototal(BigDecimal ama_qt_ferrototal) {
		this.ama_qt_ferrototal = ama_qt_ferrototal;
	}

	public BigDecimal getAma_qt_bicarbonato() {
		return ama_qt_bicarbonato;
	}

	public void setAma_qt_bicarbonato(BigDecimal ama_qt_bicarbonato) {
		this.ama_qt_bicarbonato = ama_qt_bicarbonato;
	}

	public BigDecimal getAma_qt_potassio() {
		return ama_qt_potassio;
	}

	public void setAma_qt_potassio(BigDecimal ama_qt_potassio) {
		this.ama_qt_potassio = ama_qt_potassio;
	}

	public BigDecimal getAma_qt_magnesio() {
		return ama_qt_magnesio;
	}

	public void setAma_qt_magnesio(BigDecimal ama_qt_magnesio) {
		this.ama_qt_magnesio = ama_qt_magnesio;
	}

	public BigDecimal getAma_qt_sodio() {
		return ama_qt_sodio;
	}

	public void setAma_qt_sodio(BigDecimal ama_qt_sodio) {
		this.ama_qt_sodio = ama_qt_sodio;
	}

	public BigDecimal getAma_qt_nitritos() {
		return ama_qt_nitritos;
	}

	public void setAma_qt_nitritos(BigDecimal ama_qt_nitritos) {
		this.ama_qt_nitritos = ama_qt_nitritos;
	}

	public BigDecimal getAma_qt_nitratos() {
		return ama_qt_nitratos;
	}

	public void setAma_qt_nitratos(BigDecimal ama_qt_nitratos) {
		this.ama_qt_nitratos = ama_qt_nitratos;
	}

	public BigDecimal getAma_qt_sulfato() {
		return ama_qt_sulfato;
	}

	public void setAma_qt_sulfato(BigDecimal ama_qt_sulfato) {
		this.ama_qt_sulfato = ama_qt_sulfato;
	}

	public BigDecimal getAma_nu_condutividadeeletrica() {
		return ama_nu_condutividadeeletrica;
	}

	public void setAma_nu_condutividadeeletrica(BigDecimal ama_nu_condutividadeeletrica) {
		this.ama_nu_condutividadeeletrica = ama_nu_condutividadeeletrica;
	}

	public Date getAma_dt_analise() {
		return ama_dt_analise;
	}

	public void setAma_dt_analise(Date ama_dt_analise) {
		this.ama_dt_analise = ama_dt_analise;
	}

	public Date getAma_dt_coleta() {
		return ama_dt_coleta;
	}

	public void setAma_dt_coleta(Date ama_dt_coleta) {
		this.ama_dt_coleta = ama_dt_coleta;
	}

	public BigDecimal getAma_qt_coliformesfecais() {
		return ama_qt_coliformesfecais;
	}

	public void setAma_qt_coliformesfecais(BigDecimal ama_qt_coliformesfecais) {
		this.ama_qt_coliformesfecais = ama_qt_coliformesfecais;
	}

	public BigDecimal getAma_qt_coliformestotais() {
		return ama_qt_coliformestotais;
	}

	public void setAma_qt_coliformestotais(BigDecimal ama_qt_coliformestotais) {
		this.ama_qt_coliformestotais = ama_qt_coliformestotais;
	}

	public BigDecimal getAma_qt_ph() {
		return ama_qt_ph;
	}

	public void setAma_qt_ph(BigDecimal ama_qt_ph) {
		this.ama_qt_ph = ama_qt_ph;
	}

	public BigDecimal getAma_qt_std() {
		return ama_qt_std;
	}

	public void setAma_qt_std(BigDecimal ama_qt_std) {
		this.ama_qt_std = ama_qt_std;
	}

	public BigDecimal getAma_qt_temperatura() {
		return ama_qt_temperatura;
	}

	public void setAma_qt_temperatura(BigDecimal ama_qt_temperatura) {
		this.ama_qt_temperatura = ama_qt_temperatura;
	}
}