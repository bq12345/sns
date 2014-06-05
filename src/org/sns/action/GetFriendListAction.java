package org.sns.action;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.sns.model.User;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-30 下午12:59:27
 * 获取好友列表，所有的好友，在线好友
 */
public class GetFriendListAction implements Action {
	/**
	 * 
	 */
	
	private UserService userService;
	private List<User> list;
	private List<User> result;
	private short state;

	
	@Override
	public String execute() throws Exception {
		if (SessionManager.isOnLine()) {
			User currentUser=SessionManager.getUser();
			list=userService.getFriendUsers(currentUser);
			result=new ArrayList<User>();
			if (list.isEmpty()) {//如果好友为空
				return Action.SUCCESS;
			}
			if(state==1){//获取在线
				for(User u:list){
					if (u.getState()==1) {
						result.add(u);
					}
				}
			}else {//全部好友
				result=list;
			}
			
			
			return Action.SUCCESS;
		}else {
			System.out.println("用户离线状态，返回登录界面");
			return Action.LOGIN;
		}
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public short getState() {
		return state;
	}
	public void setState(short state) {
		this.state = state;
	}
	public List<User> getResult() {
		return result;
	}
	public void setResult(List<User> result) {
		this.result = result;
	}



	

}
