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
 * @version Creation Time：2014-5-26 下午10:03:05 注册处理action
 */
public class SignupAction implements Action {
	private String username;
	private String password;
	private String gender;
	private short sex;
	private String phone;
	private String qq;
	private String email;
	private File image;
	private String imageContentType;
	private String imageFileName;
	private UserService userService;

	@Override
	public String execute() throws Exception {
		// 判断是否已经有该用户,或者输入不合法都为false
		if (userService.canRegiste(email) && userService.canRegiste(phone)) {
			System.out.println("该手机和邮件可以注册" + phone + " " + email);
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			if (gender.equals("male")) {
				u.setSex((short) 0);
			} else {
				u.setSex((short) 1);
			}
			u.setQq(qq);
			u.setPhone(phone);
			u.setEmail(email);
			u.setState((short) 1);
			u.setAble((short) 0);
			InputStream is = new FileInputStream(image);
			Blob blob = Hibernate.createBlob(is);
			u.setImage(blob);
			userService.addUser(u);
			return Action.SUCCESS;
		} else {
			System.out.println("不能注册");
			return Action.NONE;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
