package org.sns.action;

import java.util.List;

import org.sns.model.Comment;
import org.sns.model.Message;
import org.sns.model.User;
import org.sns.service.CommentService;
import org.sns.service.ThingService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-31 上午10:48:47 获取留言
 */
public class GetCommentsAction implements Action {
	private ThingService thingService;
	private CommentService commentService;
	private List result;
	private int id;

	@Override
	public String execute() throws Exception {
		if (SessionManager.isOnLine()) {// 判断是否在线
			User currentUser = SessionManager.getUser();
			result = commentService.getComments(thingService.getThing(id));
			System.out.println("result : " + result.size());
			return Action.SUCCESS;
		} else {
			return Action.LOGIN;
		}
	}

	public ThingService getThingService() {
		return thingService;
	}

	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
