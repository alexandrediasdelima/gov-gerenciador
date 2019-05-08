package org.gov.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.gov.dao.ExportCnarhDaoImpl;
import org.gov.dao.Export_CnarhDao;
import org.gov.model.ExportCnarh;

public class ExportCnarhServiceImpl implements ExportCnarhService {
	/**
	 *
	 */
	private static final long serialVersionUID = -3568362415379220176L;

	private Export_CnarhDao exportCnarhDao;
	
	public File exportCnarhs() throws IOException {
		exportCnarhDao = new ExportCnarhDaoImpl();
		List<ExportCnarh> exportCnarhs = exportCnarhDao.exportCnarhs();
		
		String cabecalho = "int_tin_cd;int_tsu_cd;int_tsi_cd;int_cr_latitude;int_cr_longitude;ing_nu_ibgemunicipio;emp_nm_empreendimento;emp_nu_cpfcnpj;emp_nm_usuario;emp_ds_emailresponsavel;emp_nu_cependereco;emp_ds_logradouro;emp_ds_complementoendereco;emp_nu_logradouro;emp_nu_caixapostal;emp_cd_codigoibgecorrespondencia;emp_nu_ddd;emp_nu_telefone;out_tpo_cd;out_tsp_cd;out_dt_inicial;out_dt_final;out_nu_processo;out_ds_ato;out_nu_ato;int_nu_siagas;ope_vz_mesjan;ope_vz_mesfev;ope_vz_mesmar;ope_vz_mesabr;ope_vz_mesmai;ope_vz_mesjun;ope_vz_mesjul;ope_vz_mesago;ope_vz_messet;ope_vz_mesout;ope_vz_mesnov;ope_vz_mesdez;ope_qt_horasjan;ope_qt_horasfev;ope_qt_horasmar;ope_qt_horasabr;ope_qt_horasmai;ope_qt_horasjun;ope_qt_horasjul;ope_qt_horasago;ope_qt_horasset;ope_qt_horasout;ope_qt_horasnov;ope_qt_horasdez;ope_qt_diajan;ope_qt_diafev;ope_qt_diamar;ope_qt_diaabr;ope_qt_diamai;ope_qt_diajun;ope_qt_diajul;ope_qt_diaago;ope_qt_diaset;ope_qt_diaout;ope_qt_dianov;ope_qt_diadez;int_vz_maxima;fou_tou_cd;sir_tsi_cd;sir_tct_cd;sir_ar_irrigada;ius_nu_alturares;ius_ar_resmax;ius_vo_resmax;efl_qt_dbobruto;efl_qt_dbotratado;efl_qt_fosforobruto;efl_qt_fosforotratado;efl_qt_nitrogeniobruto;efl_qt_nitrogeniotratado;asb_dt_instalacao;asb_tpn_cd;asb_nu_diametroperfuracao;asb_nu_diametrofiltro;asb_aqp_cd;asb_nu_topo;asb_nu_base;asb_tnp_cd;asb_tca_cd;asb_nu_profundidadefinal;asb_nu_alturabocatubo;asb_nu_cotaterreno;tst_dt;tst_ttb_cd;tst_ds_tempoduracao;tst_nu_nd;tst_nu_ne;tst_vz_estabilizacao;tst_tmi_cd;tst_nu_coeficientearmazenamento;tst_nu_transmissividade;tst_nu_condutividadehidraulica;tst_nu_permeabilidade;ama_dt_coleta;ama_dt_analise;ama_nu_condutividadeeletrica;ama_qt_temperatura;ama_qt_std;ama_qt_ph;ama_qt_coliformestotais;ama_qt_coliformesfecais;ama_qt_bicarbonato;ama_qt_calcio;ama_qt_carbonato;ama_qt_cloreto;ama_qt_durezatotal;ama_qt_ferrototal;ama_qt_fluoretos;ama_qt_nitratos;ama_qt_nitritos;ama_qt_potassio;ama_qt_sodio;ama_qt_sulfato;ama_qt_magnesio";

		File file = new File("C:\\import_cad\\csv\\arquivo.csv");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));
		
		buffWrite.append(cabecalho);
		buffWrite.newLine();
		
		String x;
		
		for (ExportCnarh exportCnarh : exportCnarhs) {
			
			x = exportCnarh.toString();

			buffWrite.append(exportCnarh.toString());
			buffWrite.newLine();

		}

		buffWrite.close();

		return file;
	}

}
