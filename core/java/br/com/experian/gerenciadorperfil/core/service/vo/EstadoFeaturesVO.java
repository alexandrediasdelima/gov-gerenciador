package br.com.experian.gerenciadorperfil.core.service.vo;

import java.io.Serializable;
import java.util.Map;

public class EstadoFeaturesVO implements Serializable{

	private static final long serialVersionUID = 4852435581607294959L;

	private CampanhaGratuidadeVO campanhaGratuidadeVO;

	private Map<String, FeatureVO> featuresVO;

	/**
	 * @return the campanhaGratuidadeVO
	 */
	public CampanhaGratuidadeVO getCampanhaGratuidadeVO() {
		return campanhaGratuidadeVO;
	}

	/**
	 * @param campanhaGratuidadeVO the campanhaGratuidadeVO to set
	 */
	public void setCampanhaGratuidadeVO(CampanhaGratuidadeVO campanhaGratuidadeVO) {
		this.campanhaGratuidadeVO = campanhaGratuidadeVO;
	}

	/**
	 * @return the featuresVO
	 */
	public Map<String, FeatureVO> getFeaturesVO() {
		return featuresVO;
	}

	/**
	 * @param featuresVO the featuresVO to set
	 */
	public void setFeaturesVO(Map<String, FeatureVO> featuresVO) {
		this.featuresVO = featuresVO;
	}
}
