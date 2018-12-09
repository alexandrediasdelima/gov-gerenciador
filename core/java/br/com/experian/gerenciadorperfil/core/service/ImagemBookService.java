package br.com.experian.gerenciadorperfil.core.service;

import br.com.experian.gerenciadorperfil.core.entity.ImagemBook;
import br.com.experian.gerenciadorperfil.core.entity.filter.ImagemBookFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface ImagemBookService extends Service<ImagemBook, Long, ImagemBookFilter> {

	ImagemBook adicionar(ImagemBook imagemBook) throws GerenciadorPerfilServiceException;
	//Produto buscaProdutoPorNome(String name);

/*	List<String> obterNomesProduto();

	List<String> obterNomesProdutosAindaNaoCriados();

	Produto atualizarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException;

	Produto adicionarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException;*/
}
