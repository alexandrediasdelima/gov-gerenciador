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
@Table(name="tb_cnarh")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)

public class Cnarh implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="cnarh_id")
	@Id
	private String cnarh_id;

	@Column(name="asb_nu_cotaterreno", columnDefinition="numeric")
	private BigDecimal asb_nu_cotaterreno;

	@Column(name="asb_nu_alturabocatubo", columnDefinition="numeric")
	private BigDecimal asb_nu_alturabocatubo;

	@Column(name="ius_nu_alturares", columnDefinition="numeric")
	private BigDecimal ius_nu_alturares;

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

	@Column(name="asb_aqp_cd", columnDefinition="numeric")
	private BigDecimal asb_aqp_cd;

	@Column(name="ius_ar_resmax", columnDefinition="numeric")
	private BigDecimal ius_ar_resmax;

	@Column(name="tst_nu_coeficientearmazenamento", columnDefinition="numeric")
	private BigDecimal tst_nu_coeficientearmazenamento;

	@Column(name="ama_nu_condutividadeeletrica", columnDefinition="numeric")
	private BigDecimal ama_nu_condutividadeeletrica;

	@Column(name="tst_nu_condutividadehidraulica", columnDefinition="numeric")
	private BigDecimal tst_nu_condutividadehidraulica;

	@Column(name="ama_dt_analise", columnDefinition="date")
	private Date ama_dt_analise;

	@Column(name="ama_dt_coleta", columnDefinition="date")
	private Date ama_dt_coleta;

	@Column(name="asb_dt_instalacao", columnDefinition="date")
	private Date asb_dt_instalacao;

	@Column(name="tst_dt", columnDefinition="date")
	private Date tst_dt;

	@Column(name="asb_nu_diametroperfuracao", columnDefinition="numeric")
	private BigDecimal asb_nu_diametroperfuracao;

	@Column(name="asb_nu_diametrofiltro", columnDefinition="numeric")
	private BigDecimal asb_nu_diametrofiltro;

	@Column(name="tst_ds_tempoduracao")
	private String tst_ds_tempoduracao;

	@Column(name="tst_nu_nd", columnDefinition="numeric")
	private BigDecimal tst_nu_nd;

	@Column(name="tst_nu_ne", columnDefinition="numeric")
	private BigDecimal tst_nu_ne;

	@Column(name="int_nu_siagas")
	private String int_nu_siagas;

	@Column(name="ama_qt_coliformesfecais", columnDefinition="numeric")
	private BigDecimal ama_qt_coliformesfecais;

	@Column(name="ama_qt_coliformestotais", columnDefinition="numeric")
	private BigDecimal ama_qt_coliformestotais;

	@Column(name="tst_nu_permeabilidade", columnDefinition="numeric")
	private BigDecimal tst_nu_permeabilidade;

	@Column(name="ama_qt_ph", columnDefinition="numeric")
	private BigDecimal ama_qt_ph;

	@Column(name="asb_nu_base", columnDefinition="numeric")
	private BigDecimal asb_nu_base;

	@Column(name="asb_nu_topo", columnDefinition="numeric")
	private BigDecimal asb_nu_topo;

	@Column(name="ama_qt_std", columnDefinition="numeric")
	private BigDecimal ama_qt_std;

	@Column(name="ama_qt_temperatura", columnDefinition="numeric")
	private BigDecimal ama_qt_temperatura;

	@Column(name="tst_nu_transmissividade", columnDefinition="numeric")
	private BigDecimal tst_nu_transmissividade;

	@Column(name="tst_vz_estabilizacao", columnDefinition="numeric")
	private BigDecimal tst_vz_estabilizacao;

	@Column(name="ius_vo_resmax", columnDefinition="numeric")
	private BigDecimal ius_vo_resmax;

	@Enumerated(EnumType.STRING)
	@Column(name="asb_tnp_cd", columnDefinition="asb_tnp_enum")
	@Type(type="pgsql_enum")
	@Transient
	private Asb_tnp_cd asb_tnp_cd;

	@Enumerated(EnumType.STRING)
	@Column(name="asb_tpn_cd", columnDefinition="asb_tpn_enum")
	@Type(type="pgsql_enum")
	@Transient
	private Asb_tpn_cd asb_tpn_cd;

	@Enumerated(EnumType.STRING)
	@Column(name="asb_tca_cd", columnDefinition="asb_tca_enum")
	@Type(type="pgsql_enum")
	@Transient
	private Asb_tca_cd asb_tca_cd;

	@Enumerated(EnumType.STRING)
	@Column(name="tst_ttb_cd", columnDefinition="tst_ttb_enum")
	@Type(type="pgsql_enum")
	@Transient
	private Tst_ttb_cd tst_ttb_cd;

	@Enumerated(EnumType.STRING)
	@Column(name="tst_tmi_cd", columnDefinition="tst_tmi_enum")
	@Type(type="pgsql_enum")
	@Transient
	private Tst_tmi_cd tst_tmi_cd;

	public String getCnarh_id() {
		return cnarh_id;
	}

	public void setCnarh_id(String cnarh_id) {
		this.cnarh_id = cnarh_id;
	}

	public BigDecimal getAsb_nu_cotaterreno() {
		return asb_nu_cotaterreno;
	}

	public void setAsb_nu_cotaterreno(BigDecimal asb_nu_cotaterreno) {
		this.asb_nu_cotaterreno = asb_nu_cotaterreno;
	}

	public BigDecimal getAsb_nu_alturabocatubo() {
		return asb_nu_alturabocatubo;
	}

	public void setAsb_nu_alturabocatubo(BigDecimal asb_nu_alturabocatubo) {
		this.asb_nu_alturabocatubo = asb_nu_alturabocatubo;
	}

	public BigDecimal getIus_nu_alturares() {
		return ius_nu_alturares;
	}

	public void setIus_nu_alturares(BigDecimal ius_nu_alturares) {
		this.ius_nu_alturares = ius_nu_alturares;
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

	public BigDecimal getAsb_aqp_cd() {
		return asb_aqp_cd;
	}

	public void setAsb_aqp_cd(BigDecimal asb_aqp_cd) {
		this.asb_aqp_cd = asb_aqp_cd;
	}

	public BigDecimal getIus_ar_resmax() {
		return ius_ar_resmax;
	}

	public void setIus_ar_resmax(BigDecimal ius_ar_resmax) {
		this.ius_ar_resmax = ius_ar_resmax;
	}

	public BigDecimal getTst_nu_coeficientearmazenamento() {
		return tst_nu_coeficientearmazenamento;
	}

	public void setTst_nu_coeficientearmazenamento(BigDecimal tst_nu_coeficientearmazenamento) {
		this.tst_nu_coeficientearmazenamento = tst_nu_coeficientearmazenamento;
	}

	public BigDecimal getAma_nu_condutividadeeletrica() {
		return ama_nu_condutividadeeletrica;
	}

	public void setAma_nu_condutividadeeletrica(BigDecimal ama_nu_condutividadeeletrica) {
		this.ama_nu_condutividadeeletrica = ama_nu_condutividadeeletrica;
	}

	public BigDecimal getTst_nu_condutividadehidraulica() {
		return tst_nu_condutividadehidraulica;
	}

	public void setTst_nu_condutividadehidraulica(BigDecimal tst_nu_condutividadehidraulica) {
		this.tst_nu_condutividadehidraulica = tst_nu_condutividadehidraulica;
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

	public Date getAsb_dt_instalacao() {
		return asb_dt_instalacao;
	}

	public void setAsb_dt_instalacao(Date asb_dt_instalacao) {
		this.asb_dt_instalacao = asb_dt_instalacao;
	}

	public Date getTst_dt() {
		return tst_dt;
	}

	public void setTst_dt(Date tst_dt) {
		this.tst_dt = tst_dt;
	}

	public BigDecimal getAsb_nu_diametroperfuracao() {
		return asb_nu_diametroperfuracao;
	}

	public void setAsb_nu_diametroperfuracao(BigDecimal asb_nu_diametroperfuracao) {
		this.asb_nu_diametroperfuracao = asb_nu_diametroperfuracao;
	}

	public BigDecimal getAsb_nu_diametrofiltro() {
		return asb_nu_diametrofiltro;
	}

	public void setAsb_nu_diametrofiltro(BigDecimal asb_nu_diametrofiltro) {
		this.asb_nu_diametrofiltro = asb_nu_diametrofiltro;
	}

	public String getTst_ds_tempoduracao() {
		return tst_ds_tempoduracao;
	}

	public void setTst_ds_tempoduracao(String tst_ds_tempoduracao) {
		this.tst_ds_tempoduracao = tst_ds_tempoduracao;
	}

	public BigDecimal getTst_nu_nd() {
		return tst_nu_nd;
	}

	public void setTst_nu_nd(BigDecimal tst_nu_nd) {
		this.tst_nu_nd = tst_nu_nd;
	}

	public BigDecimal getTst_nu_ne() {
		return tst_nu_ne;
	}

	public void setTst_nu_ne(BigDecimal tst_nu_ne) {
		this.tst_nu_ne = tst_nu_ne;
	}

	public String getInt_nu_siagas() {
		return int_nu_siagas;
	}

	public void setInt_nu_siagas(String int_nu_siagas) {
		this.int_nu_siagas = int_nu_siagas;
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

	public BigDecimal getTst_nu_permeabilidade() {
		return tst_nu_permeabilidade;
	}

	public void setTst_nu_permeabilidade(BigDecimal tst_nu_permeabilidade) {
		this.tst_nu_permeabilidade = tst_nu_permeabilidade;
	}

	public BigDecimal getAma_qt_ph() {
		return ama_qt_ph;
	}

	public void setAma_qt_ph(BigDecimal ama_qt_ph) {
		this.ama_qt_ph = ama_qt_ph;
	}

	public BigDecimal getAsb_nu_base() {
		return asb_nu_base;
	}

	public void setAsb_nu_base(BigDecimal asb_nu_base) {
		this.asb_nu_base = asb_nu_base;
	}

	public BigDecimal getAsb_nu_topo() {
		return asb_nu_topo;
	}

	public void setAsb_nu_topo(BigDecimal asb_nu_topo) {
		this.asb_nu_topo = asb_nu_topo;
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

	public BigDecimal getTst_nu_transmissividade() {
		return tst_nu_transmissividade;
	}

	public void setTst_nu_transmissividade(BigDecimal tst_nu_transmissividade) {
		this.tst_nu_transmissividade = tst_nu_transmissividade;
	}

	public BigDecimal getTst_vz_estabilizacao() {
		return tst_vz_estabilizacao;
	}

	public void setTst_vz_estabilizacao(BigDecimal tst_vz_estabilizacao) {
		this.tst_vz_estabilizacao = tst_vz_estabilizacao;
	}

	public BigDecimal getIus_vo_resmax() {
		return ius_vo_resmax;
	}

	public void setIus_vo_resmax(BigDecimal ius_vo_resmax) {
		this.ius_vo_resmax = ius_vo_resmax;
	}

	public Asb_tnp_cd getAsb_tnp_cd() {
		return asb_tnp_cd;
	}

	public void setAsb_tnp_cd(Asb_tnp_cd asb_tnp_cd) {
		this.asb_tnp_cd = asb_tnp_cd;
	}

	public Asb_tpn_cd getAsb_tpn_cd() {
		return asb_tpn_cd;
	}

	public void setAsb_tpn_cd(Asb_tpn_cd asb_tpn_cd) {
		this.asb_tpn_cd = asb_tpn_cd;
	}

	public Asb_tca_cd getAsb_tca_cd() {
		return asb_tca_cd;
	}

	public void setAsb_tca_cd(Asb_tca_cd asb_tca_cd) {
		this.asb_tca_cd = asb_tca_cd;
	}

	public Tst_ttb_cd getTst_ttb_cd() {
		return tst_ttb_cd;
	}

	public void setTst_ttb_cd(Tst_ttb_cd tst_ttb_cd) {
		this.tst_ttb_cd = tst_ttb_cd;
	}

	public Tst_tmi_cd getTst_tmi_cd() {
		return tst_tmi_cd;
	}

	public void setTst_tmi_cd(Tst_tmi_cd tst_tmi_cd) {
		this.tst_tmi_cd = tst_tmi_cd;
	}

}
