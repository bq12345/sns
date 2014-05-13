package org.sns.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sns.model.Wait;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Wait
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.sns.model.Wait
 * @author MyEclipse Persistence Tools
 */
public class WaitDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(WaitDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Wait transientInstance) {
		log.debug("saving Wait instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Wait persistentInstance) {
		log.debug("deleting Wait instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wait findById(java.lang.Integer id) {
		log.debug("getting Wait instance with id: " + id);
		try {
			Wait instance = (Wait) getHibernateTemplate().get(
					"org.sns.model.Wait", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Wait> findByExample(Wait instance) {
		log.debug("finding Wait instance by example");
		try {
			List<Wait> results = (List<Wait>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Wait instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Wait as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Wait instances");
		try {
			String queryString = "from Wait";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Wait merge(Wait detachedInstance) {
		log.debug("merging Wait instance");
		try {
			Wait result = (Wait) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Wait instance) {
		log.debug("attaching dirty Wait instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wait instance) {
		log.debug("attaching clean Wait instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WaitDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WaitDAO) ctx.getBean("WaitDAO");
	}
}