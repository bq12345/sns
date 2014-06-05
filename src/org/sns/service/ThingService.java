package org.sns.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.sns.dao.ThingDAO;
import org.sns.model.Thing;
import org.sns.model.User;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class ThingService {
	private ThingDAO dao;
	private UserService service;

	public void setDao(ThingDAO dao) {
		this.dao = dao;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	/**
	 * add a new thing
	 * 
	 * @param t
	 * @return result
	 */
	public boolean addThing(Thing t) {
		try {
			dao.save(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * get user's things
	 * 
	 * @param user
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List getThing(User u) {
		List list = new ArrayList();
		try {
			list = dao.findByProperty("user", u);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a thing
	 * 
	 * @param id
	 * @return Thing
	 */
	public Thing getThing(int id) {
		Thing t = null;
		try {
			t = dao.findById(id);
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get thing's image
	 * 
	 * @param id
	 * @return blob
	 */

	public Blob getImage(int id) {
		Thing t = null;
		try {
			t = dao.findById(id);
			return t.getImage();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get u's friends' things
	 * 
	 * @param u
	 * @return list
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getFriendThings(User u) {
		List things = null;
		try {
			things = new ArrayList();
			List friends = service.getFriendUsers(u);
			for (int i = 0; i < friends.size(); i++) {
				User user = (User) friends.get(i);
				System.out.println(u.getUserId() + " 的好友 " + user.getUserId());
				things.addAll(getThing(user));
			}
			System.out.println("things\t " + things.size());
			Collections.sort(things, comparator);
			return things;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Thing sort
	 */
	Comparator<Thing> comparator = new Comparator<Thing>() {

		@Override
		public int compare(Thing t1, Thing t2) {
			return (int) (t2.getTime().getTime() - t1.getTime().getTime());
		}

	};
}
