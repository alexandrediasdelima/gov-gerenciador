package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilDocumentoFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface PerfilDocumentoService extends Service<PerfilDocumento, Long, PerfilDocumentoFilter> {

	List<PerfilDocumento> listarPorPerfil(Perfil perfil);

	List<PerfilDocumento> listarPorCNPJ(String cnpj) throws GerenciadorPerfilServiceException;

	List<PerfilDocumento> listarDuplicadosPorListaDePerfis(List<Perfil> perfis);

	void adicionar(List<PerfilDocumento> documentos);

	void removerPorPerfil(Perfil perfil);
}
