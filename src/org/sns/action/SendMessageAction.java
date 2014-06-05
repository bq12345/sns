package org.sns.action;

import java.sql.Timestamp;
import java.util.Date;

import org.sns.model.Message;
import org.sns.model.User;
import org.sns.service.MessageService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-29 下午11:43:35 留言
 */
public class SendMessageAction implements Action {
	private MessageService messageService;
	private UserService userService;
	private int id;
	private String content;
	private String sender;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 判断是否在线
		if (SessionManager.isOnLine()) {
			User currentUser = SessionManager.getUser();
			User stranger = userService.getUser(id);
			Message message = new Message();
			message.setContent(content);
			message.setRead((short) 0);
			message.setSender(sender);
			message.setTime(new Timestamp(new Date().getTime()));
			message.setUserByReceiverId(stranger);
			message.setUserBySenderId(currentUser);
			messageService.sendMsg(currentUser, stranger, message);
			return Action.SUCCESS;

		} else {
			return Action.LOGIN;
		}

	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
