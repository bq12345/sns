package org.sns.service;

import org.sns.dao.MessageDAO;
import org.sns.model.Message;
import org.sns.model.User;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class MessageService {
	private MessageDAO dao;
	private FriendService service;

	public FriendService getService() {
		return service;
	}

	public void setService(FriendService service) {
		this.service = service;
	}

	public MessageDAO getDao() {
		return dao;
	}

	public void setDao(MessageDAO dao) {
		this.dao = dao;
	}

	/**
	 * send a friend
	 * @param u
	 * @param other
	 * @return boolean
	 */
	public boolean sendMsg(User u,User other,Message m) {
		if (!(service.isFriend(u, other))) {
			return false;
		} else {
			try {
				dao.save(m);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
