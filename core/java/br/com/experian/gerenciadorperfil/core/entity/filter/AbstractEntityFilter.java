package br.com.experian.gerenciadorperfil.core.entity.filter;

import java.io.Serializable;

public class AbstractEntityFilter<Entity extends Serializable, EntityFilter extends AbstractEntityFilter<Entity, EntityFilter>> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer QUANTIDADE_DE_ITEMS_DEFAULT = 20;

	private Integer firstResult;

	private Integer maxResult;

	private Class<EntityFilter> entityFilterClass;

	public AbstractEntityFilter(Class<EntityFilter> entityFilterClass) {
		this.entityFilterClass = entityFilterClass;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public EntityFilter setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
		return this.entityFilterClass.cast(this);
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public EntityFilter setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
		return this.entityFilterClass.cast(this);
	}
}
