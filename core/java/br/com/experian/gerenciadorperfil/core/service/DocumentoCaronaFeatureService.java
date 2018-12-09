package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoCaronaFeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface DocumentoCaronaFeatureService extends Service<DocumentoCaronaFeature, Long, DocumentoCaronaFeatureFilter> {

	List<DocumentoCaronaFeature> listarPorCaronaFeature(CaronaFeature caronaFeature);

	void adicionar(List<DocumentoCaronaFeature> documentos) throws GerenciadorPerfilServiceException;

	Integer removerPorCaronaFeature(CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException;
	
	//INC1709536 - Efetuar o bloqueio por CNPJ + Logon que possui a feature ativa.
	List<DocumentoCaronaFeature> listarPorCampanhaAceitaSemCancelamento(Feature feature, List<String> cnpjs, List<String> logons);
	
	List<DocumentoCaronaFeature> listarDocumentosCienciaPendente(List<String> cnpjs, String produto);

}
