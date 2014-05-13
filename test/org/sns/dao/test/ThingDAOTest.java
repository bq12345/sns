package org.sns.dao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.sns.dao.ThingDAO;
import org.sns.dao.UserDAO;
import org.sns.model.Thing;
import org.sns.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ThingDAOTest {

	@Test
	public void savetest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ThingDAO dao = (ThingDAO) ctx.getBean("ThingDAO");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		UserDAO userDao=(UserDAO) ctx.getBean("UserDAO");
		User user=userDao.findById(1);
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
		Thing thing = new Thing(user,"哈哈哈哈", Timestamp.valueOf(date), 0, 0, blob,(short)0,null);
		dao.save(thing);
		dao.getHibernateTemplate().flush();
		dao.getSessionFactory().close();
		System.out.println("saved");
		System.out.println("id: " + thing.getThingId());

	}

	@Test
	public void querytest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ThingDAO dao = ThingDAO.getFromApplicationContext(ctx);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		UserDAO userDao=(UserDAO) ctx.getBean("UserDAO");
		
	
	}

}
