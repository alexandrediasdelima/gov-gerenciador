package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface DocumentoService extends Service<Documento, Long, DocumentoFilter> {

	List<Documento> listarPorCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade);

	void adicionar(List<Documento> documentos) throws GerenciadorPerfilServiceException;

	Integer removerPorCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException;
}
