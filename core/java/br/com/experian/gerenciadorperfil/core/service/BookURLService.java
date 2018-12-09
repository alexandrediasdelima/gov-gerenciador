package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.BookUrlFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;

public interface BookURLService extends Service<BookURL, Integer, BookUrlFilter> {

	BookURL buscarBookURLPorNome(String name);

	List<String> obterNomesBookURL() throws BookURLServiceException;
	
	List<BookURL> obterBookURLPorProduto(Produto produto) throws BookURLServiceException;
	
	List<BookURL>buscar()throws BookURLServiceException;
	
	String getStringHtmlTela(String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao, String observacao);
	
	String getStringHtmlTelaInformativo(String urlImagemFundo, String urlTexto, String urlBotaoCiencia, String observacao);
	
	List<BookURL> obterBookURLAcaoEstrategica(Produto produto,String acaoEstrategica);
	List<BookURL> obterBookURLAcaoEstrategica(String acaoEstrategica)throws BookURLServiceException;

	}
