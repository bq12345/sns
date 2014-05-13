package org.sns.service;

import java.util.List;

import org.sns.dao.PageDAO;
import org.sns.dao.ThingDAO;
import org.sns.model.Page;
import org.sns.model.User;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class PageService {
	private PageDAO dao;
	private ThingDAO thingDao;
	
	public void setDao(PageDAO dao) {
		this.dao = dao;
	}
	public void setThingDao(ThingDAO thingDao) {
		this.thingDao = thingDao;
	}

	/**
	 * Add a new user
	 * 
	 * @param user
	 * @return the result
	 */
	public boolean addPage(Page p) {
		try {
			dao.save(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * get a page
	 * 
	 * @param user
	 * @return result
	 */
	public Page getPage(int id) {
		Page p = null;
		try {
			p = dao.findById(id);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get followers
	 * @param Page
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List getUsers(Page p) {
		List list = null;
		try {
			list = dao.findByProperty("marks", p);
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * get all pages
	 * @return List<Page>
	 */
	@SuppressWarnings("rawtypes")
	public List getAllPages() {
		List list = null;
		try {
			list = dao.findAll();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * get pages' things
	 * @return List<Thing>
	 */
	@SuppressWarnings("rawtypes")
	public List getPageThings(Page p) {
		List list = null;
		try {
			User u=p.getUser();
			list = thingDao.findByProperty("user", u);
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
