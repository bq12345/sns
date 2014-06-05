package org.sns.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Hibernate;
import org.sns.model.Thing;
import org.sns.model.User;
import org.sns.service.ThingService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-27 上午1:07:26 发布新鲜事，包括状态，博客，图片
 */
public class AddThingAction implements Action {
	private String content; // 内容
	private Short type; // 类型 0 状态 1 博客 2 图片
	private File image; // 图片
	private ThingService thingService;

	@Override
	public String execute() throws Exception {
		System.out.println("准备发布新鲜事   " + content + " " + type + " ");

		if (SessionManager.isOnLine()) {
			User currentUser = SessionManager.getUser();
			// 初始化一个新鲜事实例
			Thing thing = new Thing();
			thing.setCommentNum(0);
			thing.setShareNum(0);
			thing.setType(type);
			thing.setSender(currentUser.getUsername());
			thing.setTime(new Timestamp(new Date().getTime()));
			thing.setUser(currentUser);
			System.out.println("准备上传图片");
			InputStream is = new FileInputStream(image);
			Blob blob = Hibernate.createBlob(is);
			System.out.println("设置图片中。。。");
			thing.setImage(blob);
			thing.setContent(content);
			thingService.addThing(thing);
			System.out.println("发布成功");
			return Action.SUCCESS;
		} else {
			return Action.LOGIN;
		}

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public ThingService getThingService() {
		return thingService;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

}
