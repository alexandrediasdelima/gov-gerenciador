package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.ClienteDAO;
import br.com.experian.gerenciadorperfil.core.entity.Cliente;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.ClienteFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Integer, ClienteFilter, ClienteDAO> implements ClienteService {


	@Autowired
	public ClienteServiceImpl(ClienteDAO clienteDAO) {

		super(clienteDAO);

		
	}

	private void validarDadosDeEntradaComum(Cliente cliente) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(cliente.getDescricaoTipoCliente())) {
			throw new GerenciadorPerfilServiceException("Descrição é requerida");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cliente adicionar(Cliente cliente) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(cliente);

		Cliente clienteCadastrado = buscarClientePorNome(cliente.getDescricaoTipoCliente());

		if (clienteCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um Cliente cadastrado com este nome");
		}

		Cliente clienteClonado = (Cliente) SerializationUtils.clone(cliente);

		

		return super.adicionar(clienteClonado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cliente atualizar(Cliente cliente) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(cliente);

		
		Cliente clienteClonado = (Cliente) SerializationUtils.clone(cliente);
		
		return super.atualizar(clienteClonado);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Cliente>buscar() {

		ClienteFilter clienteFilter = new ClienteFilter();
		

		List<Cliente> clientes = getDao().listar(clienteFilter);

		if (clientes.isEmpty()) {
			return null;
		}

		return clientes;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private Cliente buscaPorId(Integer id) {

		ClienteFilter clienteFilter = new ClienteFilter();
		clienteFilter.setIdNotEquals(id);

		List<Cliente> clientes = getDao().listar(clienteFilter);

		if (clientes.isEmpty()) {
			return null;
		}

		return clientes.get(0);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Cliente buscarClientePorNome(String nome) {

		ClienteFilter clienteFilter = new ClienteFilter();
		clienteFilter.setNomeEquals(nome);

		List<Cliente> books= getDao().listar(clienteFilter);

		if (books.isEmpty()) {
			return null;
		}

		return books.get(0);
	}

	public List<String> obterNomesClientes() {
		List<String> nomes = new ArrayList<String>();
		
		List<Cliente>clientes =  listar();
		for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			nomes.add(cliente.getDescricaoTipoCliente());
		}
		return nomes;
	}




	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(Cliente cliente) throws GerenciadorPerfilServiceException {

		super.remover(cliente);
	}





}
