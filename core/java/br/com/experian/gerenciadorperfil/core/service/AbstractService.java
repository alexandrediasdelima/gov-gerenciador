package br.com.experian.gerenciadorperfil.core.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.DAO;
import br.com.experian.gerenciadorperfil.core.entity.filter.AbstractEntityFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Transactional(rollbackFor = GerenciadorPerfilServiceException.class)
public abstract class AbstractService<Entity extends Serializable, PK extends Serializable, EntityFilter extends AbstractEntityFilter<Entity, EntityFilter>, EntityDAO extends DAO<Entity, PK, EntityFilter>> {

	private EntityDAO dao;

	private Logger logger;

	public AbstractService(final EntityDAO entityDAO) {
		this.dao = entityDAO;
		this.logger = LoggerFactory.getLogger(getClass());
	}

	protected EntityDAO getDao() {
		return dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public Entity adicionar(Entity entity) throws GerenciadorPerfilServiceException {
		getLogger().debug("adicionar", entity);
		return getDao().adicionar(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public Entity atualizar(Entity entity) throws GerenciadorPerfilServiceException {
		getLogger().debug("atualizar", entity);
		return getDao().atualizar(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public void remover(Entity entity) throws GerenciadorPerfilServiceException {
		getLogger().debug("remover", entity);
		getDao().remover(entity);
	}

//	@Transactional(propagation = Propagation.MANDATORY)
//	public Integer remover(EntityFilter entityFilter) throws GerenciadorPerfilServiceException {
//		getLogger().debug("remover", entityFilter);
//		return getRepository().remover(entityFilter);
//	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = GerenciadorPerfilServiceException.class)
	public Entity obter(PK pk) {
		getLogger().debug("obter", pk);
		return getDao().obter(pk);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = GerenciadorPerfilServiceException.class)
	public List<Entity> listar() {
		getLogger().debug("listar");
		return getDao().listar();
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = GerenciadorPerfilServiceException.class)
	public List<Entity> listar(EntityFilter entityFilter) {
		getLogger().debug("listar", entityFilter);
		return getDao().listar(entityFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = GerenciadorPerfilServiceException.class)
	public Long contar(EntityFilter entityFilter) {
		getLogger().debug("contar", entityFilter);
		return getDao().contar(entityFilter);
	}

	protected Logger getLogger() {
		return logger;
	}
}
