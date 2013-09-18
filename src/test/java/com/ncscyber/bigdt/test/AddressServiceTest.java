package com.ncscyber.bigdt.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pl.mytest.entity.Address;
import com.pl.mytest.entity.User;
import com.pl.mytest.service.AddressService;


public class AddressServiceTest {
	private ClassPathXmlApplicationContext context;
	private AddressService addressService;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/applicationContext.xml");
		addressService = (AddressService)context.getBean("addressService");
	}
	
	@Test
	public void insertAddress(){
		Address addr = new Address();
		User u = new User();
		u.setUid(1L);
		addr.setAddress("beijing");
		addr.setPostCode("100000");
//		addr.setAid(100L);
		addr.setUser(u);
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("address", addr);
//		map.put("uid", 1L);
		System.out.println(111);
		addressService.insertAddress(addr);
		System.out.println(addr.getAid());
	}
}









