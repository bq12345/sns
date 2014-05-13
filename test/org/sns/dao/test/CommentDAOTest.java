package org.sns.dao.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.sns.dao.CommentDAO;
import org.sns.dao.ThingDAO;
import org.sns.dao.UserDAO;
import org.sns.model.Comment;
import org.sns.model.Thing;
import org.sns.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommentDAOTest {

	@Test
	public void savetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CommentDAO dao = CommentDAO.getFromApplicationContext(ctx);
		UserDAO userDao = UserDAO.getFromApplicationContext(ctx);
		ThingDAO thingDao =ThingDAO.getFromApplicationContext(ctx);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		User u=userDao.findById(1);
		Thing t=thingDao.findById(1);
		Comment comment=new Comment(u,t, "我回复了", Timestamp.valueOf(date));
		dao.save(comment);
		System.out.println("saved");
		System.out.println("id: " + comment.getCommentId());
	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CommentDAO dao = CommentDAO.getFromApplicationContext(ctx);
		Comment comment=new Comment();
		List list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((Comment) list.get(i)).getContent());
		}
	}

}
