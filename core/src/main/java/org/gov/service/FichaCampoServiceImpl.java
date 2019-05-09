package org.gov.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.gov.dao.FichaCampoDao;
import org.gov.dao.FichaCampoDaoImpl;
import org.gov.model.FichaCampo;


public class FichaCampoServiceImpl implements FichaCampoService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FichaCampoDao fichaCampoDao;

	public List<FichaCampo> fichasCampo() {
		fichaCampoDao = new FichaCampoDaoImpl();

		List<FichaCampo> fichasCampo = fichaCampoDao.fichasCampo();

		List<FichaCampo> fichaTratada = new ArrayList<FichaCampo>();
		FichaCampo fichaCampo = null;

		for (FichaCampo ficha : fichasCampo) {

			fichaCampo = new FichaCampo();
			fichaCampo = ficha;

			fichaCampo.setFot_cap_lanc_geral(transformaFotoEmBase64(fichaCampo.getFot_cap_lanc_geral()));
			fichaCampo.setFot_cap_lanc_detalhe(transformaFotoEmBase64(fichaCampo.getFot_cap_lanc_detalhe()));
			fichaCampo.setFot_croqui_localizacao(transformaFotoEmBase64(fichaCampo.getFot_croqui_localizacao()));

			fichaTratada.add(fichaCampo);
		}

		return fichaTratada;
	}

	private String transformaFotoEmBase64(String foto) {

		byte[] array = null;
		String retorno = null;

		File arq = new File("C:/import_cad/imagens/" + foto);

		if(arq != null) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			try {
				FileInputStream in = new FileInputStream(arq);
				int b;
				while ((b = in.read()) > -1) {
					out.write(b);
				}
				out.close();
				in.close();
			} catch (Exception e) {

			}
			array = out.toByteArray();
			retorno = Base64.getEncoder().encodeToString(array);
		}

		return retorno;
	}

}
