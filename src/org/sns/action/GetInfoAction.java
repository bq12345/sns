package org.sns.action;



import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.sns.model.User;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-1 下午3:27:35
 * 获取自己的信息
 */
public class GetInfoAction implements Action {
	private User currentUser;
	private List<User> result;
	@Override
	public String execute() throws Exception {
		if(SessionManager.isOnLine()){
			currentUser=SessionManager.getUser();
			result=new ArrayList<User>();
			result.add(currentUser);
			return Action.SUCCESS;
		}else{		
		return Action.LOGIN;
	}
	}
	public List<User> getResult() {
		return result;
	}
	public void setResult(List<User> result) {
		this.result = result;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
