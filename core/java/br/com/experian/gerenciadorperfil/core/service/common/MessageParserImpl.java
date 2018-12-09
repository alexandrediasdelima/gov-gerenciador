package br.com.experian.gerenciadorperfil.core.service.common;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Component
public class MessageParserImpl implements MessageParser {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public String parseBanner(final String banner, final CampanhaGratuidade campanhaGratuidade, final Collection<Feature> campanhaFeatures) {

		String bannerFormat = banner;

		if (StringUtils.isNotBlank(banner)){
			
			if (banner.contains("%FEATURE%")) {

				StringBuilder message = new StringBuilder();

				if(!CollectionUtils.isEmpty(campanhaFeatures)) {
					for (Feature feature : campanhaFeatures) {
						message.append(feature.getNome() + ", ");
					}
				}

				bannerFormat = bannerFormat.replace("%FEATURE%", message.toString().substring(0, message.lastIndexOf(",") > 0 ? message.lastIndexOf(",") : 0));
			}

			if (banner.contains("%COUNT%") && campanhaGratuidade.getDataFimGratuidade() != null) {
				bannerFormat = bannerFormat.replace("%COUNT%", String.valueOf(DateCompare.getDaysBetween(new Date(), campanhaGratuidade.getDataFimGratuidade()) + 1));
			}

			if (banner.contains("%DATA_INICIO_GRATUIDADE%")){
				bannerFormat = bannerFormat.replace("%DATA_INICIO_GRATUIDADE%", campanhaGratuidade.getDataInicioGratuidade() == null ? " " : dateFormat.format(campanhaGratuidade.getDataInicioGratuidade()));
			}

			if (banner.contains("%DATA_FIM_GRATUIDADE%")){
				bannerFormat = bannerFormat.replace("%DATA_FIM_GRATUIDADE%", campanhaGratuidade.getDataFimGratuidade() == null ? " " : dateFormat.format(campanhaGratuidade.getDataFimGratuidade()));
			}
		}

		return bannerFormat;
	}
	
	public String parseBanner(final String banner, final CaronaFeature carona, final Feature feature){
		
		String bannerFormat = banner;

		if (StringUtils.isNotBlank(banner)){
			
			if (banner.contains("%FEATURE%") && feature != null) {
				bannerFormat = bannerFormat.replace("%FEATURE%", feature.getNome());
			}

			if (banner.contains("%COUNT%") && carona.getDataFim()!= null) {
				bannerFormat = bannerFormat.replace("%COUNT%", String.valueOf(DateCompare.getDaysBetween(new Date(), carona.getDataFim()) + 1));
			}

			if (banner.contains("%DATA_INICIO_CARONA%")){
				bannerFormat = bannerFormat.replace("%DATA_INICIO_CARONA%", carona.getDataInicio() == null ? " " : dateFormat.format(carona.getDataInicio()));
			}

			if (banner.contains("%DATA_FIM_CARONA%")){
				bannerFormat = bannerFormat.replace("%DATA_FIM_CARONA%", carona.getDataFim() == null ? " " : dateFormat.format(carona.getDataFim()));
			}
		}

		return bannerFormat;
	}
	
	
	public String parseBanner(final String banner) {

		String bannerFormat = banner;

		if (StringUtils.isNotBlank(banner)){
			
			if (banner.contains("%FEATURE%")) {

				StringBuilder message = new StringBuilder();

				

				bannerFormat = bannerFormat.replace("%FEATURE%", message.toString().substring(0, message.lastIndexOf(",") > 0 ? message.lastIndexOf(",") : 0));
			}


		}

		return bannerFormat;
	}
	

}
