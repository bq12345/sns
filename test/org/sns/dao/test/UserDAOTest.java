package org.sns.dao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.sns.dao.UserDAO;
import org.sns.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAOTest {

	@Test
	public void savetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO dao = UserDAO.getFromApplicationContext(ctx);
		User user = new User();
		user.setUsername("bq");
		user.setPassword("00000");
		user.setPhone("18740414439");
		user.setAble((short) 0);
		user.setEmail("bq@bq.com");
		InputStream is;
		Blob blob = null;
		try {
			is = new FileInputStream(new File("d:/p.jpg"));
			blob=Hibernate.createBlob(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setImage(blob);
		dao.save(user);
		dao.getHibernateTemplate().flush();
		dao.getSessionFactory().close();
		System.out.println("saved");
		System.out.println("id: " + user.getUserId());
	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO dao = UserDAO.getFromApplicationContext(ctx);
		User user = new User();
		List list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((User) list.get(i)).getThings().size());
		}
	}

}
