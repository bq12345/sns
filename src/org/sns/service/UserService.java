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
	 * If the user exist
	 * 
	 * @param s is email or phone
	 * @return
	 */
	public boolean existUser(String s) {
		if (Validate.isEmail(s)) {
			if (dao.findByEmail(s).size() > 0) {
				return true;
			}
		}
		if (Validate.isPhone(s)) {
			if (dao.findByEmail(s).size() > 0) {
				return true;
			}
		}
		return false;
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
		List<User> users=new ArrayList<User>();
		try {
			List<Wait> waits=new ArrayList<Wait>(u.getWaitsForReceiverId());
			for(int i=0;i<waits.size();i++){
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
			List<Friend> left=new ArrayList<Friend>(u.getFriendsForUserId());
			List<Friend> right=new ArrayList<Friend>(u.getFriendsForOtherId());
			List<Friend> friends=new ArrayList<Friend>();
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
				users.add(list.get(i).getUserByUserId());
			}
			return users;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * get user's image
	 * @param id
	 * @return blob
	 */
	public Blob getImage(int id){
		User u=null;
		try{
			u=dao.findById(id);
			return u.getImage();
		}catch(Exception e){
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
}
