package br.com.experian.gerenciadorperfil.core.service.vo;

import br.com.experian.ultimaconsulta.FeatureConsultada;

public class FeatureVO {

	private FeatureConsultada feature;

	private boolean gratis;

	private boolean novo;


	public boolean isGratis() {
		return gratis;
	}

	public void setGratis(boolean gratis) {
		this.gratis = gratis;
	}

	/**
	 * @return the feature
	 */
	public FeatureConsultada getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(FeatureConsultada feature) {
		this.feature = feature;
	}

	/**
	 * @return the novo
	 */
	public boolean isNovo() {
		return novo;
	}

	/**
	 * @param novo the novo to set
	 */
	public void setNovo(boolean novo) {
		this.novo = novo;
	}


}
