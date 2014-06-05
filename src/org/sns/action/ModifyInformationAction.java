package org.sns.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.sns.model.User;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-1 下午2:26:33 修改用户的信息
 */
public class ModifyInformationAction implements Action {
	private String username;
	private short sex;
	private String qq;
	private UserService userService;

	@Override
	public String execute() throws Exception {

		if (SessionManager.isOnLine()) {
			User currentUser = SessionManager.getUser();
			currentUser.setUsername(username);
			currentUser.setSex(sex);
			currentUser.setQq(qq);
			return Action.SUCCESS;
		} else {
			return Action.LOGIN;
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}