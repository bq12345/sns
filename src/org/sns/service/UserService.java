package org.sns.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.sns.dao.UserDAO;
import org.sns.model.Friend;
import org.sns.model.Message;
import org.sns.model.Thing;
import org.sns.model.User;
import org.sns.model.Wait;
import org.sns.util.Validate;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class UserService {
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	/**
	 * 判断是否可以注册
	 * 
	 * @param s
	 *            is email or phone
	 * @return 不合法不可注册，已经存在也不可以注册
	 */
	public boolean canRegiste(String s) {
		System.out.println("准备注册的手机或者邮件是" + s);
		if (Validate.isEmail(s)) {// 如果是合法的邮件
			if (dao.findByEmail(s).size() > 0) {// 如果已经有了
				return false;
			} else {
				return true;
			}
		}
		if (Validate.isPhone(s)) {// 如果是合法的手机

			if (dao.findByPhone(s).size() > 0) {
				return false;
			} else {
				return true;
			}

		}

		return false;
	}

	/**
	 * If the user exist
	 * 
	 * @param s
	 *            is email or phone
	 * @return user
	 */
	public User existUser(String s) {
		System.out.println("用户的输入是  " + s);
		if (Validate.isEmail(s)) {
			System.out.println("邮件" + s);
			if (dao.findByEmail(s).size() == 0) {
				return null;
			}
			User user = dao.findByEmail(s).get(0);
			return user;
		}
		if (Validate.isPhone(s)) {
			System.out.println("手机号" + s);
			if (dao.findByPhone(s).size() == 0) {
				return null;
			}
			User user = dao.findByPhone(s).get(0);
			return user;
		}

		return null;
	}

	/**
	 * Register a new user
	 * 
	 * @param user
	 * @return the result
	 */
	public boolean addUser(User user) {
		try {
			dao.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * update a user
	 * 
	 * @param user
	 * @return result
	 */
	public boolean updateUser(User user) {
		try {
			dao.merge(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * get a user
	 * 
	 * @param user
	 * @return result
	 */
	public User getUser(int id) {
		User u = null;
		try {
			u = dao.findById(id);
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a u's who want to make friends with u
	 * 
	 * @param u
	 * @return List<User>
	 */
	public List<User> getWaits(User u) {
		List<User> users = new ArrayList<User>();
		try {
			List<Wait> waits = new ArrayList<Wait>(u.getWaitsForReceiverId());
			for (int i = 0; i < waits.size(); i++) {
				users.add(waits.get(i).getUserBySenderId());
			}
			return users;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a u's friends
	 * 
	 * @param u
	 * @return List<Friend>
	 */
	public List<Friend> getFriendList(User u) {
		try {
			List<Friend> left = new ArrayList<Friend>(u.getFriendsForUserId());
			List<Friend> right = new ArrayList<Friend>(u.getFriendsForOtherId());
			List<Friend> friends = new ArrayList<Friend>();
			friends.addAll(right);
			friends.addAll(left);

			return friends;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a u's friends
	 * 
	 * @param u
	 * @return List<User>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getFriendUsers(User u) {
		try {
			List users = new ArrayList();
			List<Friend> list = getFriendList(u);
			for (int i = 0; i < list.size(); i++) {
				users.add(list.get(i).getUserByOtherId());
			}
			System.out.println("users\t " + users.size());
			return users;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get user's image
	 * 
	 * @param id
	 * @return blob
	 */
	public Blob getImage(int id) {
		User u = null;
		try {
			u = dao.findById(id);
			return u.getImage();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a u's things
	 * 
	 * @param u
	 * @return List<Thing>
	 */
	public List<Thing> getThings(User u) {
		try {
			List<Thing> things = new ArrayList<Thing>();
			things.addAll(u.getThings());
			return things;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get a u's msgs
	 * 
	 * @param u
	 * @return List<Message>
	 */
	public List<Message> getMsgs(User u) {
		try {
			return new ArrayList<Message>(u.getMessagesForReceiverId());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Find a user by example
	 * 
	 * @param u
	 * @return user
	 */
	public User findByUser(User u) {
		return (User) dao.findByExample(u).get(0);

	}
}
