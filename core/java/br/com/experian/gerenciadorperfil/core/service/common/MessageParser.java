package br.com.experian.gerenciadorperfil.core.service.common;

import java.util.Collection;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Feature;

public interface MessageParser {

	String parseBanner(final String banner, final CampanhaGratuidade campanhaGratuidade, final Collection<Feature> campanhaFeatures);
	
	String parseBanner(final String banner, final CaronaFeature carona, final Feature feature);
	
	String parseBanner(final String banner);
}
