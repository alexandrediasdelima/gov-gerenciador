package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.ProdutoFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface ProdutoService extends Service<Produto, Integer, ProdutoFilter> {

	Produto buscaProdutoPorNome(String name);

	List<String> obterNomesProduto();

	List<String> obterNomesProdutosAindaNaoCriados();

	Produto atualizarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException;

	Produto adicionarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException;
}
