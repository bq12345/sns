package org.sns.service;

import org.sns.dao.FriendDAO;
import org.sns.dao.WaitDAO;
import org.sns.model.Friend;
import org.sns.model.User;
import org.sns.model.Wait;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class FriendService {
	private FriendDAO dao;
	private WaitDAO waitDAO;

	public FriendDAO getDao() {
		return dao;
	}

	public void setDao(FriendDAO dao) {
		this.dao = dao;
	}

	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	/**
	 * if other is u's friend
	 * @param u
	 * @param other
	 * @return boolean
	 */
	public boolean isFriend(User u, User other) {
		Friend f1 = new Friend(u, other);
		Friend f2 = new Friend(other, u);
		if (dao.findByExample(f1).size() > 0) {
			return true;
		}
		if (dao.findByExample(f2).size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * add a friend
	 * 
	 * @param u
	 * @param other
	 * @return
	 */
	public boolean addFriend(User u, User other) {
		if (isFriend(u, other)) {
			return false;
		} else {
			try {
				dao.save(new Friend(u, other));
				waitDAO.delete(new Wait(u, other));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	/**
	 * delete a friend
	 * @param u
	 * @param other
	 * @return boolean
	 */
	public boolean deleteFriend(User u, User other) {
		if (!isFriend(u, other)) {
			return false;
		} else {
			try {
				dao.delete(new Friend(u, other));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
