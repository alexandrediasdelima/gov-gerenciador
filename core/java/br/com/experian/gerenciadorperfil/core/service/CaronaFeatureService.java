package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Banner;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.CaronaFeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;

public interface CaronaFeatureService extends Service<CaronaFeature, Long, CaronaFeatureFilter> {

	CaronaFeature adicionar(CaronaFeature desconto, ArquivoUploadDownload arquivoUpload, Banner banner, String featureDescontoMF) throws GerenciadorPerfilServiceException;
	
	List<CaronaFeature> buscarDescontoProduto(Produto produto);
	
	String getStringHtmlOferta(Banner banner, CampanhaGratuidade campanha);
	
	String getStringHtmlJuridico(Banner banner, CampanhaGratuidade campanha);
	
	String getStringHtmlInformativo(Banner banner, CampanhaGratuidade campanha);	
	
	void verificarExistenciaDeCampanhaImpeditiva(List<DocumentoCaronaFeature> documentos, CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException;
	
}
