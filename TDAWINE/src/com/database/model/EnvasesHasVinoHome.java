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
 * Home object for domain model class EnvasesHasVino.
 * @see com.database.model.EnvasesHasVino
 * @author Hibernate Tools
 */
public class EnvasesHasVinoHome {

	private static final Log log = LogFactory.getLog(EnvasesHasVinoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(EnvasesHasVino transientInstance) {
		log.debug("persisting EnvasesHasVino instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EnvasesHasVino instance) {
		log.debug("attaching dirty EnvasesHasVino instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EnvasesHasVino instance) {
		log.debug("attaching clean EnvasesHasVino instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EnvasesHasVino persistentInstance) {
		log.debug("deleting EnvasesHasVino instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EnvasesHasVino merge(EnvasesHasVino detachedInstance) {
		log.debug("merging EnvasesHasVino instance");
		try {
			EnvasesHasVino result = (EnvasesHasVino) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EnvasesHasVino findById(com.database.model.EnvasesHasVinoId id) {
		log.debug("getting EnvasesHasVino instance with id: " + id);
		try {
			EnvasesHasVino instance = (EnvasesHasVino) sessionFactory.getCurrentSession()
					.get("com.database.model.EnvasesHasVino", id);
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

	@SuppressWarnings("rawtypes")
	public List findByExample(EnvasesHasVino instance) {
		log.debug("finding EnvasesHasVino instance by example");
		try {
			@SuppressWarnings("deprecation")
			List results = sessionFactory.getCurrentSession().createCriteria("com.database.model.EnvasesHasVino")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
