package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;

public class CampanhaGratuidadeFilter extends AbstractEntityFilter<CampanhaGratuidade, CampanhaGratuidadeFilter> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	public static final String CONTEM_CNPJ = "contemCNPJ";

	public static final String DATA_BETWEEN = "dataBetween";

	public static final String NAO_CANCELADA = "naoCancelada";

	public static final String NAO_CONTEM_CNPJ = "naoContemCNPJ";

	public static final String TIPO = "tipo";

	public static final String GREATHER_EQUALS_THAN_DATA_INICIO = "greatherEqualsThanDataInicio";

	public static final String LOWER_EQUALS_THAN_DATA_FIM = "lowerEqualsThanDataFim";

	public static final String NAO_VENCIDA = "naoVencida";

	public static final String TODAY = "today";

	public static final String ID_NOT_EQUALS = "idNotEquals";

	public static final String CONTAINS_FEATURE_ID = "contaisFeatureId";
	
	public static final String NAO_CONTEM_CARONA_FEATURE_VINCULADA = "naoContemCaronaFeatureVinculada";

	private Long idNotEquals;

	private Integer idProdutoEquals;

	private String contemCNPJ;

	private Date dataBetween;

	private boolean naoCancelada;

	private Integer tipo;

	private String naoContemCNPJ;

	private Date greatherEqualsThanDataInicio;

	private Date lowerEqualsThanDataFim;

	private boolean naoVencida;

	private boolean vigente;

	private boolean naoContemCaronaFeatureVinculada;
	
	private List<Integer> containsFeaturesId;

	public CampanhaGratuidadeFilter() {
		super(CampanhaGratuidadeFilter.class);
	}

	public Integer getIdProdutoEquals() {
		return idProdutoEquals;
	}

	public CampanhaGratuidadeFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}

	/**
	 * @return the contemCNPJ
	 */
	public String getContemCNPJ() {
		return contemCNPJ;
	}

	/**
	 * @param contemCNPJ the contemCNPJ to set
	 */
	public CampanhaGratuidadeFilter setContemCNPJ(String contemCNPJ) {
		this.contemCNPJ = contemCNPJ;
		return this;
	}

	/**
	 * @return the dataBetween
	 */
	public Date getDataBetween() {
		return dataBetween;
	}

	/**
	 * @param dataBetween the dataBetween to set
	 */
	public CampanhaGratuidadeFilter setDataBetween(Date dataBetween) {
		this.dataBetween = dataBetween;
		return this;
	}

	/**
	 * @return the naoCancelada
	 */
	public boolean getNaoCancelada() {
		return naoCancelada;
	}

	/**
	 * @param naoCancelada the naoCancelada to set
	 */
	public CampanhaGratuidadeFilter setNaoCancelada(boolean naoCancelada) {
		this.naoCancelada = naoCancelada;
		return this;
	}

	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public CampanhaGratuidadeFilter setTipo(Integer tipo) {
		this.tipo = tipo;
		return this;
	}

	/**
	 * @return the naoContemCNPJ
	 */
	public String getNaoContemCNPJ() {
		return naoContemCNPJ;
	}

	/**
	 * @param naoContemCNPJ the naoContemCNPJ to set
	 */
	public CampanhaGratuidadeFilter setNaoContemCNPJ(String naoContemCNPJ) {
		this.naoContemCNPJ = naoContemCNPJ;
		return this;
	}

	/**
	 * @return the greatherEqualsThanDataInicio
	 */
	public Date getGreatherEqualsThanDataInicio() {
		return greatherEqualsThanDataInicio;
	}

	/**
	 * @param greatherEqualsThanDataInicio the greatherEqualsThanDataInicio to set
	 */
	public CampanhaGratuidadeFilter setGreatherEqualsThanDataInicio(Date greatherEqualsThanDataInicio) {
		this.greatherEqualsThanDataInicio = greatherEqualsThanDataInicio;
		return this;
	}

	/**
	 * @return the lowerEqualsThanDataFim
	 */
	public Date getLowerEqualsThanDataFim() {
		return lowerEqualsThanDataFim;
	}

	/**
	 * @param lowerEqualsThanDataFim the lowerEqualsThanDataFim to set
	 */
	public CampanhaGratuidadeFilter setLowerEqualsThanDataFim(Date lowerEqualsThanDataFim) {
		this.lowerEqualsThanDataFim = lowerEqualsThanDataFim;
		return this;
	}

	/**
	 * @return the naoVencida
	 */
	public boolean getNaoVencida() {
		return naoVencida;
	}

	/**
	 * @param naoVencida the naoVencida to set
	 */
	public CampanhaGratuidadeFilter setNaoVencida(boolean naoVencida) {
		this.naoVencida = naoVencida;
		return this;
	}

	/**
	 * @return the vigente
	 */
	public boolean getVigente() {
		return vigente;
	}

	/**
	 * @param Vigente the vigente to set
	 */
	public CampanhaGratuidadeFilter setVigente(boolean vigente) {
		this.vigente = vigente;
		return this;
	}

	/**
	 * @return the idNotEquals
	 */
	public Long getIdNotEquals() {
		return idNotEquals;
	}

	/**
	 * @param idNotEquals the idNotEquals to set
	 */
	public CampanhaGratuidadeFilter setIdNotEquals(Long idNotEquals) {
		this.idNotEquals = idNotEquals;
		return this;
	}

	/**
	 * @return the containsFeatures
	 */
	public List<Integer> getContainsFeaturesId() {
		if (containsFeaturesId == null) {
			containsFeaturesId = new ArrayList<Integer>();
		}
		return containsFeaturesId;
	}

	/**
	 * @param containsFeatures the containsFeatures to set
	 */
	public CampanhaGratuidadeFilter setContainsFeaturesId(List<Integer> containsFeaturesId) {
		this.containsFeaturesId = containsFeaturesId;
		return this;
	}

	public boolean isNaoContemCaronaFeatureVinculada() {
		return naoContemCaronaFeatureVinculada;
	}

	public void setNaoContemCaronaFeatureVinculada(
			boolean naoContemCaronaFeatureVinculada) {
		this.naoContemCaronaFeatureVinculada = naoContemCaronaFeatureVinculada;
	}

}
