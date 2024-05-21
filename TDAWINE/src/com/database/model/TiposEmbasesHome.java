package com.database.model;
// Generated 20-dic-2017 10:10:10 by Hibernate Tools 5.2.5.Final

import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Home object for domain model class TiposEmbases.
 * @see com.database.model.TiposEmbases
 * @author Hibernate Tools
 */
public class TiposEmbasesHome {

	private static final Log log = LogFactory.getLog(TiposEmbasesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TiposEmbases transientInstance) {
		log.debug("persisting TiposEmbases instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TiposEmbases instance) {
		log.debug("attaching dirty TiposEmbases instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TiposEmbases instance) {
		log.debug("attaching clean TiposEmbases instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TiposEmbases persistentInstance) {
		log.debug("deleting TiposEmbases instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TiposEmbases merge(TiposEmbases detachedInstance) {
		log.debug("merging TiposEmbases instance");
		try {
			TiposEmbases result = (TiposEmbases) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TiposEmbases findById(java.lang.Integer id) {
		log.debug("getting TiposEmbases instance with id: " + id);
		try {
			TiposEmbases instance = (TiposEmbases) sessionFactory.getCurrentSession()
					.get("com.database.model.TiposEmbases", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(TiposEmbases instance) {
		log.debug("finding TiposEmbases instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaQuery<TiposEmbases> criteriaQuery = session.getCriteriaBuilder().createQuery(TiposEmbases.class);
			criteriaQuery.from(TiposEmbases.class);
			List<TiposEmbases> results = session.createQuery(criteriaQuery).getResultList();
			
			//List<?> results = sessionFactory.getCurrentSession().createCriteria("com.database.model.TiposEmbases")
			//		.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
