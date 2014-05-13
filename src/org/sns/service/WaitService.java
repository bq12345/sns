package org.sns.service;

import org.sns.dao.WaitDAO;
import org.sns.model.User;
import org.sns.model.Wait;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class WaitService {
	private WaitDAO waitDAO;
	private FriendService service;

	public FriendService getService() {
		return service;
	}

	public void setService(FriendService service) {
		this.service = service;
	}

	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	/**
	 * want a friend
	 * 
	 * @param u
	 * @param other
	 * @return
	 */
	public boolean wantFriend(User u, User other) {
		if (service.isFriend(u, other)) {
			return false;
		} else {
			try {
				waitDAO.save(new Wait(u, other));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * u agree a friend other
	 * 
	 * @param u
	 * @param other
	 * @return
	 */
	public boolean agreeFriend(User u, User other) {
		try {
			service.addFriend(u, other);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
