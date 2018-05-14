package com.shop.backend1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;


public class UserTestCase {

	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.shop");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveUserTest() {
		System.out.println("Test to add");
		User user = new User();
		user.setUserName("Henry");
		user.setEmail("henry@gmail.com");
		user.setPassword("henry123");
		user.setAddress("China Town");
		user.setContact(920227);
		userDAO.saveUser(user);
		System.out.println("User Inserted");
	}

}