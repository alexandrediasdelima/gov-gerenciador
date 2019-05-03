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

}
