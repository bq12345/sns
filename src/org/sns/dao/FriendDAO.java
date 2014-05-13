package org.sns.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sns.model.Friend;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Friend entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.sns.model.Friend
 * @author MyEclipse Persistence Tools
 */
public class FriendDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FriendDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Friend transientInstance) {
		log.debug("saving Friend instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Friend persistentInstance) {
		log.debug("deleting Friend instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Friend findById(java.lang.Integer id) {
		log.debug("getting Friend instance with id: " + id);
		try {
			Friend instance = (Friend) getHibernateTemplate().get(
					"org.bq.dao.Friend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Friend> findByExample(Friend instance) {
		log.debug("finding Friend instance by example");
		try {
			List<Friend> results = (List<Friend>) getHibernateTemplate()
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
		log.debug("finding Friend instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Friend as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Friend instances");
		try {
			String queryString = "from Friend";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Friend merge(Friend detachedInstance) {
		log.debug("merging Friend instance");
		try {
			Friend result = (Friend) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Friend instance) {
		log.debug("attaching dirty Friend instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Friend instance) {
		log.debug("attaching clean Friend instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FriendDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FriendDAO) ctx.getBean("FriendDAO");
	}
}