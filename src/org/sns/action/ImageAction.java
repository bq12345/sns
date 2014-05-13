package org.sns.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.sns.service.UserService;

/**
 * @author bq
 * @version 1.0
 */
public class ImageAction implements Action {

	private int id;
	private UserService userService;

	public InputStream getImage() throws SQLException, IOException {
		Blob image = userService.getImage(id);
		BufferedInputStream ins = new BufferedInputStream(
				image.getBinaryStream());
		int count = (int) image.length();
		byte[] bt = new byte[count];
		ins.read(bt, 0, count);
		return new ByteArrayInputStream(bt);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
