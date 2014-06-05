package org.sns.service;

import java.util.List;

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
	private UserService service;
	
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

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
		System.out.println("other user:  "+other.getUserId());
		List list=service.getFriendUsers(u);
		for(int i=0;i<list.size();i++){
			User user=(User)list.get(i);
			System.out.println("dangqianfriend:  "+user.getUserId());
			if(user.getUserId().intValue()==other.getUserId().intValue()){
				return true;
			}
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
				System.out.println("向friend表中准备写数据");
				dao.save(new Friend(u, other));
				//List waits=service.getWaits(u);
				
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
			System.out.println("即将从friend表中删除好友关系");
			try {
				Friend friend=new Friend(u,other);
				dao.delete(friend);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
