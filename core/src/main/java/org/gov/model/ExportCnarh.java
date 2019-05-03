package org.gov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Table(name="vw_export_cnarh")
@Subselect("select * from vw_export_cnarh")
public class ExportCnarh {
	private static final long serialVersionUID = 1L;

	@Column (name="int_tin_cd")
	@Id
	private String int_tin_cd;

	@Column (name="int_tsu_cd")
	private String int_tsu_cd;

	@Column (name="int_tsi_cd")
	private String int_tsi_cd;

	@Column (name="int_cr_latitude")
	private String int_cr_latitude;

	@Column (name="int_cr_longitude")
	private String int_cr_longitude;

	@Column (name="ing_nu_ibgemunicipio")
	private String ing_nu_ibgemunicipio;

	@Column (name="emp_nm_empreendimento")
	private String emp_nm_empreendimento;

	@Column (name="emp_nu_cpfcnpj")
	private String emp_nu_cpfcnpj;

	@Column (name="emp_nm_usuario")
	private String emp_nm_usuario;

	@Column (name="emp_ds_emailresponsavel")
	private String emp_ds_emailresponsavel;

	@Column (name="emp_nu_cependereco")
	private String emp_nu_cependereco;

	@Column (name="emp_ds_logradouro")
	private String emp_ds_logradouro;

	@Column (name="emp_ds_complementoendereco")
	private String emp_ds_complementoendereco;

	@Column (name="emp_nu_logradouro")
	private String emp_nu_logradouro;

	@Column (name="emp_nu_caixapostal")
	private String emp_nu_caixapostal;

	@Column (name="emp_cd_codigoibgecorrespondencia")
	private String emp_cd_codigoibgecorrespondencia;

	@Column (name="emp_nu_ddd")
	private String emp_nu_ddd;

	@Column (name="emp_nu_telefone")
	private String emp_nu_telefone;

	@Column (name="out_tpo_cd")
	private String out_tpo_cd;

	@Column (name="out_tsp_cd")
	private String out_tsp_cd;

	@Column (name="out_dt_inicial")
	private String out_dt_inicial;

	@Column (name="out_dt_final")
	private String out_dt_final;

	@Column (name="out_nu_processo")
	private String out_nu_processo;

	@Column (name="out_ds_ato")
	private String out_ds_ato;

	@Column (name="out_nu_ato")
	private String out_nu_ato;

	@Column (name="int_nu_siagas")
	private String int_nu_siagas;

	@Column (name="ope_vz_mesjan")
	private String ope_vz_mesjan;

	@Column (name="ope_vz_mesfev")
	private String ope_vz_mesfev;

	@Column (name="ope_vz_mesmar")
	private String ope_vz_mesmar;

	@Column (name="ope_vz_mesabr")
	private String ope_vz_mesabr;

	@Column (name="ope_vz_mesmai")
	private String ope_vz_mesmai;

	@Column (name="ope_vz_mesjun")
	private String ope_vz_mesjun;

	@Column (name="ope_vz_mesjul")
	private String ope_vz_mesjul;

	@Column (name="ope_vz_mesago")
	private String ope_vz_mesago;

	@Column (name="ope_vz_messet")
	private String ope_vz_messet;

	@Column (name="ope_vz_mesout")
	private String ope_vz_mesout;

	@Column (name="ope_vz_mesnov")
	private String ope_vz_mesnov;

	@Column (name="ope_vz_mesdez")
	private String ope_vz_mesdez;

	@Column (name="ope_qt_horasjan")
	private String ope_qt_horasjan;

	@Column (name="ope_qt_horasfev")
	private String ope_qt_horasfev;

	@Column (name="ope_qt_horasmar")
	private String ope_qt_horasmar;

	@Column (name="ope_qt_horasabr")
	private String ope_qt_horasabr;

	@Column (name="ope_qt_horasmai")
	private String ope_qt_horasmai;

	@Column (name="ope_qt_horasjun")
	private String ope_qt_horasjun;

	@Column (name="ope_qt_horasjul")
	private String ope_qt_horasjul;

	@Column (name="ope_qt_horasago")
	private String ope_qt_horasago;

	@Column (name="ope_qt_horasset")
	private String ope_qt_horasset;

	@Column (name="ope_qt_horasout")
	private String ope_qt_horasout;

	@Column (name="ope_qt_horasnov")
	private String ope_qt_horasnov;

	@Column (name="ope_qt_horasdez")
	private String ope_qt_horasdez;

	@Column (name="ope_qt_diajan")
	private String ope_qt_diajan;

	@Column (name="ope_qt_diafev")
	private String ope_qt_diafev;

	@Column (name="ope_qt_diamar")
	private String ope_qt_diamar;

	@Column (name="ope_qt_diaabr")
	private String ope_qt_diaabr;

	@Column (name="ope_qt_diamai")
	private String ope_qt_diamai;

	@Column (name="ope_qt_diajun")
	private String ope_qt_diajun;

	@Column (name="ope_qt_diajul")
	private String ope_qt_diajul;

	@Column (name="ope_qt_diaago")
	private String ope_qt_diaago;

	@Column (name="ope_qt_diaset")
	private String ope_qt_diaset;

	@Column (name="ope_qt_diaout")
	private String ope_qt_diaout;

	@Column (name="ope_qt_dianov")
	private String ope_qt_dianov;

	@Column (name="ope_qt_diadez")
	private String ope_qt_diadez;

	@Column (name="int_vz_maxima")
	private String int_vz_maxima;

	@Column (name="fou_tou_cd")
	private String fou_tou_cd;

	@Column (name="sir_tsi_cd")
	private String sir_tsi_cd;

	@Column (name="sir_tct_cd")
	private String sir_tct_cd;

	@Column (name="sir_ar_irrigada")
	private String sir_ar_irrigada;

	@Column (name="ius_nu_alturares")
	private String ius_nu_alturares;

	@Column (name="ius_ar_resmax")
	private String ius_ar_resmax;

	@Column (name="ius_vo_resmax")
	private String ius_vo_resmax;

	@Column (name="efl_qt_dbobruto")
	private String efl_qt_dbobruto;

	@Column (name="efl_qt_dbotratado")
	private String efl_qt_dbotratado;

	@Column (name="efl_qt_fosforobruto")
	private String efl_qt_fosforobruto;

	@Column (name="efl_qt_fosforotratado")
	private String efl_qt_fosforotratado;

	@Column (name="efl_qt_nitrogeniobruto")
	private String efl_qt_nitrogeniobruto;

	@Column (name="efl_qt_nitrogeniotratado")
	private String efl_qt_nitrogeniotratado;

	@Column (name="asb_dt_instalacao")
	private String asb_dt_instalacao;

	@Column (name="asb_tpn_cd")
	private String asb_tpn_cd;

	@Column (name="asb_nu_diametroperfuracao")
	private String asb_nu_diametroperfuracao;

	@Column (name="asb_nu_diametrofiltro")
	private String asb_nu_diametrofiltro;

	@Column (name="asb_aqp_cd")
	private String asb_aqp_cd;

	@Column (name="asb_nu_topo")
	private String asb_nu_topo;

	@Column (name="asb_nu_base")
	private String asb_nu_base;

	@Column (name="asb_tnp_cd")
	private String asb_tnp_cd;

	@Column (name="asb_tca_cd")
	private String asb_tca_cd;

	@Column (name="asb_nu_profundidadefinal")
	private String asb_nu_profundidadefinal;

	@Column (name="asb_nu_alturabocatubo")
	private String asb_nu_alturabocatubo;

	@Column (name="asb_nu_cotaterreno")
	private String asb_nu_cotaterreno;

	@Column (name="tst_dt")
	private String tst_dt;

	@Column (name="tst_ttb_cd")
	private String tst_ttb_cd;

	@Column (name="tst_ds_tempoduracao")
	private String tst_ds_tempoduracao;

	@Column (name="tst_nu_nd")
	private String tst_nu_nd;

	@Column (name="tst_nu_ne")
	private String tst_nu_ne;

	@Column (name="tst_vz_estabilizacao")
	private String tst_vz_estabilizacao;

	@Column (name="tst_tmi_cd")
	private String tst_tmi_cd;

	@Column (name="tst_nu_coeficientearmazenamento")
	private String tst_nu_coeficientearmazenamento;

	@Column (name="tst_nu_transmissividade")
	private String tst_nu_transmissividade;

	@Column (name="tst_nu_condutividadehidraulica")
	private String tst_nu_condutividadehidraulica;

	@Column (name="tst_nu_permeabilidade")
	private String tst_nu_permeabilidade;

	@Column (name="ama_dt_coleta")
	private String ama_dt_coleta;

	@Column (name="ama_dt_analise")
	private String ama_dt_analise;

	@Column (name="ama_nu_condutividadeeletrica")
	private String ama_nu_condutividadeeletrica;

	@Column (name="ama_qt_temperatura")
	private String ama_qt_temperatura;

	@Column (name="ama_qt_std")
	private String ama_qt_std;

	@Column (name="ama_qt_ph")
	private String ama_qt_ph;

	@Column (name="ama_qt_coliformestotais")
	private String ama_qt_coliformestotais;

	@Column (name="ama_qt_coliformesfecais")
	private String ama_qt_coliformesfecais;

	@Column (name="ama_qt_bicarbonato")
	private String ama_qt_bicarbonato;

	@Column (name="ama_qt_calcio")
	private String ama_qt_calcio;

	@Column (name="ama_qt_carbonato")
	private String ama_qt_carbonato;

	@Column (name="ama_qt_cloreto")
	private String ama_qt_cloreto;

	@Column (name="ama_qt_durezatotal")
	private String ama_qt_durezatotal;

	@Column (name="ama_qt_ferrototal")
	private String ama_qt_ferrototal;

	@Column (name="ama_qt_fluoretos")
	private String ama_qt_fluoretos;

	@Column (name="ama_qt_nitratos")
	private String ama_qt_nitratos;

	@Column (name="ama_qt_nitritos")
	private String ama_qt_nitritos;

	@Column (name="ama_qt_potassio")
	private String ama_qt_potassio;

	@Column (name="ama_qt_sodio")
	private String ama_qt_sodio;

	@Column (name="ama_qt_sulfato")
	private String ama_qt_sulfato;

	@Column (name="ama_qt_magnesio")
	private String ama_qt_magnesio;

	public String getInt_tin_cd() {
		return int_tin_cd;
	}

	public void setInt_tin_cd(String int_tin_cd) {
		this.int_tin_cd = int_tin_cd;
	}

	public String getInt_tsu_cd() {
		return int_tsu_cd;
	}

	public void setInt_tsu_cd(String int_tsu_cd) {
		this.int_tsu_cd = int_tsu_cd;
	}

	public String getInt_tsi_cd() {
		return int_tsi_cd;
	}

	public void setInt_tsi_cd(String int_tsi_cd) {
		this.int_tsi_cd = int_tsi_cd;
	}

	public String getInt_cr_latitude() {
		return int_cr_latitude;
	}

	public void setInt_cr_latitude(String int_cr_latitude) {
		this.int_cr_latitude = int_cr_latitude;
	}

	public String getInt_cr_longitude() {
		return int_cr_longitude;
	}

	public void setInt_cr_longitude(String int_cr_longitude) {
		this.int_cr_longitude = int_cr_longitude;
	}

	public String getIng_nu_ibgemunicipio() {
		return ing_nu_ibgemunicipio;
	}

	public void setIng_nu_ibgemunicipio(String ing_nu_ibgemunicipio) {
		this.ing_nu_ibgemunicipio = ing_nu_ibgemunicipio;
	}

	public String getEmp_nm_empreendimento() {
		return emp_nm_empreendimento;
	}

	public void setEmp_nm_empreendimento(String emp_nm_empreendimento) {
		this.emp_nm_empreendimento = emp_nm_empreendimento;
	}

	public String getEmp_nu_cpfcnpj() {
		return emp_nu_cpfcnpj;
	}

	public void setEmp_nu_cpfcnpj(String emp_nu_cpfcnpj) {
		this.emp_nu_cpfcnpj = emp_nu_cpfcnpj;
	}

	public String getEmp_nm_usuario() {
		return emp_nm_usuario;
	}

	public void setEmp_nm_usuario(String emp_nm_usuario) {
		this.emp_nm_usuario = emp_nm_usuario;
	}

	public String getEmp_ds_emailresponsavel() {
		return emp_ds_emailresponsavel;
	}

	public void setEmp_ds_emailresponsavel(String emp_ds_emailresponsavel) {
		this.emp_ds_emailresponsavel = emp_ds_emailresponsavel;
	}

	public String getEmp_nu_cependereco() {
		return emp_nu_cependereco;
	}

	public void setEmp_nu_cependereco(String emp_nu_cependereco) {
		this.emp_nu_cependereco = emp_nu_cependereco;
	}

	public String getEmp_ds_logradouro() {
		return emp_ds_logradouro;
	}

	public void setEmp_ds_logradouro(String emp_ds_logradouro) {
		this.emp_ds_logradouro = emp_ds_logradouro;
	}

	public String getEmp_ds_complementoendereco() {
		return emp_ds_complementoendereco;
	}

	public void setEmp_ds_complementoendereco(String emp_ds_complementoendereco) {
		this.emp_ds_complementoendereco = emp_ds_complementoendereco;
	}

	public String getEmp_nu_logradouro() {
		return emp_nu_logradouro;
	}

	public void setEmp_nu_logradouro(String emp_nu_logradouro) {
		this.emp_nu_logradouro = emp_nu_logradouro;
	}

	public String getEmp_nu_caixapostal() {
		return emp_nu_caixapostal;
	}

	public void setEmp_nu_caixapostal(String emp_nu_caixapostal) {
		this.emp_nu_caixapostal = emp_nu_caixapostal;
	}

	public String getEmp_cd_codigoibgecorrespondencia() {
		return emp_cd_codigoibgecorrespondencia;
	}

	public void setEmp_cd_codigoibgecorrespondencia(String emp_cd_codigoibgecorrespondencia) {
		this.emp_cd_codigoibgecorrespondencia = emp_cd_codigoibgecorrespondencia;
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

	public String getOut_tpo_cd() {
		return out_tpo_cd;
	}

	public void setOut_tpo_cd(String out_tpo_cd) {
		this.out_tpo_cd = out_tpo_cd;
	}

	public String getOut_tsp_cd() {
		return out_tsp_cd;
	}

	public void setOut_tsp_cd(String out_tsp_cd) {
		this.out_tsp_cd = out_tsp_cd;
	}

	public String getOut_dt_inicial() {
		return out_dt_inicial;
	}

	public void setOut_dt_inicial(String out_dt_inicial) {
		this.out_dt_inicial = out_dt_inicial;
	}

	public String getOut_dt_final() {
		return out_dt_final;
	}

	public void setOut_dt_final(String out_dt_final) {
		this.out_dt_final = out_dt_final;
	}

	public String getOut_nu_processo() {
		return out_nu_processo;
	}

	public void setOut_nu_processo(String out_nu_processo) {
		this.out_nu_processo = out_nu_processo;
	}

	public String getOut_ds_ato() {
		return out_ds_ato;
	}

	public void setOut_ds_ato(String out_ds_ato) {
		this.out_ds_ato = out_ds_ato;
	}

	public String getOut_nu_ato() {
		return out_nu_ato;
	}

	public void setOut_nu_ato(String out_nu_ato) {
		this.out_nu_ato = out_nu_ato;
	}

	public String getInt_nu_siagas() {
		return int_nu_siagas;
	}

	public void setInt_nu_siagas(String int_nu_siagas) {
		this.int_nu_siagas = int_nu_siagas;
	}

	public String getOpe_vz_mesjan() {
		return ope_vz_mesjan;
	}

	public void setOpe_vz_mesjan(String ope_vz_mesjan) {
		this.ope_vz_mesjan = ope_vz_mesjan;
	}

	public String getOpe_vz_mesfev() {
		return ope_vz_mesfev;
	}

	public void setOpe_vz_mesfev(String ope_vz_mesfev) {
		this.ope_vz_mesfev = ope_vz_mesfev;
	}

	public String getOpe_vz_mesmar() {
		return ope_vz_mesmar;
	}

	public void setOpe_vz_mesmar(String ope_vz_mesmar) {
		this.ope_vz_mesmar = ope_vz_mesmar;
	}

	public String getOpe_vz_mesabr() {
		return ope_vz_mesabr;
	}

	public void setOpe_vz_mesabr(String ope_vz_mesabr) {
		this.ope_vz_mesabr = ope_vz_mesabr;
	}

	public String getOpe_vz_mesmai() {
		return ope_vz_mesmai;
	}

	public void setOpe_vz_mesmai(String ope_vz_mesmai) {
		this.ope_vz_mesmai = ope_vz_mesmai;
	}

	public String getOpe_vz_mesjun() {
		return ope_vz_mesjun;
	}

	public void setOpe_vz_mesjun(String ope_vz_mesjun) {
		this.ope_vz_mesjun = ope_vz_mesjun;
	}

	public String getOpe_vz_mesjul() {
		return ope_vz_mesjul;
	}

	public void setOpe_vz_mesjul(String ope_vz_mesjul) {
		this.ope_vz_mesjul = ope_vz_mesjul;
	}

	public String getOpe_vz_mesago() {
		return ope_vz_mesago;
	}

	public void setOpe_vz_mesago(String ope_vz_mesago) {
		this.ope_vz_mesago = ope_vz_mesago;
	}

	public String getOpe_vz_messet() {
		return ope_vz_messet;
	}

	public void setOpe_vz_messet(String ope_vz_messet) {
		this.ope_vz_messet = ope_vz_messet;
	}

	public String getOpe_vz_mesout() {
		return ope_vz_mesout;
	}

	public void setOpe_vz_mesout(String ope_vz_mesout) {
		this.ope_vz_mesout = ope_vz_mesout;
	}

	public String getOpe_vz_mesnov() {
		return ope_vz_mesnov;
	}

	public void setOpe_vz_mesnov(String ope_vz_mesnov) {
		this.ope_vz_mesnov = ope_vz_mesnov;
	}

	public String getOpe_vz_mesdez() {
		return ope_vz_mesdez;
	}

	public void setOpe_vz_mesdez(String ope_vz_mesdez) {
		this.ope_vz_mesdez = ope_vz_mesdez;
	}

	public String getOpe_qt_horasjan() {
		return ope_qt_horasjan;
	}

	public void setOpe_qt_horasjan(String ope_qt_horasjan) {
		this.ope_qt_horasjan = ope_qt_horasjan;
	}

	public String getOpe_qt_horasfev() {
		return ope_qt_horasfev;
	}

	public void setOpe_qt_horasfev(String ope_qt_horasfev) {
		this.ope_qt_horasfev = ope_qt_horasfev;
	}

	public String getOpe_qt_horasmar() {
		return ope_qt_horasmar;
	}

	public void setOpe_qt_horasmar(String ope_qt_horasmar) {
		this.ope_qt_horasmar = ope_qt_horasmar;
	}

	public String getOpe_qt_horasabr() {
		return ope_qt_horasabr;
	}

	public void setOpe_qt_horasabr(String ope_qt_horasabr) {
		this.ope_qt_horasabr = ope_qt_horasabr;
	}

	public String getOpe_qt_horasmai() {
		return ope_qt_horasmai;
	}

	public void setOpe_qt_horasmai(String ope_qt_horasmai) {
		this.ope_qt_horasmai = ope_qt_horasmai;
	}

	public String getOpe_qt_horasjun() {
		return ope_qt_horasjun;
	}

	public void setOpe_qt_horasjun(String ope_qt_horasjun) {
		this.ope_qt_horasjun = ope_qt_horasjun;
	}

	public String getOpe_qt_horasjul() {
		return ope_qt_horasjul;
	}

	public void setOpe_qt_horasjul(String ope_qt_horasjul) {
		this.ope_qt_horasjul = ope_qt_horasjul;
	}

	public String getOpe_qt_horasago() {
		return ope_qt_horasago;
	}

	public void setOpe_qt_horasago(String ope_qt_horasago) {
		this.ope_qt_horasago = ope_qt_horasago;
	}

	public String getOpe_qt_horasset() {
		return ope_qt_horasset;
	}

	public void setOpe_qt_horasset(String ope_qt_horasset) {
		this.ope_qt_horasset = ope_qt_horasset;
	}

	public String getOpe_qt_horasout() {
		return ope_qt_horasout;
	}

	public void setOpe_qt_horasout(String ope_qt_horasout) {
		this.ope_qt_horasout = ope_qt_horasout;
	}

	public String getOpe_qt_horasnov() {
		return ope_qt_horasnov;
	}

	public void setOpe_qt_horasnov(String ope_qt_horasnov) {
		this.ope_qt_horasnov = ope_qt_horasnov;
	}

	public String getOpe_qt_horasdez() {
		return ope_qt_horasdez;
	}

	public void setOpe_qt_horasdez(String ope_qt_horasdez) {
		this.ope_qt_horasdez = ope_qt_horasdez;
	}

	public String getOpe_qt_diajan() {
		return ope_qt_diajan;
	}

	public void setOpe_qt_diajan(String ope_qt_diajan) {
		this.ope_qt_diajan = ope_qt_diajan;
	}

	public String getOpe_qt_diafev() {
		return ope_qt_diafev;
	}

	public void setOpe_qt_diafev(String ope_qt_diafev) {
		this.ope_qt_diafev = ope_qt_diafev;
	}

	public String getOpe_qt_diamar() {
		return ope_qt_diamar;
	}

	public void setOpe_qt_diamar(String ope_qt_diamar) {
		this.ope_qt_diamar = ope_qt_diamar;
	}

	public String getOpe_qt_diaabr() {
		return ope_qt_diaabr;
	}

	public void setOpe_qt_diaabr(String ope_qt_diaabr) {
		this.ope_qt_diaabr = ope_qt_diaabr;
	}

	public String getOpe_qt_diamai() {
		return ope_qt_diamai;
	}

	public void setOpe_qt_diamai(String ope_qt_diamai) {
		this.ope_qt_diamai = ope_qt_diamai;
	}

	public String getOpe_qt_diajun() {
		return ope_qt_diajun;
	}

	public void setOpe_qt_diajun(String ope_qt_diajun) {
		this.ope_qt_diajun = ope_qt_diajun;
	}

	public String getOpe_qt_diajul() {
		return ope_qt_diajul;
	}

	public void setOpe_qt_diajul(String ope_qt_diajul) {
		this.ope_qt_diajul = ope_qt_diajul;
	}

	public String getOpe_qt_diaago() {
		return ope_qt_diaago;
	}

	public void setOpe_qt_diaago(String ope_qt_diaago) {
		this.ope_qt_diaago = ope_qt_diaago;
	}

	public String getOpe_qt_diaset() {
		return ope_qt_diaset;
	}

	public void setOpe_qt_diaset(String ope_qt_diaset) {
		this.ope_qt_diaset = ope_qt_diaset;
	}

	public String getOpe_qt_diaout() {
		return ope_qt_diaout;
	}

	public void setOpe_qt_diaout(String ope_qt_diaout) {
		this.ope_qt_diaout = ope_qt_diaout;
	}

	public String getOpe_qt_dianov() {
		return ope_qt_dianov;
	}

	public void setOpe_qt_dianov(String ope_qt_dianov) {
		this.ope_qt_dianov = ope_qt_dianov;
	}

	public String getOpe_qt_diadez() {
		return ope_qt_diadez;
	}

	public void setOpe_qt_diadez(String ope_qt_diadez) {
		this.ope_qt_diadez = ope_qt_diadez;
	}

	public String getInt_vz_maxima() {
		return int_vz_maxima;
	}

	public void setInt_vz_maxima(String int_vz_maxima) {
		this.int_vz_maxima = int_vz_maxima;
	}

	public String getFou_tou_cd() {
		return fou_tou_cd;
	}

	public void setFou_tou_cd(String fou_tou_cd) {
		this.fou_tou_cd = fou_tou_cd;
	}

	public String getSir_tsi_cd() {
		return sir_tsi_cd;
	}

	public void setSir_tsi_cd(String sir_tsi_cd) {
		this.sir_tsi_cd = sir_tsi_cd;
	}

	public String getSir_tct_cd() {
		return sir_tct_cd;
	}

	public void setSir_tct_cd(String sir_tct_cd) {
		this.sir_tct_cd = sir_tct_cd;
	}

	public String getSir_ar_irrigada() {
		return sir_ar_irrigada;
	}

	public void setSir_ar_irrigada(String sir_ar_irrigada) {
		this.sir_ar_irrigada = sir_ar_irrigada;
	}

	public String getIus_nu_alturares() {
		return ius_nu_alturares;
	}

	public void setIus_nu_alturares(String ius_nu_alturares) {
		this.ius_nu_alturares = ius_nu_alturares;
	}

	public String getIus_ar_resmax() {
		return ius_ar_resmax;
	}

	public void setIus_ar_resmax(String ius_ar_resmax) {
		this.ius_ar_resmax = ius_ar_resmax;
	}

	public String getIus_vo_resmax() {
		return ius_vo_resmax;
	}

	public void setIus_vo_resmax(String ius_vo_resmax) {
		this.ius_vo_resmax = ius_vo_resmax;
	}

	public String getEfl_qt_dbobruto() {
		return efl_qt_dbobruto;
	}

	public void setEfl_qt_dbobruto(String efl_qt_dbobruto) {
		this.efl_qt_dbobruto = efl_qt_dbobruto;
	}

	public String getEfl_qt_dbotratado() {
		return efl_qt_dbotratado;
	}

	public void setEfl_qt_dbotratado(String efl_qt_dbotratado) {
		this.efl_qt_dbotratado = efl_qt_dbotratado;
	}

	public String getEfl_qt_fosforobruto() {
		return efl_qt_fosforobruto;
	}

	public void setEfl_qt_fosforobruto(String efl_qt_fosforobruto) {
		this.efl_qt_fosforobruto = efl_qt_fosforobruto;
	}

	public String getEfl_qt_fosforotratado() {
		return efl_qt_fosforotratado;
	}

	public void setEfl_qt_fosforotratado(String efl_qt_fosforotratado) {
		this.efl_qt_fosforotratado = efl_qt_fosforotratado;
	}

	public String getEfl_qt_nitrogeniobruto() {
		return efl_qt_nitrogeniobruto;
	}

	public void setEfl_qt_nitrogeniobruto(String efl_qt_nitrogeniobruto) {
		this.efl_qt_nitrogeniobruto = efl_qt_nitrogeniobruto;
	}

	public String getEfl_qt_nitrogeniotratado() {
		return efl_qt_nitrogeniotratado;
	}

	public void setEfl_qt_nitrogeniotratado(String efl_qt_nitrogeniotratado) {
		this.efl_qt_nitrogeniotratado = efl_qt_nitrogeniotratado;
	}

	public String getAsb_dt_instalacao() {
		return asb_dt_instalacao;
	}

	public void setAsb_dt_instalacao(String asb_dt_instalacao) {
		this.asb_dt_instalacao = asb_dt_instalacao;
	}

	public String getAsb_tpn_cd() {
		return asb_tpn_cd;
	}

	public void setAsb_tpn_cd(String asb_tpn_cd) {
		this.asb_tpn_cd = asb_tpn_cd;
	}

	public String getAsb_nu_diametroperfuracao() {
		return asb_nu_diametroperfuracao;
	}

	public void setAsb_nu_diametroperfuracao(String asb_nu_diametroperfuracao) {
		this.asb_nu_diametroperfuracao = asb_nu_diametroperfuracao;
	}

	public String getAsb_nu_diametrofiltro() {
		return asb_nu_diametrofiltro;
	}

	public void setAsb_nu_diametrofiltro(String asb_nu_diametrofiltro) {
		this.asb_nu_diametrofiltro = asb_nu_diametrofiltro;
	}

	public String getAsb_aqp_cd() {
		return asb_aqp_cd;
	}

	public void setAsb_aqp_cd(String asb_aqp_cd) {
		this.asb_aqp_cd = asb_aqp_cd;
	}

	public String getAsb_nu_topo() {
		return asb_nu_topo;
	}

	public void setAsb_nu_topo(String asb_nu_topo) {
		this.asb_nu_topo = asb_nu_topo;
	}

	public String getAsb_nu_base() {
		return asb_nu_base;
	}

	public void setAsb_nu_base(String asb_nu_base) {
		this.asb_nu_base = asb_nu_base;
	}

	public String getAsb_tnp_cd() {
		return asb_tnp_cd;
	}

	public void setAsb_tnp_cd(String asb_tnp_cd) {
		this.asb_tnp_cd = asb_tnp_cd;
	}

	public String getAsb_tca_cd() {
		return asb_tca_cd;
	}

	public void setAsb_tca_cd(String asb_tca_cd) {
		this.asb_tca_cd = asb_tca_cd;
	}

	public String getAsb_nu_profundidadefinal() {
		return asb_nu_profundidadefinal;
	}

	public void setAsb_nu_profundidadefinal(String asb_nu_profundidadefinal) {
		this.asb_nu_profundidadefinal = asb_nu_profundidadefinal;
	}

	public String getAsb_nu_alturabocatubo() {
		return asb_nu_alturabocatubo;
	}

	public void setAsb_nu_alturabocatubo(String asb_nu_alturabocatubo) {
		this.asb_nu_alturabocatubo = asb_nu_alturabocatubo;
	}

	public String getAsb_nu_cotaterreno() {
		return asb_nu_cotaterreno;
	}

	public void setAsb_nu_cotaterreno(String asb_nu_cotaterreno) {
		this.asb_nu_cotaterreno = asb_nu_cotaterreno;
	}

	public String getTst_dt() {
		return tst_dt;
	}

	public void setTst_dt(String tst_dt) {
		this.tst_dt = tst_dt;
	}

	public String getTst_ttb_cd() {
		return tst_ttb_cd;
	}

	public void setTst_ttb_cd(String tst_ttb_cd) {
		this.tst_ttb_cd = tst_ttb_cd;
	}

	public String getTst_ds_tempoduracao() {
		return tst_ds_tempoduracao;
	}

	public void setTst_ds_tempoduracao(String tst_ds_tempoduracao) {
		this.tst_ds_tempoduracao = tst_ds_tempoduracao;
	}

	public String getTst_nu_nd() {
		return tst_nu_nd;
	}

	public void setTst_nu_nd(String tst_nu_nd) {
		this.tst_nu_nd = tst_nu_nd;
	}

	public String getTst_nu_ne() {
		return tst_nu_ne;
	}

	public void setTst_nu_ne(String tst_nu_ne) {
		this.tst_nu_ne = tst_nu_ne;
	}

	public String getTst_vz_estabilizacao() {
		return tst_vz_estabilizacao;
	}

	public void setTst_vz_estabilizacao(String tst_vz_estabilizacao) {
		this.tst_vz_estabilizacao = tst_vz_estabilizacao;
	}

	public String getTst_tmi_cd() {
		return tst_tmi_cd;
	}

	public void setTst_tmi_cd(String tst_tmi_cd) {
		this.tst_tmi_cd = tst_tmi_cd;
	}

	public String getTst_nu_coeficientearmazenamento() {
		return tst_nu_coeficientearmazenamento;
	}

	public void setTst_nu_coeficientearmazenamento(String tst_nu_coeficientearmazenamento) {
		this.tst_nu_coeficientearmazenamento = tst_nu_coeficientearmazenamento;
	}

	public String getTst_nu_transmissividade() {
		return tst_nu_transmissividade;
	}

	public void setTst_nu_transmissividade(String tst_nu_transmissividade) {
		this.tst_nu_transmissividade = tst_nu_transmissividade;
	}

	public String getTst_nu_condutividadehidraulica() {
		return tst_nu_condutividadehidraulica;
	}

	public void setTst_nu_condutividadehidraulica(String tst_nu_condutividadehidraulica) {
		this.tst_nu_condutividadehidraulica = tst_nu_condutividadehidraulica;
	}

	public String getTst_nu_permeabilidade() {
		return tst_nu_permeabilidade;
	}

	public void setTst_nu_permeabilidade(String tst_nu_permeabilidade) {
		this.tst_nu_permeabilidade = tst_nu_permeabilidade;
	}

	public String getAma_dt_coleta() {
		return ama_dt_coleta;
	}

	public void setAma_dt_coleta(String ama_dt_coleta) {
		this.ama_dt_coleta = ama_dt_coleta;
	}

	public String getAma_dt_analise() {
		return ama_dt_analise;
	}

	public void setAma_dt_analise(String ama_dt_analise) {
		this.ama_dt_analise = ama_dt_analise;
	}

	public String getAma_nu_condutividadeeletrica() {
		return ama_nu_condutividadeeletrica;
	}

	public void setAma_nu_condutividadeeletrica(String ama_nu_condutividadeeletrica) {
		this.ama_nu_condutividadeeletrica = ama_nu_condutividadeeletrica;
	}

	public String getAma_qt_temperatura() {
		return ama_qt_temperatura;
	}

	public void setAma_qt_temperatura(String ama_qt_temperatura) {
		this.ama_qt_temperatura = ama_qt_temperatura;
	}

	public String getAma_qt_std() {
		return ama_qt_std;
	}

	public void setAma_qt_std(String ama_qt_std) {
		this.ama_qt_std = ama_qt_std;
	}

	public String getAma_qt_ph() {
		return ama_qt_ph;
	}

	public void setAma_qt_ph(String ama_qt_ph) {
		this.ama_qt_ph = ama_qt_ph;
	}

	public String getAma_qt_coliformestotais() {
		return ama_qt_coliformestotais;
	}

	public void setAma_qt_coliformestotais(String ama_qt_coliformestotais) {
		this.ama_qt_coliformestotais = ama_qt_coliformestotais;
	}

	public String getAma_qt_coliformesfecais() {
		return ama_qt_coliformesfecais;
	}

	public void setAma_qt_coliformesfecais(String ama_qt_coliformesfecais) {
		this.ama_qt_coliformesfecais = ama_qt_coliformesfecais;
	}

	public String getAma_qt_bicarbonato() {
		return ama_qt_bicarbonato;
	}

	public void setAma_qt_bicarbonato(String ama_qt_bicarbonato) {
		this.ama_qt_bicarbonato = ama_qt_bicarbonato;
	}

	public String getAma_qt_calcio() {
		return ama_qt_calcio;
	}

	public void setAma_qt_calcio(String ama_qt_calcio) {
		this.ama_qt_calcio = ama_qt_calcio;
	}

	public String getAma_qt_carbonato() {
		return ama_qt_carbonato;
	}

	public void setAma_qt_carbonato(String ama_qt_carbonato) {
		this.ama_qt_carbonato = ama_qt_carbonato;
	}

	public String getAma_qt_cloreto() {
		return ama_qt_cloreto;
	}

	public void setAma_qt_cloreto(String ama_qt_cloreto) {
		this.ama_qt_cloreto = ama_qt_cloreto;
	}

	public String getAma_qt_durezatotal() {
		return ama_qt_durezatotal;
	}

	public void setAma_qt_durezatotal(String ama_qt_durezatotal) {
		this.ama_qt_durezatotal = ama_qt_durezatotal;
	}

	public String getAma_qt_ferrototal() {
		return ama_qt_ferrototal;
	}

	public void setAma_qt_ferrototal(String ama_qt_ferrototal) {
		this.ama_qt_ferrototal = ama_qt_ferrototal;
	}

	public String getAma_qt_fluoretos() {
		return ama_qt_fluoretos;
	}

	public void setAma_qt_fluoretos(String ama_qt_fluoretos) {
		this.ama_qt_fluoretos = ama_qt_fluoretos;
	}

	public String getAma_qt_nitratos() {
		return ama_qt_nitratos;
	}

	public void setAma_qt_nitratos(String ama_qt_nitratos) {
		this.ama_qt_nitratos = ama_qt_nitratos;
	}

	public String getAma_qt_nitritos() {
		return ama_qt_nitritos;
	}

	public void setAma_qt_nitritos(String ama_qt_nitritos) {
		this.ama_qt_nitritos = ama_qt_nitritos;
	}

	public String getAma_qt_potassio() {
		return ama_qt_potassio;
	}

	public void setAma_qt_potassio(String ama_qt_potassio) {
		this.ama_qt_potassio = ama_qt_potassio;
	}

	public String getAma_qt_sodio() {
		return ama_qt_sodio;
	}

	public void setAma_qt_sodio(String ama_qt_sodio) {
		this.ama_qt_sodio = ama_qt_sodio;
	}

	public String getAma_qt_sulfato() {
		return ama_qt_sulfato;
	}

	public void setAma_qt_sulfato(String ama_qt_sulfato) {
		this.ama_qt_sulfato = ama_qt_sulfato;
	}

	@Override
	public String toString() {
		return int_tin_cd + ";" +
				int_tsu_cd + ";" +
				int_tsi_cd + ";" +
				int_cr_latitude + ";" +
				int_cr_longitude + ";" +
				ing_nu_ibgemunicipio + ";" +
				emp_nm_empreendimento + ";" +
				emp_nu_cpfcnpj + ";" +
				emp_nm_usuario + ";" +
				emp_ds_emailresponsavel + ";" +
				emp_nu_cependereco + ";" +
				emp_ds_logradouro + ";" +
				emp_ds_complementoendereco + ";" +
				emp_nu_logradouro + ";" +
				emp_nu_caixapostal + ";" +
				emp_cd_codigoibgecorrespondencia + ";" +
				emp_nu_ddd + ";" +
				emp_nu_telefone + ";" +
				out_tpo_cd + ";" +
				out_tsp_cd + ";" +
				out_dt_inicial + ";" +
				out_dt_final + ";" +
				out_nu_processo + ";" +
				out_ds_ato + ";" +
				out_nu_ato + ";" +
				int_nu_siagas + ";" +
				ope_vz_mesjan + ";" +
				ope_vz_mesfev + ";" +
				ope_vz_mesmar + ";" +
				ope_vz_mesabr + ";" +
				ope_vz_mesmai + ";" +
				ope_vz_mesjun + ";" +
				ope_vz_mesjul + ";" +
				ope_vz_mesago + ";" +
				ope_vz_messet + ";" +
				ope_vz_mesout + ";" +
				ope_vz_mesnov + ";" +
				ope_vz_mesdez + ";" +
				ope_qt_horasjan + ";" +
				ope_qt_horasfev + ";" +
				ope_qt_horasmar + ";" +
				ope_qt_horasabr + ";" +
				ope_qt_horasmai + ";" +
				ope_qt_horasjun + ";" +
				ope_qt_horasjul + ";" +
				ope_qt_horasago + ";" +
				ope_qt_horasset + ";" +
				ope_qt_horasout + ";" +
				ope_qt_horasnov + ";" +
				ope_qt_horasdez + ";" +
				ope_qt_diajan + ";" +
				ope_qt_diafev + ";" +
				ope_qt_diamar + ";" +
				ope_qt_diaabr + ";" +
				ope_qt_diamai + ";" +
				ope_qt_diajun + ";" +
				ope_qt_diajul + ";" +
				ope_qt_diaago + ";" +
				ope_qt_diaset + ";" +
				ope_qt_diaout + ";" +
				ope_qt_dianov + ";" +
				ope_qt_diadez + ";" +
				int_vz_maxima + ";" +
				fou_tou_cd + ";" +
				sir_tsi_cd + ";" +
				sir_tct_cd + ";" +
				sir_ar_irrigada + ";" +
				ius_nu_alturares + ";" +
				ius_ar_resmax + ";" +
				ius_vo_resmax + ";" +
				efl_qt_dbobruto + ";" +
				efl_qt_dbotratado + ";" +
				efl_qt_fosforobruto + ";" +
				efl_qt_fosforotratado + ";" +
				efl_qt_nitrogeniobruto + ";" +
				efl_qt_nitrogeniotratado + ";" +
				asb_dt_instalacao + ";" +
				asb_tpn_cd + ";" +
				asb_nu_diametroperfuracao + ";" +
				asb_nu_diametrofiltro + ";" +
				asb_aqp_cd + ";" +
				asb_nu_topo + ";" +
				asb_nu_base + ";" +
				asb_tnp_cd + ";" +
				asb_tca_cd + ";" +
				asb_nu_profundidadefinal + ";" +
				asb_nu_alturabocatubo + ";" +
				asb_nu_cotaterreno + ";" +
				tst_dt + ";" +
				tst_ttb_cd + ";" +
				tst_ds_tempoduracao + ";" +
				tst_nu_nd + ";" +
				tst_nu_ne + ";" +
				tst_vz_estabilizacao + ";" +
				tst_tmi_cd + ";" +
				tst_nu_coeficientearmazenamento + ";" +
				tst_nu_transmissividade + ";" +
				tst_nu_condutividadehidraulica + ";" +
				tst_nu_permeabilidade + ";" +
				ama_dt_coleta + ";" +
				ama_dt_analise + ";" +
				ama_nu_condutividadeeletrica + ";" +
				ama_qt_temperatura + ";" +
				ama_qt_std + ";" +
				ama_qt_ph + ";" +
				ama_qt_coliformestotais + ";" +
				ama_qt_coliformesfecais + ";" +
				ama_qt_bicarbonato + ";" +
				ama_qt_calcio + ";" +
				ama_qt_carbonato + ";" +
				ama_qt_cloreto + ";" +
				ama_qt_durezatotal + ";" +
				ama_qt_ferrototal + ";" +
				ama_qt_fluoretos + ";" +
				ama_qt_nitratos + ";" +
				ama_qt_nitritos + ";" +
				ama_qt_potassio + ";" +
				ama_qt_sodio + ";" +
				ama_qt_sulfato + ";" +
				getAma_qt_magnesio() + ";";

	}

	public String getAma_qt_magnesio() {
		return ama_qt_magnesio;
	}

	public void setAma_qt_magnesio(String ama_qt_magnesio) {
		this.ama_qt_magnesio = ama_qt_magnesio;
	}


}
