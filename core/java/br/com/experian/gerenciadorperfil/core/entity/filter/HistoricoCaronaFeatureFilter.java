package br.com.experian.gerenciadorperfil.core.entity.filter;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoCaronaFeature;

public class HistoricoCaronaFeatureFilter extends AbstractEntityFilter<HistoricoCaronaFeature, HistoricoCaronaFeatureFilter> {

	private static final long serialVersionUID = 4836604561681921533L;
	
	public static final String ID_CARONA_FEATURE_EQUALS = "idCaronaFeatureEquals";
	
	public static final String STATUS_CARONA_FEATURE_EQUALS = "statusCaronaFeatureEquals";

	private Long idCaronaFeatureEquals;
	
	private Integer statusCaronaFeatureEquals;
	
	public HistoricoCaronaFeatureFilter() {
		super(HistoricoCaronaFeatureFilter.class);
	}

	public Long getIdCaronaFeatureEquals() {
		return idCaronaFeatureEquals;
	}

	public void setIdCaronaFeatureEquals(Long idCaronaFeatureEquals) {
		this.idCaronaFeatureEquals = idCaronaFeatureEquals;
	}

	public Integer getStatusCaronaFeatureEquals() {
		return statusCaronaFeatureEquals;
	}

	public void setStatusCaronaFeatureEquals(
			Integer statusCaronaFeatureEquals) {
		this.statusCaronaFeatureEquals = statusCaronaFeatureEquals;
	}
}
