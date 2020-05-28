package com.database.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

public abstract class GenericDAOImplementation<T,ID extends Serializable>  {
	private Logger logger = Logger.getGlobal();
	Session session;


	public GenericDAOImplementation(Session session) {
		super();
		this.session = session;
	}

	public void create(T object){
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		}catch (Exception e) {
			logger.warning("Error al crear " + object);
		}
	}

	public void saveOrUpdate(T object) {
		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}catch (Exception e) {
			logger.warning("Error al crear " + object);
		}
	}

	public T get(ID id) {
		
		T object = null;
		logger.info("Obteniendo Objeto con id: " + id);
		try {
			object = (T) session.get(getEntityClass(), id);
			if (object == null) {
				logger.warning("No se encuentra el objeto");
			} 
			
		} catch (RuntimeException re) {
			logger.warning("Error" +re);
			throw re;
		}
		
		return object;
	}

	public void delete(T object) {
		logger.info("Eliminando");
		try {
			session.beginTransaction();
			session.delete(object);
			session.flush();
			session.getTransaction().commit();
		} catch (RuntimeException re) {
			logger.warning("Error" +re);
			throw re;
		}
	}

	public List<T> findAllObjects() {
		@SuppressWarnings("unchecked")
		Query<T> query = session.createQuery("select e from "+getEntityClass().getName()+" e");
		List<T>  list =  query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
         return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
     }
}
