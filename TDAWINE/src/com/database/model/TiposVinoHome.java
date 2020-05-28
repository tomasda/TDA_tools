package com.database.model;
// Generated 20-dic-2017 10:10:10 by Hibernate Tools 5.2.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class TiposVino.
 * @see com.database.model.TiposVino
 * @author Hibernate Tools
 */
public class TiposVinoHome {

	private static final Log log = LogFactory.getLog(TiposVinoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TiposVino transientInstance) {
		log.debug("persisting TiposVino instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TiposVino instance) {
		log.debug("attaching dirty TiposVino instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TiposVino instance) {
		log.debug("attaching clean TiposVino instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TiposVino persistentInstance) {
		log.debug("deleting TiposVino instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TiposVino merge(TiposVino detachedInstance) {
		log.debug("merging TiposVino instance");
		try {
			TiposVino result = (TiposVino) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TiposVino findById(java.lang.Integer id) {
		log.debug("getting TiposVino instance with id: " + id);
		try {
			TiposVino instance = (TiposVino) sessionFactory.getCurrentSession().get("com.database.model.TiposVino", id);
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

	public List<TiposVino> findByExample(TiposVino instance) {
		log.debug("finding TiposVino instance by example");
		try {
			List<TiposVino> results = sessionFactory.getCurrentSession().createCriteria("com.database.model.TiposVino")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
