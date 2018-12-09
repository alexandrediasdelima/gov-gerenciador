package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Cliente;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.ClienteFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;

public interface ClienteService extends Service<Cliente, Integer, ClienteFilter> {

	Cliente buscarClientePorNome(String name);

	List<String> obterNomesClientes() ;
		
	List<Cliente>buscar();

	}
