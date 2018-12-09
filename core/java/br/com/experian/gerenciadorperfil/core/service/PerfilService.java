package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;

public interface PerfilService extends Service<Perfil, Long, PerfilFilter> {

	Perfil obterPorCnpjEProduto(String cnpj, Produto produto) throws GerenciadorPerfilServiceException;

	List<Perfil> listarPorProduto(Produto produto);

	Perfil adicionar(Perfil perfil, List<PerfilDocumento> documentos) throws GerenciadorPerfilServiceException;

	Perfil atualizar(Perfil perfil, List<PerfilDocumento> documentos) throws GerenciadorPerfilServiceException;

	Perfil adicionar(Perfil perfil, ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException;
	
	List<Perfil> listarPorTipoAntigo();
	
	List<Perfil> listarPorTipoPreClicado();
	
	List<Perfil> listarPorTipoWhitelist();

}
