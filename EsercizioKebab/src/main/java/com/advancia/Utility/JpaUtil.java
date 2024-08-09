package com.advancia.Utility;

import javax.persistence.*;

public class JpaUtil {
	private static final String PERSISTENCE_UNIT_NAME = "kebabPersistance";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}

	public static EntityManager GetEntityManager() {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		return manager;
	}
	public static EntityTransaction GetEntityTransaction(EntityManager manager) {
		EntityTransaction transaction = manager.getTransaction();
		return transaction;
	}
	
	public static void CloseEntityManager(EntityManager manager) {
		manager.close();
	}
}
