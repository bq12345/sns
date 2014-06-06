package org.sns.service;

import java.util.List;

import org.sns.dao.CommentDAO;
import org.sns.model.Comment;
import org.sns.model.Thing;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class CommentService {
	private CommentDAO dao;
	
	public CommentDAO getDao() {
		return dao;
	}
	public void setDao(CommentDAO dao) {
		this.dao = dao;
	}
	/**
	 * add a new comment
	 * @param comment
	 * @return
	 */
	public boolean addComment(Comment comment){
		try {
			dao.save(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**get a things comments
	 * @param t
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List getComments(Thing t){
		List list=null;
		try{
			list=dao.findByProperty("thing", t);
			return list;
		}catch(Exception e){
			return null;
		}
	}
}
