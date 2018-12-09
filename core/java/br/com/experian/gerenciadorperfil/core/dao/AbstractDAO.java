package br.com.experian.gerenciadorperfil.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.experian.gerenciadorperfil.core.entity.filter.AbstractEntityFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilRuntimeException;
import br.com.experian.gerenciadorperfil.core.util.EntityUtils;

/**
 *
 * @author wryel
 *
 * @param <Entity>
 * @param <PK>
 * @param <EntityFilter>
 */
public abstract class AbstractDAO<Entity extends Serializable, PK extends Serializable, EntityFilter extends AbstractEntityFilter<Entity, EntityFilter>> implements DAO<Entity, PK, EntityFilter> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<Entity> entityClass;

	private final Class<EntityFilter> entityFilterClass;

	private final Logger logger;

	public AbstractDAO(final Class<Entity> entityClass, final Class<EntityFilter> entityFilterClass) {
		this.entityClass = entityClass;
		this.entityFilterClass = entityFilterClass;
		this.logger = LoggerFactory.getLogger(getClass());
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected Class<Entity> getEntityClass() {
		return this.entityClass;
	}

	protected Class<EntityFilter> getEntityFilterClass() {
		return this.entityFilterClass;
	}

	public Entity obter(PK pk) {
		return getEntityManager().find(getEntityClass(), pk);
	}

	public Entity adicionar(Entity entity) {
		getLogger().debug("adicionar", entity);
		getEntityManager().persist(entity);
		getEntityManager().flush();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public Entity atualizar(Entity entity) {
		getLogger().debug("atualizar", entity);
		PK pk = (PK) EntityUtils.getPrimaryKey(entity);
		Entity managedEntity = obter(pk);
		EntityUtils.copyProperties(managedEntity, entity);
		getEntityManager().merge(managedEntity);
		getEntityManager().flush();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public void remover(Entity entity) {
		getLogger().debug("remover", entity);
		PK pk = (PK) EntityUtils.getPrimaryKey(entity);
		Entity managedEntity = obter(pk);
		getEntityManager().remove(managedEntity);
		getEntityManager().flush();
	}

	public Integer remover(final EntityFilter filter) {
		getLogger().debug("remover", filter);
		Query query = entityManager.createQuery(createSqlDelete(filter));
		applyFilter(query, filter);
 		return query.executeUpdate();
	}

	protected String createSqlDelete(final EntityFilter entityFilter) {
		throw new IllegalArgumentException("Metodo nao implementado para a entidade " + entityFilter.getClass());
	}

	protected String createSqlGrouped(final EntityFilter entityFilter) {
		throw new IllegalArgumentException("Metodo nao implementado para a entidade " + entityFilter.getClass());
	}

	protected void applyFilter(final Query query, final EntityFilter filter) {
		if (filter.getFirstResult() != null) {
			query.setFirstResult(filter.getFirstResult());
		}
		if (filter.getMaxResult() != null) {
			query.setMaxResults(filter.getMaxResult());
		}
	}

	public List<Entity> listar() {
		getLogger().debug("listar");
		EntityFilter entityFilter = EntityUtils.createFilter(getEntityFilterClass());
		return listar(entityFilter);
	}


	@SuppressWarnings("unchecked")
	public List<Entity> listar(EntityFilter filter) {
		getLogger().debug("listar", filter);
		Query query = entityManager.createQuery(createSqlQuery(filter));
		applyFilter(query, filter);
 		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Entity> listarDuplicidades(EntityFilter filter) {
		getLogger().debug("listarDuplicidades", filter);
		Query query = entityManager.createQuery(createSqlGrouped(filter));
		applyFilter(query, filter);
 		return query.getResultList();
	}

	public Long contar(final EntityFilter entityFilter) {
		getLogger().debug("contar", entityFilter);
		String sql = createSqlCountQuery(createSqlQuery(entityFilter));
		Query query = entityManager.createQuery(sql);
		applyFilter(query, entityFilter);
		return (Long) query.getSingleResult();
	}

	protected String createSqlCountQuery(final String sql) {
		Pattern pattern = Pattern.compile("(SELECT) [^ ]+ (FROM.+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sql);
		String countSql = null;
		if (matcher.matches()) {
			countSql = matcher.group(1) + " COUNT(*) " + matcher.group(2);
		} else {
			String error = "A sql informada nao obedece o padrao SELECT ? FROM ?...";
			getLogger().error(error);
			throw new GerenciadorPerfilRuntimeException(error);
		}
		return countSql;
	}

	protected Logger getLogger() {
		return this.logger;
	}

	protected abstract String createSqlQuery(final EntityFilter filter);

}
