package org.sns.action;

import org.sns.model.User;
import org.sns.service.FriendService;
import org.sns.service.UserService;
import org.sns.service.WaitService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-29 下午10:58:05
 * 请求添加好友
 */
public class WantFriendAction implements Action{
	private UserService userService;
	private FriendService friendService;
	private WaitService waitService;
	private int id;//陌生人的id
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//判断是否在线
		if (SessionManager.isOnLine()) {
			User currentUser=SessionManager.getUser();
			User stranger=userService.getUser(id);
			
			System.out.println(currentUser.getUsername()+"想要添加"+stranger.getUsername()+"为好友");
			System.out.println("首先判断他们是不是好友+"+friendService.isFriend(currentUser, stranger));
			
			//判断是否是好友
			if (friendService.isFriend(currentUser, stranger)) {
				return "isFriend";
			}else {
				waitService.wantFriend(currentUser, stranger);
				return Action.SUCCESS;
			}
			
			
			
		}
		//不在线返回登录界面
		System.out.println("用户离线");
		return Action.LOGIN;
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
	public WaitService getWaitService() {
		return waitService;
	}
	public void setWaitService(WaitService waitService) {
		this.waitService = waitService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
