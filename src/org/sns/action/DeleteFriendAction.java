package org.sns.action;

import org.sns.model.User;
import org.sns.service.FriendService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-1 下午1:15:29
 * 删除好友
 */
public class DeleteFriendAction implements Action {
	private int id;  //要删除的好友id
	private FriendService friendService;
	private UserService userService;
	
	
	@Override
	public String execute() throws Exception {
		if(SessionManager.isOnLine()){
			User currentUser=SessionManager.getUser();
			User friend=userService.getUser(id);
			System.out.println(currentUser.getUsername()+"即将删除好友"+friend.getUsername());
			if(friendService.deleteFriend(currentUser, friend)){
				System.out.println("好友删除成功");
				return SUCCESS;
			}else {
				System.out.println("好友删除失败");
				return Action.NONE;
			}
		}else {
			return Action.LOGIN;
		}

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public FriendService getFriendService() {
		return friendService;
	}


	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
