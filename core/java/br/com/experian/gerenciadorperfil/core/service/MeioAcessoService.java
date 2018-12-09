package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;
import br.com.experian.gerenciadorperfil.core.entity.filter.MeioAcessoFilter;



public interface MeioAcessoService extends Service<MeioAcesso, Integer, MeioAcessoFilter> {

	MeioAcesso buscarMeioAcessoPorNome(String name);

	List<String> obterNomesMeiosAcesso() ;
		
	List<MeioAcesso>buscar();

	}
