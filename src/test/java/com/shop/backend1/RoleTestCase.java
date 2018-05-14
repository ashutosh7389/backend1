//package com.shop.backend1;
//
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import com.shop.backend1.daoimpl.*;
//import com.shop.backend1.dao.*;
//import com.shop.backend1.model.*;
//
//public class RoleTestCase {
//
//	static RoleDAO roleDAO;
//
//	@BeforeClass
//	public static void executFirst() {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//		context.scan("com.shop");
//		context.refresh();
//		roleDAO = (RoleDAO) context.getBean("RoleDAOImpl");
//	}
//
//	// Adding TestCase
//	@Ignore
//	@Test
//	public void addToCartTest() {
//		Role role = new Role();
//		role.setUserName("True Color Lipstick Lava Love");
//		role.setRole("Bold,vivid color infused with vitamin E, Shea Butter and Omega 3.");
//		role.setRoleId(1);
//		roleDAO.saveOrUpdate(role);
//
//	}
//
//}