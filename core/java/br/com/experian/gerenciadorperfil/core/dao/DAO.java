package br.com.experian.gerenciadorperfil.core.dao;

import java.io.Serializable;
import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.filter.AbstractEntityFilter;

public interface DAO<Entity extends Serializable, PK extends Serializable, EntityFilter extends AbstractEntityFilter<Entity, EntityFilter>> {

	int BULK_STATEMENT_SIZE = 100;

	Entity obter(PK pk);

	Entity adicionar(Entity entity);

	Entity atualizar(Entity entity);

	void remover(Entity entity);

	Integer remover(EntityFilter entityFilter);

	List<Entity> listar();

	List<Entity> listar(EntityFilter entityFilter);

	List<Entity> listarDuplicidades(EntityFilter entityFilter);

	Long contar(EntityFilter entityFilter);
}
