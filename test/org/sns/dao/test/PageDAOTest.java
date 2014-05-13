package org.sns.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sns.dao.PageDAO;
import org.sns.dao.UserDAO;
import org.sns.model.Page;
import org.sns.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PageDAOTest {

	@Test
	public void savetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO dao = UserDAO.getFromApplicationContext(ctx);
		PageDAO pageDao =PageDAO.getFromApplicationContext(ctx);
		User u=dao.findById(1);
		Page page=new Page(u,"Java","This is a java page",null);
		pageDao.save(page);
		System.out.println("saved");
		System.out.println("id: " + page.getPageId());
	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO dao = UserDAO.getFromApplicationContext(ctx);
		PageDAO pageDao =PageDAO.getFromApplicationContext(ctx);
		List list =pageDao.findAll();
		for (int i = 0; i < list.size(); i++) {
			Page page=(Page)list.get(i);
			List users =new ArrayList(page.getMarks());
			for(int j=0;j<users.size();j++){
				User user =	(User)users.get(j);
				System.out.println(user.getUsername());
			}
		}
	}

}
