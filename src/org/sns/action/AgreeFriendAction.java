package org.sns.action;

import org.sns.model.User;
import org.sns.service.FriendService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-29 下午10:21:24
 * 点击同意时，添加好友
 */
public class AgreeFriendAction implements Action{
	
	private UserService userService;
	private FriendService friendService;
	private int id;  //获取的用户id
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (SessionManager.isOnLine()) {//如果用户在线
			User currentUser=SessionManager.getUser();
			User stranger=userService.getUser(id);
			
			System.out.println("即将成为好友的两个用户"+currentUser.getUsername()+" "+stranger.getUsername());
			System.out.println(friendService.isFriend(currentUser, stranger));
			if (friendService.isFriend(currentUser, stranger)) {
				//已经是好友了
				return "isFriend";
			}else {
				System.out.println("正在记录好友关系");
				friendService.addFriend(currentUser, stranger);
				
				return Action.SUCCESS;
			}
		}else {
			//返回登录界面
			return Action.LOGIN;
		}
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
