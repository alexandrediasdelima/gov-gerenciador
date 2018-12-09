package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Oferta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.OfertaFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface OfertaService extends Service<Oferta, Integer, OfertaFilter> {

	Oferta adicionar(Oferta oferta, String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao) throws GerenciadorPerfilServiceException;
	
	List<Oferta> buscarOfertaProduto(Produto produto);
	
	String getStringHtmlTela(String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao);

}
