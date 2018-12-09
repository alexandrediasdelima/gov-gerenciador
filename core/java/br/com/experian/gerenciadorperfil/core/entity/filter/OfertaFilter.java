package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.util.Date;

import br.com.experian.gerenciadorperfil.core.entity.Oferta;

public class OfertaFilter extends AbstractEntityFilter<Oferta, OfertaFilter> {

	private static final long serialVersionUID = -4493067125415776269L;

	public static final String ID_PRODUTO_EQUALS 			= "idProdutoEquals";
	public static final String TIPO_EQUALS					= "tipoEquals";
	public static final String DATE_BETWEEN_INICIO_AND_FIM	= "dateBetweenInicioAndFim";
	
	public static final String ID_OFERTA_NOT_EQUALS 		= "idOfertaNotEquals";
	public static final String DATA_INICIO 					= "dataInicio";
	public static final String DATA_FIM 					= "dataFim";

	private Integer idProdutoEquals;
	private char tipoEquals;
	private Date dateBetweenInicioAndFim;
	
	private boolean ativa;
	private Integer idOfertaNotEquals;
	private Date dataInicio;
	private Date dataFim;

	public OfertaFilter() {
		super(OfertaFilter.class);
	}

	/**
	 * @return the idProdutoEquals
	 */
	public Integer getIdProdutoEquals() {
		return idProdutoEquals;
	}

	/**
	 * @param idProdutoEquals the idProdutoEquals to set
	 */
	public OfertaFilter setIdProdutoEquals(Integer idProdutoEquals) {
		this.idProdutoEquals = idProdutoEquals;
		return this;
	}

	/**
	 * @return the tipoEquals
	 */
	public char getTipoEquals() {
		return tipoEquals;
	}

	/**
	 * @param tipoEquals the tipoEquals to set
	 */
	public OfertaFilter setTipoEquals(char tipoEquals) {
		this.tipoEquals = tipoEquals;
		return this;
	}

	/**
	 * @return the dateBetweenInicioAndFim
	 */
	public Date getDateBetweenInicioAndFim() {
		return dateBetweenInicioAndFim;
	}

	/**
	 * @param dateBetweenInicioAndFim the dateBetweenInicioAndFim to set
	 */
	public OfertaFilter setDateBetweenInicioAndFim(Date dateBetweenInicioAndFim) {
		this.dateBetweenInicioAndFim = dateBetweenInicioAndFim;
		return this;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public OfertaFilter setAtiva(boolean ativa) {
		this.ativa = ativa;
		return this;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public OfertaFilter setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
		return this;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public OfertaFilter setDataFim(Date dataFim) {
		this.dataFim = dataFim;
		return this;
	}

	public Integer getIdOfertaNotEquals() {
		return idOfertaNotEquals;
	}

	public OfertaFilter setIdOfertaNotEquals(Integer idOfertaNotEquals) {
		this.idOfertaNotEquals = idOfertaNotEquals;
		return this;
	}

}
