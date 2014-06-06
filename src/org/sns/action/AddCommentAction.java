package org.sns.action;

import java.sql.Timestamp;
import java.util.Date;

import org.sns.model.Comment;
import org.sns.model.Thing;
import org.sns.model.User;
import org.sns.service.CommentService;
import org.sns.service.ThingService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-1 下午3:03:13 添加评论
 */
public class AddCommentAction implements Action {
	private String content;// 回复的内容
	private int id; // 新鲜事的id
	private CommentService commentService;
	private ThingService thingService;

	@Override
	public String execute() throws Exception {
		if (SessionManager.isOnLine()) {
			User currentUser = SessionManager.getUser();
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setTime(new Timestamp(new Date().getTime()));
			comment.setUser(currentUser);
			comment.setSender(currentUser.getUsername());
			Thing thing = thingService.getThing(id);
			comment.setThing(thing);
			commentService.addComment(comment);
			System.out.println("添加评论成功");
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public ThingService getThingService() {
		return thingService;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

}
