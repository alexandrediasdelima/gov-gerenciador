package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.io.Serializable;
import java.util.Date;

import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;

public class CaronaFeatureFilter extends AbstractEntityFilter<CaronaFeature, CaronaFeatureFilter> implements Serializable {


	private static final long serialVersionUID = -2870718483532426469L;

	public static final String ID_PRODUTO_EQUALS = "idProdutoEquals";

	public static final String ID_FEATURE_EQUALS = "idFeatureEquals";

	public static final String CONTEM_CNPJ = "contemCNPJ";

	public static final String NAO_CONTEM_CNPJ = "naoContemCNPJ";

	public static final String DATA_BETWEEN = "dataBetween";

	public static final String TIPO_OFERTA = "tipoOferta";

	public static final String GREATHER_EQUALS_THAN_DATA_INICIO = "greatherEqualsThanDataInicio";

	public static final String LOWER_EQUALS_THAN_DATA_FIM = "lowerEqualsThanDataFim";
	
	public static final String NAO_CANCELADA = "naoCancelada";

	public static final String NAO_VENCIDA = "naoVencida";

	public static final String TODAY = "today";

	public static final String ID_NOT_EQUALS = "idNotEquals";

	private Long idNotEquals;

	private Integer idProdutoEquals;

	private Integer idFeatureEquals;

	private String contemCNPJ;

	private Date dataBetween;

	private boolean naoCancelada;

	private Character tipoOferta;

	private String naoContemCNPJ;

	private Date greatherEqualsThanDataInicio;

	private Date lowerEqualsThanDataFim;

	private boolean naoVencida;

	private boolean vigente;

	public CaronaFeatureFilter() {
		super(CaronaFeatureFilter.class);
	}

	public Integer getIdProdutoEquals() {
		return idProdutoEquals;
	}

	public CaronaFeatureFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}

	public Integer getIdFeatureEquals() {
		return idFeatureEquals;
	}
	
	public CaronaFeatureFilter setIdFeatureEquals(Integer idFeatureEquals) {
		this.idFeatureEquals = idFeatureEquals;
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
	public CaronaFeatureFilter setContemCNPJ(String contemCNPJ) {
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
	public CaronaFeatureFilter setDataBetween(Date dataBetween) {
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
	public CaronaFeatureFilter setNaoCancelada(boolean naoCancelada) {
		this.naoCancelada = naoCancelada;
		return this;
	}

	/**
	 * @return the tipo
	 */
	public Character getTipoOferta() {
		return tipoOferta;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public CaronaFeatureFilter setTipoOferta(Character tipoOferta) {
		this.tipoOferta = tipoOferta;
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
	public CaronaFeatureFilter setNaoContemCNPJ(String naoContemCNPJ) {
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
	public CaronaFeatureFilter setGreatherEqualsThanDataInicio(Date greatherEqualsThanDataInicio) {
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
	public CaronaFeatureFilter setLowerEqualsThanDataFim(Date lowerEqualsThanDataFim) {
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
	public CaronaFeatureFilter setNaoVencida(boolean naoVencida) {
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
	public CaronaFeatureFilter setVigente(boolean vigente) {
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
	public CaronaFeatureFilter setIdNotEquals(Long idNotEquals) {
		this.idNotEquals = idNotEquals;
		return this;
	}

}
