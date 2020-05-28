/**
 * 
 */
package com.database.model;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.spi.ServiceException;

/**
 * @author Tomï¿½s D.A.
 * Mï¿½dulo:AED
 * Ciclo: 2DAMA
 * Fecha: 10-Dic-2017
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Logger logger = Logger.getGlobal();

	private static void load() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (ServiceException e) {
			logger.warning("Error de creación de sessionFactory /n" + e);
		}
	}
	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null) {
			load();
		}
		return sessionFactory;
	}
}
