package org.sns.action;

import java.util.List;

import org.sns.model.Message;
import org.sns.model.User;
import org.sns.service.MessageService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-31 上午10:48:47
 * 获取留言
 */
public class GetMessagesAction implements Action {
	private UserService userService;
	private List<Message> result;
	@Override
	public String execute() throws Exception {
	System.out.println("尝试获取留言");
	if (SessionManager.isOnLine()) {//判断是否在线
		User currentUser=SessionManager.getUser();
		result=userService.getMsgs(currentUser);
		System.out.println("result : "+result.size());
		return Action.SUCCESS;
	}else {
		return Action.LOGIN;
	}

		
		
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<Message> getResult() {
		return result;
	}
	public void setResult(List<Message> result) {
		this.result = result;
	}

}
