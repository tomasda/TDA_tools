package com.tda.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() {
		if (null==entityManagerFactory) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("JPA_Project");
			}catch (Exception e) {
				System.out.println("Error iniciando SessionFactory");
			}
		}
		return entityManagerFactory.createEntityManager();
	}
}
