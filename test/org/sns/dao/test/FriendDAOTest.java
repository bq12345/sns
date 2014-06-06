package org.sns.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sns.dao.FriendDAO;
import org.sns.dao.UserDAO;
import org.sns.dao.WaitDAO;
import org.sns.model.Friend;
import org.sns.model.User;
import org.sns.model.Wait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FriendDAOTest {

	@Test
	public void starttest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FriendDAO dao = FriendDAO.getFromApplicationContext(ctx);
		UserDAO userDao = UserDAO.getFromApplicationContext(ctx);
		WaitDAO waitDao = WaitDAO.getFromApplicationContext(ctx);
		User user = userDao.findById(1);
		User u2 = userDao.findById(2);
		System.err.println(u2.getUsername() + " want to make friend with "
				+ user.getUsername());
		Wait wait = new Wait(user, u2);
		waitDao.save(wait);
		System.out.println("send request");
		System.out.println("id: " + user.getUserId());
	}

	@Test
	public void agreetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FriendDAO dao = FriendDAO.getFromApplicationContext(ctx);
		UserDAO userDao = UserDAO.getFromApplicationContext(ctx);
		WaitDAO waitDao = WaitDAO.getFromApplicationContext(ctx);
		User user = userDao.findById(1);
		List list = waitDao.findByProperty("userByReceiverId", user);
		System.out.println(user.getUsername() + "have the lists to check");
		for (int i = 0; i < list.size(); i++) {
			Wait wait = (Wait) list.get(i);
			// delete the wait relationship
			waitDao.delete(wait);
			User u = wait.getUserBySenderId();
			// add friends
			Friend friend = new Friend(user, u);
			System.out.println(user.getUsername() + "We have be friends"
					+ u.getUsername());
			dao.save(friend);
		}
	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDao = UserDAO.getFromApplicationContext(ctx);
		FriendDAO dao = FriendDAO.getFromApplicationContext(ctx);
		User user = userDao.findById(1);
		List list = new ArrayList(user.getFriendsForUserId());
		for (int i = 0; i < list.size(); i++) {
			Friend friend = (Friend) list.get(i);
			System.out.println(friend.getUserByUserId().getUsername());
		}
	}

	@Test
	public void wanttest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO udao = UserDAO.getFromApplicationContext(ctx);
		WaitDAO dao = WaitDAO.getFromApplicationContext(ctx);
		List<Wait> list = dao.findByExample(new Wait(udao.findById(1), udao
				.findById(5)));
		System.out.println(list.size());
	}

}
