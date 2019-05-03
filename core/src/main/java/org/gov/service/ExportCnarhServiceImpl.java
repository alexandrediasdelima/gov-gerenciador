package org.gov.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gov.dao.ExportCnarhDaoImpl;
import org.gov.dao.Export_CnarhDao;
import org.gov.dao.FichaCampoDao;
import org.gov.dao.FichaCampoDaoImpl;
import org.gov.model.ExportCnarh;
import org.gov.model.FichaCampo;
import org.gov.model.Interferencia;
import org.gov.model.SituacaoInterferencia;
import org.gov.model.TipoFinalidade;
import org.gov.model.TipoInterferencia;
import org.gov.model.TipoOutroUso;


public class ExportCnarhServiceImpl implements ExportCnarhService{

	/**
	 *
	 */
	private static final long serialVersionUID = -3568362415379220176L;
	/**
	 *
	 */

	private Export_CnarhDao exportCnarhDao;

	public File exportCnarhs() throws IOException {
		exportCnarhDao = new ExportCnarhDaoImpl();
		List<ExportCnarh> exportCnarhs = exportCnarhDao.exportCnarhs();

		File file = new File("C:/import_cad/csv/arquivo.csv");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));

		for (ExportCnarh exportCnarh : exportCnarhs) {

			buffWrite.append(exportCnarh.toString());
			buffWrite.newLine();

		}

        buffWrite.close();

		return file;
	}

	public static void main(String[] args) throws IOException {

		String um = "Ale, 40319606899";
		String dois = "teste, 40319606899";
		String tres = "teste2, 40319606899";

		List<String> lista =new ArrayList<String>();

		lista.add(um);
		lista.add(dois);
		lista.add(tres);


		File file = new File("C:/import_cad/csv/arquivo.csv");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));

		for (String informacao : lista) {
			buffWrite.append(informacao);
			buffWrite.newLine();
		}

        buffWrite.close();


	}



	}


