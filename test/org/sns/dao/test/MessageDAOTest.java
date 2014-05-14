package org.sns.dao.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.sns.dao.MessageDAO;
import org.sns.dao.UserDAO;
import org.sns.model.Message;
import org.sns.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageDAOTest {

	@Test
	public void savetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MessageDAO dao = MessageDAO.getFromApplicationContext(ctx);
		UserDAO userDao = UserDAO.getFromApplicationContext(ctx);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		User u=userDao.findById(1);
		User to=userDao.findById(2);
		Message  message=new Message(u, to, "这是一个测试", Timestamp.valueOf(date),(short)0);
		dao.save(message);
		System.out.println("saved");
		System.out.println("id: " + message.getMsgId());
	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MessageDAO dao = MessageDAO.getFromApplicationContext(ctx);
		Message message=new Message();
		message.setRead((short)0);
		List list = dao.findByExample(message);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((Message) list.get(i)).getContent());
		}
	}

}
