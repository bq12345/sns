package org.sns.action;

import java.util.List;

import org.sns.model.User;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * Search users
 * 
 * @author 白强
 */
public class SearchAction implements Action {
	private String name;
	private UserService userService;
	private List<User> result;

	@Override
	public String execute() throws Exception {

		if (SessionManager.isOnLine()) {
			System.out.println("传来的信息  " + name);
			result = userService.findByName(name);
			return Action.SUCCESS;
		} else {
			return Action.LOGIN;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getResult() {
		return result;
	}

	public void setResult(List<User> result) {
		this.result = result;
	}

}