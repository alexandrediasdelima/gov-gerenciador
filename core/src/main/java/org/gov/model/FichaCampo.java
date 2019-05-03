package org.gov.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;


@Entity
@Table(name= "vw_ficha_campo")
@Subselect("select * from vw_ficha_campo order by emp_nm_usuario")

public class FichaCampo implements Serializable {

	/**
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Column (name="ama_qt_calcio")
	private String ama_qt_calcio;
	
	@Column (name="ama_qt_cloreto")
	private String ama_qt_cloreto;

	@Column (name="ama_qt_carbonato")
	private String ama_qt_carbonato;

	@Column (name="ama_qt_durezatotal")
	private String ama_qt_durezatotal;

	@Column (name="ama_qt_fluoretos")
	private String ama_qt_fluoretos;

	@Column (name="ama_qt_ferrototal")
	private String ama_qt_ferrototal;

	@Column (name="ama_qt_bicarbonato")
	private String ama_qt_bicarbonato;

	@Column (name="ama_qt_potassio")
	private String ama_qt_potassio;

	@Column (name="ama_qt_magnesio")
	private String ama_qt_magnesio;

	@Column (name="ama_qt_sodio")
	private String ama_qt_sodio;

	@Column (name="ama_qt_nitritos")
	private String ama_qt_nitritos;

	@Column (name="ama_qt_nitratos")
	private String ama_qt_nitratos;

	@Column (name="ama_qt_sulfato")
	private String ama_qt_sulfato;

	@Column (name="ama_nu_condutividadeeletrica")
	private String ama_nu_condutividadeeletrica;

	@Column (name="ama_dt_analise")
	private String ama_dt_analise;

	@Column (name="ama_dt_coleta")
	private String ama_dt_coleta;

	@Column (name="ama_qt_coliformesfecais")
	private String ama_qt_coliformesfecais;

	@Column (name="ama_qt_coliformestotais")
	private String ama_qt_coliformestotais;

	@Column (name="ama_qt_ph")
	private String ama_qt_ph;

	@Column (name="ama_qt_std")
	private String ama_qt_std;

	@Column (name="ama_qt_temperatura")
	private String ama_qt_temperatura;

	@Column (name="asb_int_pfk")
	private String asb_int_pfk;

	@Column (name="asb_nu_cotaterreno")
	private String asb_nu_cotaterreno;

	@Column (name="asb_nu_alturabocatubo")
	private String asb_nu_alturabocatubo;

	@Column (name="asb_aqp_cd")
	private String asb_aqp_cd;

	@Column (name="asb_dt_instalacao")
	private String asb_dt_instalacao;

	@Column (name="asb_nu_diametroperfuracao")
	private String asb_nu_diametroperfuracao;

	@Column (name="asb_nu_diametrofiltro")
	private String asb_nu_diametrofiltro;

	@Column (name="asb_nu_base")
	private String asb_nu_base;

	@Column (name="asb_nu_topo")
	private String asb_nu_topo;

	@Column (name="asb_tnp_cd")
	private String asb_tnp_cd;

	@Column (name="asb_tpn_cd")
	private String asb_tpn_cd;

	@Column (name="asb_tca_cd")
	private String asb_tca_cd;

	@Column (name="tst_ds_tempoduracao")
	private String tst_ds_tempoduracao;

	@Column (name="tst_dt")
	private String tst_dt;

	@Column (name="tst_nu_coeficientearmazenamento")
	private String tst_nu_coeficientearmazenamento;

	@Column (name="tst_nu_condutividadehidraulica")
	private String tst_nu_condutividadehidraulica;

	@Column (name="tst_nu_nd")
	private String tst_nu_nd;

	@Column (name="tst_nu_ne")
	private String tst_nu_ne;

	@Column (name="tst_nu_permeabilidade")
	private String tst_nu_permeabilidade;

	@Column (name="tst_nu_transmissividade")
	private String tst_nu_transmissividade;

	@Column (name="tst_tmi_cd")
	private String tst_tmi_cd;

	@Column (name="tst_ttb_cd")
	private String tst_ttb_cd;

	@Column (name="tst_vz_estabilizacao")
	private String tst_vz_estabilizacao;

	@Column (name="cap_int_pfk")
	private String cap_int_pfk;

	@Column (name="cam_info_adici_consumo")
	private String cam_info_adici_consumo;

	@Column (name="int_tsu_cd")
	private String int_tsu_cd;

	@Column (name="ch_int_pfk")
	private String ch_int_pfk;

	@Column (name="cam_pop_urb_estimada")
	private String cam_pop_urb_estimada;

	@Column (name="cam_pop_rural_estimada")
	private String cam_pop_rural_estimada;

	@Column (name="emp_id")
	private String emp_id;

	@Column (name="emp_nm_empreendimento")
	private String emp_nm_empreendimento;

	@Column (name="cam_ar_total")
	private String cam_ar_total;

	@Column (name="cam_ar_total_uni")
	private String cam_ar_total_uni;

	@Column (name="cam_end_propriedade")
	private String cam_end_propriedade;

	@Column (name="cam_tp_logradouro")
	private String cam_tp_logradouro;

	@Column (name="cam_nm_logradouro")
	private String cam_nm_logradouro;

	@Column (name="cam_nu_endereco")
	private String cam_nu_endereco;

	@Column (name="cam_complemento_end")
	private String cam_complemento_end;

	@Column (name="cam_acesso_principal_end")
	private String cam_acesso_principal_end;

	@Column (name="apa_local")
	private String apa_local;

	@Column (name="cam_caixapostal_end")
	private String cam_caixapostal_end;

	@Column (name="cam_cep_end")
	private String cam_cep_end;

	@Column (name="apa_muni_empreendimento")
	private String apa_muni_empreendimento;

	@Column (name="ing_nu_ibgemunicipio")
	private String ing_nu_ibgemunicipio;

	@Column (name="out_nu_processo_ana")
	private String out_nu_processo_ana;
	
	@Column (name="forn_id")
	private String forn_id;
	
	@Column (name="forn_info_nm")
	private String forn_info_nm;
	
	@Column (name="forn_info_cargo")
	private String forn_info_cargo;
	
	@Column (name="forn_info_departamento")
	private String forn_info_departamento;
	
	@Column (name="forn_info_contato_inst")
	private String forn_info_contato_inst;

	@Column (name="ind_int_pfk")
	private String ind_int_pfk;

	@Column (name="cam_indus_tp")
	private String cam_indus_tp;

	@Column (name="cam_indus_nu_empregados")
	private String cam_indus_nu_empregados;

	@Column (name="cam_indus_materia_prima")
	private String cam_indus_materia_prima;

	@Column (name="cam_qt_pdt_an")
	private String cam_qt_pdt_an;

	@Column (name="cam_qt_pdt_an_uni")
	private String cam_qt_pdt_an_uni;

	@Column (name="int_id")
	@Id
	private String int_id;

	@Column (name="apa_est_hidrologico")
	private String apa_est_hidrologico;

	@Column (name="fot_cap_lanc_geral")
	private String fot_cap_lanc_geral;

	@Column (name="int_cr_latitude")
	private String int_cr_latitude;

	@Column (name="int_cr_longitude")
	private String int_cr_longitude;

	@Column (name="fot_cap_lanc_detalhe")
	private String fot_cap_lanc_detalhe;

	@Column (name="fot_croqui_localizacao")
	private String fot_croqui_localizacao;

	@Column (name="apa_curso_barragem")
	private String apa_curso_barragem;

	@Column (name="apa_manancial")
	private String apa_manancial;

	@Column (name="apa_barragem")
	private String apa_barragem;

	@Column (name="apa_cap_maxacumula")
	private String apa_cap_maxacumula;

	@Column (name="apa_bacia")
	private String apa_bacia;

	@Column (name="cnarh_id")
	private String cnarh_id;

	@Column (name="out_nu_processo")
	private String out_nu_processo;

	@Column (name="fin_tfn_cd")
	private String fin_tfn_cd;

	@Column (name="fou_tou_cd")
	private String fou_tou_cd;

	@Column (name="int_tin_cd")
	private String int_tin_cd;

	@Column (name="fou_tou_tp_outro")
	private String fou_tou_tp_outro;

	@Column (name="int_tsi_cd")
	private String int_tsi_cd;

	@Column (name="irr_int_pfk")
	private String irr_int_pfk;

	@Column (name="sir_ar_irrigada")
	private String sir_ar_irrigada;

	@Column (name="sir_ar_irrigada_uni")
	private String sir_ar_irrigada_uni;

	@Column (name="sir_ar_irrigada_outra")
	private String sir_ar_irrigada_outra;

	@Column (name="sir_tsi_cd")
	private String sir_tsi_cd;

	@Column (name="sir_tct_cd")
	private String sir_tct_cd;

	@Column (name="sir_ar_irrigada_2")
	private String sir_ar_irrigada_2;

	@Column (name="sir_ar_irrigada_uni_2")
	private String sir_ar_irrigada_uni_2;

	@Column (name="sir_ar_irrigada_outra_2")
	private String sir_ar_irrigada_outra_2;

	@Column (name="sir_tsi_cd_2")
	private String sir_tsi_cd_2;

	@Column (name="sir_tct_cd_2")
	private String sir_tct_cd_2;

	@Column (name="sir_ar_irrigada_3")
	private String sir_ar_irrigada_3;

	@Column (name="sir_ar_irrigada_uni_3")
	private String sir_ar_irrigada_uni_3;

	@Column (name="sir_ar_irrigada_outra_3")
	private String sir_ar_irrigada_outra_3;

	@Column (name="sir_tsi_cd_3")
	private String sir_tsi_cd_3;

	@Column (name="sir_tct_cd_3")
	private String sir_tct_cd_3;

	@Column (name="lan_int_pfk")
	private String lan_int_pfk;

	@Column (name="cam_lanc_dbo5")
	private String cam_lanc_dbo5;

	@Column (name="cam_lanc_dbo20")
	private String cam_lanc_dbo20;

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

	@Column (name="oi_emp_pfk")
	private String oi_emp_pfk;

	@Column (name="cam_agua_servida_destino")
	private String cam_agua_servida_destino;

	@Column (name="cam_captacao_agua_subt")
	private String cam_captacao_agua_subt;

	@Column (name="cam_tp_poco")
	private String cam_tp_poco;

	@Column (name="cam_profundidade_poco")
	private String cam_profundidade_poco;

	@Column (name="cam_nu_profundidadefinal")
	private String cam_nu_profundidadefinal;

	@Column (name="cam_utilizacao_poco")
	private String cam_utilizacao_poco;

	@Column (name="cam_realizacao_car")
	private String cam_realizacao_car;

	@Column (name="cam_captacoes_comple")
	private String cam_captacoes_comple;

	@Column (name="cam_capta_lanca_futuro")
	private String cam_capta_lanca_futuro;

	@Column (name="cam_captacao_agua_super")
	private String cam_captacao_agua_super;

	@Column (name="pec_int_pfk")
	private String pec_int_pfk;

	@Column (name="cam_qt_equideo")
	private String cam_qt_equideo;

	@Column (name="cam_qt_bovino")
	private String cam_qt_bovino;

	@Column (name="cam_qt_ovino")
	private String cam_qt_ovino;

	@Column (name="cam_qt_caprino")
	private String cam_qt_caprino;

	@Column (name="cam_qt_suino")
	private String cam_qt_suino;

	@Column (name="cam_qt_ave")
	private String cam_qt_ave;

	@Column (name="cam_pec_outro")
	private String cam_pec_outro;

	@Column (name="cam_qt_outro")
	private String cam_qt_outro;

	@Column (name="usuario_id")
	private String usuario_id;

	@Column (name="emp_nm_usuario")
	private String emp_nm_usuario;

	@Column (name="emp_nm_apelido")
	private String emp_nm_apelido;

	@Column (name="emp_nu_cpfcnpj")
	private String emp_nu_cpfcnpj;

	@Column (name="emp_nu_tipodocumento")
	private String emp_nu_tipodocumento;

	@Column (name="emp_nu_ddd")
	private String emp_nu_ddd;

	@Column (name="emp_nu_telefone")
	private String emp_nu_telefone;

	@Column (name="emp_ds_emailresponsavel")
	private String emp_ds_emailresponsavel;

	@Column (name="emp_ds_tp_logradouro")
	private String emp_ds_tp_logradouro;

	@Column (name="emp_ds_nm_logradouro")
	private String emp_ds_nm_logradouro;

	@Column (name="emp_ds_logradouro")
	private String emp_ds_logradouro;

	@Column (name="emp_nu_logradouro")
	private String emp_nu_logradouro;

	@Column (name="emp_ds_complementoendereco")
	private String emp_ds_complementoendereco;

	@Column (name="emp_ds_bairrodistrito")
	private String emp_ds_bairrodistrito;

	@Column (name="emp_nu_caixapostal")
	private String emp_nu_caixapostal;

	@Column (name="emp_nu_cependereco")
	private String emp_nu_cependereco;

	@Column (name="apa_muni_correspondencia")
	private String apa_muni_correspondencia;

	@Column (name="emp_cd_codigoibgecorrespondencia")
	private String emp_cd_codigoibgecorrespondencia;

	@Column (name="emp_ds_uf")
	private String emp_ds_uf;

	@Column (name="emp_ds_relacaopropriedade")
	private String emp_ds_relacaopropriedade;

	@Column (name="vz_int_pfk")
	private String vz_int_pfk;

	@Column (name="int_vz_maxima")
	private String int_vz_maxima;

	@Column (name="cam_vz_afe")
	private String cam_vz_afe;

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

	@Column (name="ope_vz_mesjul")
	private String ope_vz_mesjul;

	@Column (name="ope_vz_mesjun")
	private String ope_vz_mesjun;

	@Column (name="ope_vz_mesago")
	private String ope_vz_mesago;

	@Column (name="ope_vz_mesout")
	private String ope_vz_mesout;

	@Column (name="ope_vz_messet")
	private String ope_vz_messet;

	@Column (name="ope_vz_mesnov")
	private String ope_vz_mesnov;

	@Column (name="ope_vz_mesdez")
	private String ope_vz_mesdez;

	@Column (name="apa_analista")
	private String apa_analista;

	@Column (name="out_ds_ato")
	private String out_ds_ato;

	@Column (name="apa_dt_vistoria")
	private String apa_dt_vistoria;

	@Column (name="apa_dt_contrato_concessao")
	private String apa_dt_contrato_concessao;

	@Column (name="apa_entr_apac")
	private String apa_entr_apac;

	@Column (name="apa_entr_cprh")
	private String apa_entr_cprh;

	@Column (name="out_dt_inicial")
	private String out_dt_inicial;

	@Column (name="out_dt_final")
	private String out_dt_final;

	@Column (name="apa_garantia")
	private String apa_garantia;

	@Column (name="apa_nm_obra")
	private String apa_nm_obra;

	@Column (name="out_nu_ato")
	private String out_nu_ato;

	@Column (name="apa_nu_notificacao")
	private String apa_nu_notificacao;

	@Column (name="apa_nu_notificacao_isencao")
	private String apa_nu_notificacao_isencao;

	@Column (name="apa_vz_requerida_horas_dia")
	private String apa_vz_requerida_horas_dia;

	@Column (name="apa_nu_termo")
	private String apa_nu_termo;

	@Column (name="apa_outorga_abr")
	private String apa_outorga_abr;

	@Column (name="apa_outorga_ago")
	private String apa_outorga_ago;

	@Column (name="apa_outorga_dez")
	private String apa_outorga_dez;

	@Column (name="apa_outorga_fev")
	private String apa_outorga_fev;

	@Column (name="apa_outorga_jan")
	private String apa_outorga_jan;

	@Column (name="apa_outorga_jul")
	private String apa_outorga_jul;

	@Column (name="apa_outorga_jun")
	private String apa_outorga_jun;

	@Column (name="apa_outorga_mai")
	private String apa_outorga_mai;

	@Column (name="apa_outorga_mar")
	private String apa_outorga_mar;

	@Column (name="apa_outorga_nov")
	private String apa_outorga_nov;

	@Column (name="apa_outorga_out")
	private String apa_outorga_out;

	@Column (name="apa_outorga_set")
	private String apa_outorga_set;

	@Column (name="apa_prazo_notificacao")
	private String apa_prazo_notificacao;

	@Column (name="apa_prot_cprh")
	private String apa_prot_cprh;

	@Column (name="apa_obra_tp")
	private String apa_obra_tp;

	@Column (name="apa_vz_outorga_ls")
	private String apa_vz_outorga_ls;

	@Column (name="apa_vz_requerida_ls")
	private String apa_vz_requerida_ls;

	@Column (name="out_tsp_cd")
	private String out_tsp_cd;

	@Column (name="out_tpo_cd")
	private String out_tpo_cd;

	@Column (name="apa_vz_outorga_m3dia")
	private String apa_vz_outorga_m3dia;

	@Column (name="apa_vz_requerida_m3dia")
	private String apa_vz_requerida_m3dia;

	@Column (name="ius_nu_alturares")
	private String ius_nu_alturares;

	@Column (name="ius_ar_resmax")
	private String ius_ar_resmax;

	@Column (name="int_nu_siagas")
	private String int_nu_siagas;

	@Column (name="ius_vo_resmax")
	private String ius_vo_resmax;

	public String getAma_qt_calcio() {
		return ama_qt_calcio;
	}

	public void setAma_qt_calcio(String ama_qt_calcio) {
		this.ama_qt_calcio = ama_qt_calcio;
	}

	public String getAma_qt_cloreto() {
		return ama_qt_cloreto;
	}

	public void setAma_qt_cloreto(String ama_qt_cloreto) {
		this.ama_qt_cloreto = ama_qt_cloreto;
	}

	public String getAma_qt_carbonato() {
		return ama_qt_carbonato;
	}

	public void setAma_qt_carbonato(String ama_qt_carbonato) {
		this.ama_qt_carbonato = ama_qt_carbonato;
	}

	public String getAma_qt_durezatotal() {
		return ama_qt_durezatotal;
	}

	public void setAma_qt_durezatotal(String ama_qt_durezatotal) {
		this.ama_qt_durezatotal = ama_qt_durezatotal;
	}

	public String getAma_qt_fluoretos() {
		return ama_qt_fluoretos;
	}

	public void setAma_qt_fluoretos(String ama_qt_fluoretos) {
		this.ama_qt_fluoretos = ama_qt_fluoretos;
	}

	public String getAma_qt_ferrototal() {
		return ama_qt_ferrototal;
	}

	public void setAma_qt_ferrototal(String ama_qt_ferrototal) {
		this.ama_qt_ferrototal = ama_qt_ferrototal;
	}

	public String getAma_qt_bicarbonato() {
		return ama_qt_bicarbonato;
	}

	public void setAma_qt_bicarbonato(String ama_qt_bicarbonato) {
		this.ama_qt_bicarbonato = ama_qt_bicarbonato;
	}

	public String getAma_qt_potassio() {
		return ama_qt_potassio;
	}

	public void setAma_qt_potassio(String ama_qt_potassio) {
		this.ama_qt_potassio = ama_qt_potassio;
	}

	public String getAma_qt_magnesio() {
		return ama_qt_magnesio;
	}

	public void setAma_qt_magnesio(String ama_qt_magnesio) {
		this.ama_qt_magnesio = ama_qt_magnesio;
	}

	public String getAma_qt_sodio() {
		return ama_qt_sodio;
	}

	public void setAma_qt_sodio(String ama_qt_sodio) {
		this.ama_qt_sodio = ama_qt_sodio;
	}

	public String getAma_qt_nitritos() {
		return ama_qt_nitritos;
	}

	public void setAma_qt_nitritos(String ama_qt_nitritos) {
		this.ama_qt_nitritos = ama_qt_nitritos;
	}

	public String getAma_qt_nitratos() {
		return ama_qt_nitratos;
	}

	public void setAma_qt_nitratos(String ama_qt_nitratos) {
		this.ama_qt_nitratos = ama_qt_nitratos;
	}

	public String getAma_qt_sulfato() {
		return ama_qt_sulfato;
	}

	public void setAma_qt_sulfato(String ama_qt_sulfato) {
		this.ama_qt_sulfato = ama_qt_sulfato;
	}

	public String getAma_nu_condutividadeeletrica() {
		return ama_nu_condutividadeeletrica;
	}

	public void setAma_nu_condutividadeeletrica(String ama_nu_condutividadeeletrica) {
		this.ama_nu_condutividadeeletrica = ama_nu_condutividadeeletrica;
	}

	public String getAma_dt_analise() {
		return ama_dt_analise;
	}

	public void setAma_dt_analise(String ama_dt_analise) {
		this.ama_dt_analise = ama_dt_analise;
	}

	public String getAma_dt_coleta() {
		return ama_dt_coleta;
	}

	public void setAma_dt_coleta(String ama_dt_coleta) {
		this.ama_dt_coleta = ama_dt_coleta;
	}

	public String getAma_qt_coliformesfecais() {
		return ama_qt_coliformesfecais;
	}

	public void setAma_qt_coliformesfecais(String ama_qt_coliformesfecais) {
		this.ama_qt_coliformesfecais = ama_qt_coliformesfecais;
	}

	public String getAma_qt_coliformestotais() {
		return ama_qt_coliformestotais;
	}

	public void setAma_qt_coliformestotais(String ama_qt_coliformestotais) {
		this.ama_qt_coliformestotais = ama_qt_coliformestotais;
	}

	public String getAma_qt_ph() {
		return ama_qt_ph;
	}

	public void setAma_qt_ph(String ama_qt_ph) {
		this.ama_qt_ph = ama_qt_ph;
	}

	public String getAma_qt_std() {
		return ama_qt_std;
	}

	public void setAma_qt_std(String ama_qt_std) {
		this.ama_qt_std = ama_qt_std;
	}

	public String getAma_qt_temperatura() {
		return ama_qt_temperatura;
	}

	public void setAma_qt_temperatura(String ama_qt_temperatura) {
		this.ama_qt_temperatura = ama_qt_temperatura;
	}

	public String getAsb_int_pfk() {
		return asb_int_pfk;
	}

	public void setAsb_int_pfk(String asb_int_pfk) {
		this.asb_int_pfk = asb_int_pfk;
	}

	public String getAsb_nu_cotaterreno() {
		return asb_nu_cotaterreno;
	}

	public void setAsb_nu_cotaterreno(String asb_nu_cotaterreno) {
		this.asb_nu_cotaterreno = asb_nu_cotaterreno;
	}

	public String getAsb_nu_alturabocatubo() {
		return asb_nu_alturabocatubo;
	}

	public void setAsb_nu_alturabocatubo(String asb_nu_alturabocatubo) {
		this.asb_nu_alturabocatubo = asb_nu_alturabocatubo;
	}

	public String getAsb_aqp_cd() {
		return asb_aqp_cd;
	}

	public void setAsb_aqp_cd(String asb_aqp_cd) {
		this.asb_aqp_cd = asb_aqp_cd;
	}

	public String getAsb_dt_instalacao() {
		return asb_dt_instalacao;
	}

	public void setAsb_dt_instalacao(String asb_dt_instalacao) {
		this.asb_dt_instalacao = asb_dt_instalacao;
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

	public String getAsb_nu_base() {
		return asb_nu_base;
	}

	public void setAsb_nu_base(String asb_nu_base) {
		this.asb_nu_base = asb_nu_base;
	}

	public String getAsb_nu_topo() {
		return asb_nu_topo;
	}

	public void setAsb_nu_topo(String asb_nu_topo) {
		this.asb_nu_topo = asb_nu_topo;
	}

	public String getAsb_tnp_cd() {
		return asb_tnp_cd;
	}

	public void setAsb_tnp_cd(String asb_tnp_cd) {
		this.asb_tnp_cd = asb_tnp_cd;
	}

	public String getAsb_tpn_cd() {
		return asb_tpn_cd;
	}

	public void setAsb_tpn_cd(String asb_tpn_cd) {
		this.asb_tpn_cd = asb_tpn_cd;
	}

	public String getAsb_tca_cd() {
		return asb_tca_cd;
	}

	public void setAsb_tca_cd(String asb_tca_cd) {
		this.asb_tca_cd = asb_tca_cd;
	}

	public String getTst_ds_tempoduracao() {
		return tst_ds_tempoduracao;
	}

	public void setTst_ds_tempoduracao(String tst_ds_tempoduracao) {
		this.tst_ds_tempoduracao = tst_ds_tempoduracao;
	}

	public String getTst_dt() {
		return tst_dt;
	}

	public void setTst_dt(String tst_dt) {
		this.tst_dt = tst_dt;
	}

	public String getTst_nu_coeficientearmazenamento() {
		return tst_nu_coeficientearmazenamento;
	}

	public void setTst_nu_coeficientearmazenamento(String tst_nu_coeficientearmazenamento) {
		this.tst_nu_coeficientearmazenamento = tst_nu_coeficientearmazenamento;
	}

	public String getTst_nu_condutividadehidraulica() {
		return tst_nu_condutividadehidraulica;
	}

	public void setTst_nu_condutividadehidraulica(String tst_nu_condutividadehidraulica) {
		this.tst_nu_condutividadehidraulica = tst_nu_condutividadehidraulica;
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

	public String getTst_nu_permeabilidade() {
		return tst_nu_permeabilidade;
	}

	public void setTst_nu_permeabilidade(String tst_nu_permeabilidade) {
		this.tst_nu_permeabilidade = tst_nu_permeabilidade;
	}

	public String getTst_nu_transmissividade() {
		return tst_nu_transmissividade;
	}

	public void setTst_nu_transmissividade(String tst_nu_transmissividade) {
		this.tst_nu_transmissividade = tst_nu_transmissividade;
	}

	public String getTst_tmi_cd() {
		return tst_tmi_cd;
	}

	public void setTst_tmi_cd(String tst_tmi_cd) {
		this.tst_tmi_cd = tst_tmi_cd;
	}

	public String getTst_ttb_cd() {
		return tst_ttb_cd;
	}

	public void setTst_ttb_cd(String tst_ttb_cd) {
		this.tst_ttb_cd = tst_ttb_cd;
	}

	public String getTst_vz_estabilizacao() {
		return tst_vz_estabilizacao;
	}

	public void setTst_vz_estabilizacao(String tst_vz_estabilizacao) {
		this.tst_vz_estabilizacao = tst_vz_estabilizacao;
	}

	public String getCap_int_pfk() {
		return cap_int_pfk;
	}

	public void setCap_int_pfk(String cap_int_pfk) {
		this.cap_int_pfk = cap_int_pfk;
	}

	public String getCam_info_adici_consumo() {
		return cam_info_adici_consumo;
	}

	public void setCam_info_adici_consumo(String cam_info_adici_consumo) {
		this.cam_info_adici_consumo = cam_info_adici_consumo;
	}

	public String getInt_tsu_cd() {
		return int_tsu_cd;
	}

	public void setInt_tsu_cd(String int_tsu_cd) {
		this.int_tsu_cd = int_tsu_cd;
	}

	public String getCh_int_pfk() {
		return ch_int_pfk;
	}

	public void setCh_int_pfk(String ch_int_pfk) {
		this.ch_int_pfk = ch_int_pfk;
	}

	public String getCam_pop_urb_estimada() {
		return cam_pop_urb_estimada;
	}

	public void setCam_pop_urb_estimada(String cam_pop_urb_estimada) {
		this.cam_pop_urb_estimada = cam_pop_urb_estimada;
	}

	public String getCam_pop_rural_estimada() {
		return cam_pop_rural_estimada;
	}

	public void setCam_pop_rural_estimada(String cam_pop_rural_estimada) {
		this.cam_pop_rural_estimada = cam_pop_rural_estimada;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_nm_empreendimento() {
		return emp_nm_empreendimento;
	}

	public void setEmp_nm_empreendimento(String emp_nm_empreendimento) {
		this.emp_nm_empreendimento = emp_nm_empreendimento;
	}

	public String getCam_ar_total() {
		return cam_ar_total;
	}

	public void setCam_ar_total(String cam_ar_total) {
		this.cam_ar_total = cam_ar_total;
	}

	public String getCam_ar_total_uni() {
		return cam_ar_total_uni;
	}

	public void setCam_ar_total_uni(String cam_ar_total_uni) {
		this.cam_ar_total_uni = cam_ar_total_uni;
	}

	public String getCam_end_propriedade() {
		return cam_end_propriedade;
	}

	public void setCam_end_propriedade(String cam_end_propriedade) {
		this.cam_end_propriedade = cam_end_propriedade;
	}

	public String getCam_tp_logradouro() {
		return cam_tp_logradouro;
	}

	public void setCam_tp_logradouro(String cam_tp_logradouro) {
		this.cam_tp_logradouro = cam_tp_logradouro;
	}

	public String getCam_nm_logradouro() {
		return cam_nm_logradouro;
	}

	public void setCam_nm_logradouro(String cam_nm_logradouro) {
		this.cam_nm_logradouro = cam_nm_logradouro;
	}

	public String getCam_nu_endereco() {
		return cam_nu_endereco;
	}

	public void setCam_nu_endereco(String cam_nu_endereco) {
		this.cam_nu_endereco = cam_nu_endereco;
	}

	public String getCam_complemento_end() {
		return cam_complemento_end;
	}

	public void setCam_complemento_end(String cam_complemento_end) {
		this.cam_complemento_end = cam_complemento_end;
	}

	public String getCam_acesso_principal_end() {
		return cam_acesso_principal_end;
	}

	public void setCam_acesso_principal_end(String cam_acesso_principal_end) {
		this.cam_acesso_principal_end = cam_acesso_principal_end;
	}

	public String getApa_local() {
		return apa_local;
	}

	public void setApa_local(String apa_local) {
		this.apa_local = apa_local;
	}

	public String getCam_caixapostal_end() {
		return cam_caixapostal_end;
	}

	public void setCam_caixapostal_end(String cam_caixapostal_end) {
		this.cam_caixapostal_end = cam_caixapostal_end;
	}

	public String getCam_cep_end() {
		return cam_cep_end;
	}

	public void setCam_cep_end(String cam_cep_end) {
		this.cam_cep_end = cam_cep_end;
	}

	public String getApa_muni_empreendimento() {
		return apa_muni_empreendimento;
	}

	public void setApa_muni_empreendimento(String apa_muni_empreendimento) {
		this.apa_muni_empreendimento = apa_muni_empreendimento;
	}

	public String getIng_nu_ibgemunicipio() {
		return ing_nu_ibgemunicipio;
	}

	public void setIng_nu_ibgemunicipio(String ing_nu_ibgemunicipio) {
		this.ing_nu_ibgemunicipio = ing_nu_ibgemunicipio;
	}

	public String getOut_nu_processo_ana() {
		return out_nu_processo_ana;
	}

	public void setOut_nu_processo_ana(String out_nu_processo_ana) {
		this.out_nu_processo_ana = out_nu_processo_ana;
	}

	public String getInd_int_pfk() {
		return ind_int_pfk;
	}

	public void setInd_int_pfk(String ind_int_pfk) {
		this.ind_int_pfk = ind_int_pfk;
	}

	public String getCam_indus_tp() {
		return cam_indus_tp;
	}

	public void setCam_indus_tp(String cam_indus_tp) {
		this.cam_indus_tp = cam_indus_tp;
	}

	public String getCam_indus_nu_empregados() {
		return cam_indus_nu_empregados;
	}

	public void setCam_indus_nu_empregados(String cam_indus_nu_empregados) {
		this.cam_indus_nu_empregados = cam_indus_nu_empregados;
	}

	public String getCam_indus_materia_prima() {
		return cam_indus_materia_prima;
	}

	public void setCam_indus_materia_prima(String cam_indus_materia_prima) {
		this.cam_indus_materia_prima = cam_indus_materia_prima;
	}

	public String getCam_qt_pdt_an() {
		return cam_qt_pdt_an;
	}

	public void setCam_qt_pdt_an(String cam_qt_pdt_an) {
		this.cam_qt_pdt_an = cam_qt_pdt_an;
	}

	public String getCam_qt_pdt_an_uni() {
		return cam_qt_pdt_an_uni;
	}

	public void setCam_qt_pdt_an_uni(String cam_qt_pdt_an_uni) {
		this.cam_qt_pdt_an_uni = cam_qt_pdt_an_uni;
	}

	public String getInt_id() {
		return int_id;
	}

	public void setInt_id(String int_id) {
		this.int_id = int_id;
	}

	public String getApa_est_hidrologico() {
		return apa_est_hidrologico;
	}

	public void setApa_est_hidrologico(String apa_est_hidrologico) {
		this.apa_est_hidrologico = apa_est_hidrologico;
	}

	public String getFot_cap_lanc_geral() {
		return fot_cap_lanc_geral;
	}

	public void setFot_cap_lanc_geral(String fot_cap_lanc_geral) {
		this.fot_cap_lanc_geral = fot_cap_lanc_geral;
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

	public String getApa_cap_maxacumula() {
		return apa_cap_maxacumula;
	}

	public void setApa_cap_maxacumula(String apa_cap_maxacumula) {
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

	public String getIrr_int_pfk() {
		return irr_int_pfk;
	}

	public void setIrr_int_pfk(String irr_int_pfk) {
		this.irr_int_pfk = irr_int_pfk;
	}

	public String getSir_ar_irrigada() {
		return sir_ar_irrigada;
	}

	public void setSir_ar_irrigada(String sir_ar_irrigada) {
		this.sir_ar_irrigada = sir_ar_irrigada;
	}

	public String getSir_ar_irrigada_uni() {
		return sir_ar_irrigada_uni;
	}

	public void setSir_ar_irrigada_uni(String sir_ar_irrigada_uni) {
		this.sir_ar_irrigada_uni = sir_ar_irrigada_uni;
	}

	public String getSir_ar_irrigada_outra() {
		return sir_ar_irrigada_outra;
	}

	public void setSir_ar_irrigada_outra(String sir_ar_irrigada_outra) {
		this.sir_ar_irrigada_outra = sir_ar_irrigada_outra;
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

	public String getSir_ar_irrigada_2() {
		return sir_ar_irrigada_2;
	}

	public void setSir_ar_irrigada_2(String sir_ar_irrigada_2) {
		this.sir_ar_irrigada_2 = sir_ar_irrigada_2;
	}

	public String getSir_ar_irrigada_uni_2() {
		return sir_ar_irrigada_uni_2;
	}

	public void setSir_ar_irrigada_uni_2(String sir_ar_irrigada_uni_2) {
		this.sir_ar_irrigada_uni_2 = sir_ar_irrigada_uni_2;
	}

	public String getSir_ar_irrigada_outra_2() {
		return sir_ar_irrigada_outra_2;
	}

	public void setSir_ar_irrigada_outra_2(String sir_ar_irrigada_outra_2) {
		this.sir_ar_irrigada_outra_2 = sir_ar_irrigada_outra_2;
	}

	public String getSir_tsi_cd_2() {
		return sir_tsi_cd_2;
	}

	public void setSir_tsi_cd_2(String sir_tsi_cd_2) {
		this.sir_tsi_cd_2 = sir_tsi_cd_2;
	}

	public String getSir_tct_cd_2() {
		return sir_tct_cd_2;
	}

	public void setSir_tct_cd_2(String sir_tct_cd_2) {
		this.sir_tct_cd_2 = sir_tct_cd_2;
	}

	public String getSir_ar_irrigada_3() {
		return sir_ar_irrigada_3;
	}

	public void setSir_ar_irrigada_3(String sir_ar_irrigada_3) {
		this.sir_ar_irrigada_3 = sir_ar_irrigada_3;
	}

	public String getSir_ar_irrigada_uni_3() {
		return sir_ar_irrigada_uni_3;
	}

	public void setSir_ar_irrigada_uni_3(String sir_ar_irrigada_uni_3) {
		this.sir_ar_irrigada_uni_3 = sir_ar_irrigada_uni_3;
	}

	public String getSir_ar_irrigada_outra_3() {
		return sir_ar_irrigada_outra_3;
	}

	public void setSir_ar_irrigada_outra_3(String sir_ar_irrigada_outra_3) {
		this.sir_ar_irrigada_outra_3 = sir_ar_irrigada_outra_3;
	}

	public String getSir_tsi_cd_3() {
		return sir_tsi_cd_3;
	}

	public void setSir_tsi_cd_3(String sir_tsi_cd_3) {
		this.sir_tsi_cd_3 = sir_tsi_cd_3;
	}

	public String getSir_tct_cd_3() {
		return sir_tct_cd_3;
	}

	public void setSir_tct_cd_3(String sir_tct_cd_3) {
		this.sir_tct_cd_3 = sir_tct_cd_3;
	}

	public String getLan_int_pfk() {
		return lan_int_pfk;
	}

	public void setLan_int_pfk(String lan_int_pfk) {
		this.lan_int_pfk = lan_int_pfk;
	}

	public String getCam_lanc_dbo5() {
		return cam_lanc_dbo5;
	}

	public void setCam_lanc_dbo5(String cam_lanc_dbo5) {
		this.cam_lanc_dbo5 = cam_lanc_dbo5;
	}

	public String getCam_lanc_dbo20() {
		return cam_lanc_dbo20;
	}

	public void setCam_lanc_dbo20(String cam_lanc_dbo20) {
		this.cam_lanc_dbo20 = cam_lanc_dbo20;
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

	public String getOi_emp_pfk() {
		return oi_emp_pfk;
	}

	public void setOi_emp_pfk(String oi_emp_pfk) {
		this.oi_emp_pfk = oi_emp_pfk;
	}

	public String getCam_agua_servida_destino() {
		return cam_agua_servida_destino;
	}

	public void setCam_agua_servida_destino(String cam_agua_servida_destino) {
		this.cam_agua_servida_destino = cam_agua_servida_destino;
	}

	public String getCam_captacao_agua_subt() {
		return cam_captacao_agua_subt;
	}

	public void setCam_captacao_agua_subt(String cam_captacao_agua_subt) {
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

	public String getCam_nu_profundidadefinal() {
		return cam_nu_profundidadefinal;
	}

	public void setCam_nu_profundidadefinal(String cam_nu_profundidadefinal) {
		this.cam_nu_profundidadefinal = cam_nu_profundidadefinal;
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

	public String getCam_captacao_agua_super() {
		return cam_captacao_agua_super;
	}

	public void setCam_captacao_agua_super(String cam_captacao_agua_super) {
		this.cam_captacao_agua_super = cam_captacao_agua_super;
	}

	public String getPec_int_pfk() {
		return pec_int_pfk;
	}

	public void setPec_int_pfk(String pec_int_pfk) {
		this.pec_int_pfk = pec_int_pfk;
	}

	public String getCam_qt_equideo() {
		return cam_qt_equideo;
	}

	public void setCam_qt_equideo(String cam_qt_equideo) {
		this.cam_qt_equideo = cam_qt_equideo;
	}

	public String getCam_qt_bovino() {
		return cam_qt_bovino;
	}

	public void setCam_qt_bovino(String cam_qt_bovino) {
		this.cam_qt_bovino = cam_qt_bovino;
	}

	public String getCam_qt_ovino() {
		return cam_qt_ovino;
	}

	public void setCam_qt_ovino(String cam_qt_ovino) {
		this.cam_qt_ovino = cam_qt_ovino;
	}

	public String getCam_qt_caprino() {
		return cam_qt_caprino;
	}

	public void setCam_qt_caprino(String cam_qt_caprino) {
		this.cam_qt_caprino = cam_qt_caprino;
	}

	public String getCam_qt_suino() {
		return cam_qt_suino;
	}

	public void setCam_qt_suino(String cam_qt_suino) {
		this.cam_qt_suino = cam_qt_suino;
	}

	public String getCam_qt_ave() {
		return cam_qt_ave;
	}

	public void setCam_qt_ave(String cam_qt_ave) {
		this.cam_qt_ave = cam_qt_ave;
	}

	public String getCam_pec_outro() {
		return cam_pec_outro;
	}

	public void setCam_pec_outro(String cam_pec_outro) {
		this.cam_pec_outro = cam_pec_outro;
	}

	public String getCam_qt_outro() {
		return cam_qt_outro;
	}

	public void setCam_qt_outro(String cam_qt_outro) {
		this.cam_qt_outro = cam_qt_outro;
	}

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
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

	public String getEmp_nu_tipodocumento() {
		return emp_nu_tipodocumento;
	}

	public void setEmp_nu_tipodocumento(String emp_nu_tipodocumento) {
		this.emp_nu_tipodocumento = emp_nu_tipodocumento;
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

	public String getEmp_nu_logradouro() {
		return emp_nu_logradouro;
	}

	public void setEmp_nu_logradouro(String emp_nu_logradouro) {
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

	public String getEmp_nu_caixapostal() {
		return emp_nu_caixapostal;
	}

	public void setEmp_nu_caixapostal(String emp_nu_caixapostal) {
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

	public String getEmp_cd_codigoibgecorrespondencia() {
		return emp_cd_codigoibgecorrespondencia;
	}

	public void setEmp_cd_codigoibgecorrespondencia(String emp_cd_codigoibgecorrespondencia) {
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

	public String getVz_int_pfk() {
		return vz_int_pfk;
	}

	public void setVz_int_pfk(String vz_int_pfk) {
		this.vz_int_pfk = vz_int_pfk;
	}

	public String getInt_vz_maxima() {
		return int_vz_maxima;
	}

	public void setInt_vz_maxima(String int_vz_maxima) {
		this.int_vz_maxima = int_vz_maxima;
	}

	public String getCam_vz_afe() {
		return cam_vz_afe;
	}

	public void setCam_vz_afe(String cam_vz_afe) {
		this.cam_vz_afe = cam_vz_afe;
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

	public String getOpe_vz_mesjul() {
		return ope_vz_mesjul;
	}

	public void setOpe_vz_mesjul(String ope_vz_mesjul) {
		this.ope_vz_mesjul = ope_vz_mesjul;
	}

	public String getOpe_vz_mesjun() {
		return ope_vz_mesjun;
	}

	public void setOpe_vz_mesjun(String ope_vz_mesjun) {
		this.ope_vz_mesjun = ope_vz_mesjun;
	}

	public String getOpe_vz_mesago() {
		return ope_vz_mesago;
	}

	public void setOpe_vz_mesago(String ope_vz_mesago) {
		this.ope_vz_mesago = ope_vz_mesago;
	}

	public String getOpe_vz_mesout() {
		return ope_vz_mesout;
	}

	public void setOpe_vz_mesout(String ope_vz_mesout) {
		this.ope_vz_mesout = ope_vz_mesout;
	}

	public String getOpe_vz_messet() {
		return ope_vz_messet;
	}

	public void setOpe_vz_messet(String ope_vz_messet) {
		this.ope_vz_messet = ope_vz_messet;
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

	public String getApa_analista() {
		return apa_analista;
	}

	public void setApa_analista(String apa_analista) {
		this.apa_analista = apa_analista;
	}

	public String getOut_ds_ato() {
		return out_ds_ato;
	}

	public void setOut_ds_ato(String out_ds_ato) {
		this.out_ds_ato = out_ds_ato;
	}

	public String getApa_dt_vistoria() {
		return apa_dt_vistoria;
	}

	public void setApa_dt_vistoria(String apa_dt_vistoria) {
		this.apa_dt_vistoria = apa_dt_vistoria;
	}

	public String getApa_dt_contrato_concessao() {
		return apa_dt_contrato_concessao;
	}

	public void setApa_dt_contrato_concessao(String apa_dt_contrato_concessao) {
		this.apa_dt_contrato_concessao = apa_dt_contrato_concessao;
	}

	public String getApa_entr_apac() {
		return apa_entr_apac;
	}

	public void setApa_entr_apac(String apa_entr_apac) {
		this.apa_entr_apac = apa_entr_apac;
	}

	public String getApa_entr_cprh() {
		return apa_entr_cprh;
	}

	public void setApa_entr_cprh(String apa_entr_cprh) {
		this.apa_entr_cprh = apa_entr_cprh;
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

	public String getApa_garantia() {
		return apa_garantia;
	}

	public void setApa_garantia(String apa_garantia) {
		this.apa_garantia = apa_garantia;
	}

	public String getApa_nm_obra() {
		return apa_nm_obra;
	}

	public void setApa_nm_obra(String apa_nm_obra) {
		this.apa_nm_obra = apa_nm_obra;
	}

	public String getOut_nu_ato() {
		return out_nu_ato;
	}

	public void setOut_nu_ato(String out_nu_ato) {
		this.out_nu_ato = out_nu_ato;
	}

	public String getApa_nu_notificacao() {
		return apa_nu_notificacao;
	}

	public void setApa_nu_notificacao(String apa_nu_notificacao) {
		this.apa_nu_notificacao = apa_nu_notificacao;
	}

	public String getApa_nu_notificacao_isencao() {
		return apa_nu_notificacao_isencao;
	}

	public void setApa_nu_notificacao_isencao(String apa_nu_notificacao_isencao) {
		this.apa_nu_notificacao_isencao = apa_nu_notificacao_isencao;
	}

	public String getApa_vz_requerida_horas_dia() {
		return apa_vz_requerida_horas_dia;
	}

	public void setApa_vz_requerida_horas_dia(String apa_vz_requerida_horas_dia) {
		this.apa_vz_requerida_horas_dia = apa_vz_requerida_horas_dia;
	}

	public String getApa_nu_termo() {
		return apa_nu_termo;
	}

	public void setApa_nu_termo(String apa_nu_termo) {
		this.apa_nu_termo = apa_nu_termo;
	}

	public String getApa_outorga_abr() {
		return apa_outorga_abr;
	}

	public void setApa_outorga_abr(String apa_outorga_abr) {
		this.apa_outorga_abr = apa_outorga_abr;
	}

	public String getApa_outorga_ago() {
		return apa_outorga_ago;
	}

	public void setApa_outorga_ago(String apa_outorga_ago) {
		this.apa_outorga_ago = apa_outorga_ago;
	}

	public String getApa_outorga_dez() {
		return apa_outorga_dez;
	}

	public void setApa_outorga_dez(String apa_outorga_dez) {
		this.apa_outorga_dez = apa_outorga_dez;
	}

	public String getApa_outorga_fev() {
		return apa_outorga_fev;
	}

	public void setApa_outorga_fev(String apa_outorga_fev) {
		this.apa_outorga_fev = apa_outorga_fev;
	}

	public String getApa_outorga_jan() {
		return apa_outorga_jan;
	}

	public void setApa_outorga_jan(String apa_outorga_jan) {
		this.apa_outorga_jan = apa_outorga_jan;
	}

	public String getApa_outorga_jul() {
		return apa_outorga_jul;
	}

	public void setApa_outorga_jul(String apa_outorga_jul) {
		this.apa_outorga_jul = apa_outorga_jul;
	}

	public String getApa_outorga_jun() {
		return apa_outorga_jun;
	}

	public void setApa_outorga_jun(String apa_outorga_jun) {
		this.apa_outorga_jun = apa_outorga_jun;
	}

	public String getApa_outorga_mai() {
		return apa_outorga_mai;
	}

	public void setApa_outorga_mai(String apa_outorga_mai) {
		this.apa_outorga_mai = apa_outorga_mai;
	}

	public String getApa_outorga_mar() {
		return apa_outorga_mar;
	}

	public void setApa_outorga_mar(String apa_outorga_mar) {
		this.apa_outorga_mar = apa_outorga_mar;
	}

	public String getApa_outorga_nov() {
		return apa_outorga_nov;
	}

	public void setApa_outorga_nov(String apa_outorga_nov) {
		this.apa_outorga_nov = apa_outorga_nov;
	}

	public String getApa_outorga_out() {
		return apa_outorga_out;
	}

	public void setApa_outorga_out(String apa_outorga_out) {
		this.apa_outorga_out = apa_outorga_out;
	}

	public String getApa_outorga_set() {
		return apa_outorga_set;
	}

	public void setApa_outorga_set(String apa_outorga_set) {
		this.apa_outorga_set = apa_outorga_set;
	}

	public String getApa_prazo_notificacao() {
		return apa_prazo_notificacao;
	}

	public void setApa_prazo_notificacao(String apa_prazo_notificacao) {
		this.apa_prazo_notificacao = apa_prazo_notificacao;
	}

	public String getApa_prot_cprh() {
		return apa_prot_cprh;
	}

	public void setApa_prot_cprh(String apa_prot_cprh) {
		this.apa_prot_cprh = apa_prot_cprh;
	}

	public String getApa_obra_tp() {
		return apa_obra_tp;
	}

	public void setApa_obra_tp(String apa_obra_tp) {
		this.apa_obra_tp = apa_obra_tp;
	}

	public String getApa_vz_outorga_ls() {
		return apa_vz_outorga_ls;
	}

	public void setApa_vz_outorga_ls(String apa_vz_outorga_ls) {
		this.apa_vz_outorga_ls = apa_vz_outorga_ls;
	}

	public String getApa_vz_requerida_ls() {
		return apa_vz_requerida_ls;
	}

	public void setApa_vz_requerida_ls(String apa_vz_requerida_ls) {
		this.apa_vz_requerida_ls = apa_vz_requerida_ls;
	}

	public String getOut_tsp_cd() {
		return out_tsp_cd;
	}

	public void setOut_tsp_cd(String out_tsp_cd) {
		this.out_tsp_cd = out_tsp_cd;
	}

	public String getOut_tpo_cd() {
		return out_tpo_cd;
	}

	public void setOut_tpo_cd(String out_tpo_cd) {
		this.out_tpo_cd = out_tpo_cd;
	}

	public String getApa_vz_outorga_m3dia() {
		return apa_vz_outorga_m3dia;
	}

	public void setApa_vz_outorga_m3dia(String apa_vz_outorga_m3dia) {
		this.apa_vz_outorga_m3dia = apa_vz_outorga_m3dia;
	}

	public String getApa_vz_requerida_m3dia() {
		return apa_vz_requerida_m3dia;
	}

	public void setApa_vz_requerida_m3dia(String apa_vz_requerida_m3dia) {
		this.apa_vz_requerida_m3dia = apa_vz_requerida_m3dia;
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

	public String getInt_nu_siagas() {
		return int_nu_siagas;
	}

	public void setInt_nu_siagas(String int_nu_siagas) {
		this.int_nu_siagas = int_nu_siagas;
	}

	public String getIus_vo_resmax() {
		return ius_vo_resmax;
	}

	public void setIus_vo_resmax(String ius_vo_resmax) {
		this.ius_vo_resmax = ius_vo_resmax;
	}

	public String getForn_id() {
		return forn_id;
	}

	public void setForn_id(String forn_id) {
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

	
	
	
	// ---- //

//	@Column(name="int_tin_cd", nullable=false)
//	@Id
//	private String int_tin_cd;
//	 
//	@Column (name="emp_nm_usuario", nullable=false)
//	private String emp_nm_usuario;
//
//	@Column (name="emp_nm_apelido", nullable=false)
//	private String emp_nm_apelido;
//
//	@Column (name="emp_nu_cpfcnpj", nullable=false)
//	private String emp_nu_cpfcnpj;
//
//	@Column (name="int_tsu_cd", nullable=false) private String int_tsu_cd;
//		@Column (name="int_tsi_cd", nullable=false) private String int_tsi_cd;
//	@Column (name="int_cr_latitude", nullable=false) private String int_cr_latitude;
//	@Column (name="int_cr_longitude", nullable=false) private String int_cr_longitude;
//	@Column (name="ing_nu_ibgemunicipio", nullable=false) private String ing_nu_ibgemunicipio;
//	@Column (name="emp_nm_empreendimento", nullable=false) private String emp_nm_empreendimento;
//	@Column (name="emp_ds_emailresponsavel", nullable=false) private String emp_ds_emailresponsavel;
//	@Column (name="emp_nu_cependereco", nullable=false) private String emp_nu_cependereco;
//	@Column (name="emp_ds_logradouro", nullable=false) private String emp_ds_logradouro;
//	@Column (name="emp_ds_complementoendereco", nullable=false) private String emp_ds_complementoendereco;
//	@Column (name="emp_nu_logradouro", nullable=false) private String emp_nu_logradouro;
//	//@Column (name="emp_nm_logradouro", nullable=false) private String emp_nm_logradouro;
//	@Column (name="emp_nu_caixapostal", nullable=false) private String emp_nu_caixapostal;
//	@Column (name="emp_cd_codigoibgecorrespondencia", nullable=false) private String emp_cd_codigoibgecorrespondencia;
//	@Column (name="emp_nu_ddd", nullable=false) private String emp_nu_ddd;
//	@Column (name="emp_nu_telefone", nullable=false) private String emp_nu_telefone;
//	@Column (name="out_tpo_cd", nullable=false) private String out_tpo_cd;
//	@Column (name="out_tsp_cd", nullable=false) private String out_tsp_cd;
//	@Column (name="out_dt_final", nullable=false) private String out_dt_final;
//	@Column (name="out_dt_inicial", nullable=false) private String out_dt_inicial;
//	@Column (name="out_nu_processo", nullable=false) private String out_nu_processo;
//	@Column (name="out_ds_ato", nullable=false) private String out_ds_ato;
//	@Column (name="out_nu_ato", nullable=false) private String out_nu_ato;
//	@Column (name="int_nu_siagas", nullable=false) private String int_nu_siagas;
//	@Column (name="ope_vz_mesjan", nullable=false) private String ope_vz_mesjan;
//	@Column (name="ope_vz_mesfev", nullable=false) private String ope_vz_mesfev;
//	@Column (name="ope_vz_mesmar", nullable=false) private String ope_vz_mesmar;
//	@Column (name="ope_vz_mesabr", nullable=false) private String ope_vz_mesabr;
//	@Column (name="ope_vz_mesmai", nullable=false) private String ope_vz_mesmai;
//	@Column (name="ope_vz_mesjun", nullable=false) private String ope_vz_mesjun;
//	@Column (name="ope_vz_mesjul", nullable=false) private String ope_vz_mesjul;
//	@Column (name="ope_vz_mesago", nullable=false) private String ope_vz_mesago;
//	@Column (name="ope_vz_messet", nullable=false) private String ope_vz_messet;
//	@Column (name="ope_vz_mesout", nullable=false) private String ope_vz_mesout;
//	@Column (name="ope_vz_mesnov", nullable=false) private String ope_vz_mesnov;
//	@Column (name="ope_vz_mesdez", nullable=false) private String ope_vz_mesdez;
//	@Column (name="ope_qt_horasjan", nullable=false) private String ope_qt_horasjan;
//	@Column (name="ope_qt_horasfev", nullable=false) private String ope_qt_horasfev;
//	@Column (name="ope_qt_horasmar", nullable=false) private String ope_qt_horasmar;
//	@Column (name="ope_qt_horasabr", nullable=false) private String ope_qt_horasabr;
//	@Column (name="ope_qt_horasmai", nullable=false) private String ope_qt_horasmai;
//	@Column (name="ope_qt_horasjun", nullable=false) private String ope_qt_horasjun;
//	@Column (name="ope_qt_horasjul", nullable=false) private String ope_qt_horasjul;
//	@Column (name="ope_qt_horasago", nullable=false) private String ope_qt_horasago;
//	@Column (name="ope_qt_horasset", nullable=false) private String ope_qt_horasset;
//	@Column (name="ope_qt_horasout", nullable=false) private String ope_qt_horasout;
//	@Column (name="ope_qt_horasnov", nullable=false) private String ope_qt_horasnov;
//	@Column (name="ope_qt_horasdez", nullable=false) private String ope_qt_horasdez;
//	@Column (name="ope_qt_diajan", nullable=false) private String ope_qt_diajan;
//	@Column (name="ope_qt_diafev", nullable=false) private String ope_qt_diafev;
//	@Column (name="ope_qt_diamar", nullable=false) private String ope_qt_diamar;
//	@Column (name="ope_qt_diaabr", nullable=false) private String ope_qt_diaabr;
//	@Column (name="ope_qt_diamai", nullable=false) private String ope_qt_diamai;
//	@Column (name="ope_qt_diajun", nullable=false) private String ope_qt_diajun;
//	@Column (name="ope_qt_diajul", nullable=false) private String ope_qt_diajul;
//	@Column (name="ope_qt_diaago", nullable=false) private String ope_qt_diaago;
//	@Column (name="ope_qt_diaset", nullable=false) private String ope_qt_diaset;
//	@Column (name="ope_qt_diaout", nullable=false) private String ope_qt_diaout;
//	@Column (name="ope_qt_dianov", nullable=false) private String ope_qt_dianov;
//	@Column (name="ope_qt_diadez", nullable=false) private String ope_qt_diadez;
//	@Column (name="int_vz_maxima", nullable=false) private String int_vz_maxima;
//	@Column (name="fin_tfn_cd", nullable=false) private String fin_tfn_cd;
//	@Column (name="fou_tou_cd", nullable=false) private String fou_tou_cd;
//	@Column (name="sir_tsi_cd", nullable=false) private String sir_tsi_cd;
//	@Column (name="sir_tct_cd", nullable=false) private String sir_tct_cd;
//	@Column (name="sir_ar_irrigada", nullable=false) private String sir_ar_irrigada;
//	@Column (name="ius_nu_alturares", nullable=false) private String ius_nu_alturares;
//	@Column (name="ius_ar_resmax", nullable=false) private String ius_ar_resmax;
//	@Column (name="ius_vo_resmax", nullable=false) private String ius_vo_resmax;
//	@Column (name="efl_qt_dbobruto", nullable=false) private String efl_qt_dbobruto;
//	@Column (name="efl_qt_dbotratado", nullable=false) private String efl_qt_dbotratado;
//	@Column (name="efl_qt_fosforobruto", nullable=false) private String efl_qt_fosforobruto;
//	@Column (name="efl_qt_fosforotratado", nullable=false) private String efl_qt_fosforotratado;
//	@Column (name="efl_qt_nitrogeniobruto", nullable=false) private String efl_qt_nitrogeniobruto;
//	@Column (name="efl_qt_nitrogeniotratado", nullable=false) private String efl_qt_nitrogeniotratado;
//	@Column (name="asb_dt_instalacao", nullable=false) private String asb_dt_instalacao;
//	@Column (name="asb_tnp_cd", nullable=false) private String asb_tnp_cd;
//	@Column (name="asb_nu_diametroperfuracao", nullable=false) private String asb_nu_diametroperfuracao;
//	@Column (name="asb_nu_diametrofiltro", nullable=false) private String asb_nu_diametrofiltro;
//	@Column (name="asb_aqp_cd", nullable=false) private String asb_aqp_cd;
//	@Column (name="asb_nu_topo", nullable=false) private String asb_nu_topo;
//	@Column (name="asb_nu_base", nullable=false) private String asb_nu_base;
//	@Column (name="asb_tpn_cd", nullable=false) private String asb_tpn_cd;
//	@Column (name="asb_tca_cd", nullable=false) private String asb_tca_cd;
//	@Column (name="asb_nu_profundidadefinal", nullable=false) private String asb_nu_profundidadefinal;
//	@Column (name="asb_nu_alturabocatubo", nullable=false) private String asb_nu_alturabocatubo;
//	@Column (name="asb_nu_cotaterreno", nullable=false) private String asb_nu_cotaterreno;
//	@Column (name="tst_dt", nullable=false) private String tst_dt;
//	@Column (name="tst_ttb_cd", nullable=false) private String tst_ttb_cd;
//	@Column (name="tst_ds_tempoduracao", nullable=false) private String tst_ds_tempoduracao;
//	@Column (name="tst_nu_nd", nullable=false) private String tst_nu_nd;
//	@Column (name="tst_nu_ne", nullable=false) private String tst_nu_ne;
//	@Column (name="tst_vz_estabilizacao", nullable=false) private String tst_vz_estabilizacao;
//	@Column (name="tst_tmi_cd", nullable=false) private String tst_tmi_cd;
//	@Column (name="tst_nu_coeficientearmazenamento", nullable=false) private String tst_nu_coeficientearmazenamento;
//	@Column (name="tst_nu_transmissividade", nullable=false) private String tst_nu_transmissividade;
//	@Column (name="tst_nu_condutividadehidraulica", nullable=false) private String tst_nu_condutividadehidraulica;
//	@Column (name="tst_nu_permeabilidade", nullable=false) private String tst_nu_permeabilidade;
//	@Column (name="ama_dt_coleta", nullable=false) private String ama_dt_coleta;
//	@Column (name="ama_dt_analise", nullable=false) private String ama_dt_analise;
//	@Column (name="ama_nu_condutividadeeletrica", nullable=false) private String ama_nu_condutividadeeletrica;
//	@Column (name="ama_qt_temperatura", nullable=false) private String ama_qt_temperatura;
//	@Column (name="ama_qt_std", nullable=false) private String ama_qt_std;
//	@Column (name="ama_qt_ph", nullable=false) private String ama_qt_ph;
//	@Column (name="ama_qt_coliformestotais", nullable=false) private String ama_qt_coliformestotais;
//	@Column (name="ama_qt_coliformesfecais", nullable=false) private String ama_qt_coliformesfecais;
//	@Column (name="ama_qt_bicarbonato", nullable=false) private String ama_qt_bicarbonato;
//	@Column (name="ama_qt_calcio", nullable=false) private String ama_qt_calcio;
//	@Column (name="ama_qt_carbonato", nullable=false) private String ama_qt_carbonato;
//	@Column (name="ama_qt_cloreto", nullable=false) private String ama_qt_cloreto;
//	@Column (name="ama_qt_durezatotal", nullable=false) private String ama_qt_durezatotal;
//	@Column (name="ama_qt_ferrototal", nullable=false) private String ama_qt_ferrototal;
//	@Column (name="ama_qt_fluoretos", nullable=false) private String ama_qt_fluoretos;
//	@Column (name="ama_qt_nitratos", nullable=false) private String ama_qt_nitratos;
//	@Column (name="ama_qt_nitritos", nullable=false) private String ama_qt_nitritos;
//	@Column (name="ama_qt_potassio", nullable=false) private String ama_qt_potassio;
//	@Column (name="ama_qt_sodio", nullable=false) private String ama_qt_sodio;
//	@Column (name="ama_qt_sulfato", nullable=false) private String ama_qt_sulfato;
//	@Column (name="ama_qt_magnesio", nullable=false) private String ama_qt_magnesio;

	
}
