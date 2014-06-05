package org.sns.action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.sns.model.Thing;
import org.sns.model.User;
import org.sns.service.ThingService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-29 下午11:34:12
 * 获取朋友新鲜事
 */
public class GetFriendsThingsAction implements Action{
	private ThingService thingService;
	private UserService userService;
	private List<Thing> result;
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		//判断是否在线
		if (SessionManager.isOnLine()) {
			User currentUser=SessionManager.getUser();
			System.out.println("当前用户+"+currentUser.getUsername());
			result=thingService.getFriendThings(currentUser);
			return Action.SUCCESS;
		}else {
			System.out.println("用户离线");
				return Action.LOGIN;
		}
		

	}
	public ThingService getThingService() {
		return thingService;
	}
	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<Thing> getResult() {
		return result;
	}
	public void setResult(List<Thing> result) {
		this.result = result;
	}


}
