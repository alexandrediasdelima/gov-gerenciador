package org.gov.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3540785281132763678L;


	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gerenciador");

	public EntityManager getEntityManager() {

		return entityManagerFactory.createEntityManager();
	}


}
