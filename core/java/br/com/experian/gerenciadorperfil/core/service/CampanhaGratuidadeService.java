package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.CampanhaGratuidadeFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;


public interface CampanhaGratuidadeService extends Service<CampanhaGratuidade, Long, CampanhaGratuidadeFilter> {

	List<CampanhaGratuidade> listarPorProduto(Produto produto);

	CampanhaGratuidade adicionar(CampanhaGratuidade campanhaGratuidade, ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException;

	CampanhaGratuidade cancelar(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException;

	void verificaExistenciaDeCampanhaVigenteImpeditiva(CampanhaGratuidade campanhaGratuidade, List<Documento> documentos) throws GerenciadorPerfilServiceException;

	List<CampanhaGratuidade> listarQueContenhamFeature(Feature feature);
	
	List<CampanhaGratuidade> listarPorProdutoSemCaronaFeature(Produto produto);
}
