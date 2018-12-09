package br.com.experian.gerenciadorperfil.core.service;

import java.io.Serializable;
import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.filter.AbstractEntityFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public interface Service<Entity extends Serializable, PK extends Serializable, EntityFilter extends AbstractEntityFilter<Entity, EntityFilter>> {

	Entity obter(PK pk);

	Entity adicionar(Entity entity) throws GerenciadorPerfilServiceException;

	Entity atualizar(Entity entity) throws GerenciadorPerfilServiceException;

	void remover(Entity entity) throws GerenciadorPerfilServiceException;

//	Integer remover(EntityFilter entityFilter) throws GerenciadorPerfilServiceException;

	List<Entity> listar();

	List<Entity> listar(EntityFilter entityFilter);

	Long contar(EntityFilter entityFilter);

	
}
