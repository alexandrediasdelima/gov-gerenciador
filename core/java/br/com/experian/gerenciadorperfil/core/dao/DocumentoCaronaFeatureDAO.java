package br.com.experian.gerenciadorperfil.core.dao;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoCaronaFeatureFilter;

public interface DocumentoCaronaFeatureDAO extends DAO<DocumentoCaronaFeature, Long, DocumentoCaronaFeatureFilter> {

	void adicionar(List<DocumentoCaronaFeature> documento);
	
	// Querie criada por questões de otimização
	//INC1709536 - Efetuar o bloqueio por CNPJ + Logon que possui a feature ativa.
	List<DocumentoCaronaFeature> buscarComAceiteSemCancelamento(Feature feature, List<String> cnpjs,  List<String> logons);
	
	List<DocumentoCaronaFeature> listarDocumentosCienciaPendente(List<String> cnpjs, String produto);
	
}
