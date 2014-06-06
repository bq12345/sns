package org.sns.action;

import org.sns.model.User;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-26 下午11:12:09
 * 处理登陆的action
 */
public class LoginAction  implements Action{
	private String input;
	private String password;
	private UserService userService;
	@Override
	public String execute() throws Exception {
		System.out.println("正在登陆。。。"+input);
		User currentUser=userService.existUser(input);
		if (null!=currentUser) {
			if (currentUser.getPassword().equals(password)) {
				SessionManager.add(currentUser);   //添加到会话
				currentUser.setState((short)1);    //设置状态为在线
				System.out.println("密码验证成功，登陆中。。。"+SessionManager.getUser().getUsername());
				return Action.SUCCESS;
			}else {
				System.out.println("密码错误");
				return Action.LOGIN;
			}
			
		}
		System.out.println("没有该用户 "+input);
		
		return Action.LOGIN;
		
	
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input= input;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
