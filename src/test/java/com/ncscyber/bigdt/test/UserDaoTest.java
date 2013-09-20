package com.ncscyber.bigdt.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pl.mytest.dao.UserDao;


public class UserDaoTest {
	private ClassPathXmlApplicationContext context;
	private UserDao userDao;
	
	 @Before
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao)context.getBean("userDao");
	}
	 
 
	//INSERT INTO USER_INFO VALUES(1,'admin','123','1986-11-24',1,20);
	@Test
	public void testGetOneUser(){
		System.out.println("qerqwer24234324234234232");
		SqlSessionFactory sqlSessionFactory =(SqlSessionFactory)context.getBean("sqlSessionFactory");
	       SqlSession session = sqlSessionFactory.openSession();
	       session.getConfiguration().addMapper(UserDao.class);
		System.out.println(userDao.getUser(1l).getName()+"---");
	}
	 
}
