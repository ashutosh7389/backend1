package com.shop.backend1;

import java.util.List;

import org.hibernate.criterion.Order;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

public class order {

	static OrderDAO OrderDao;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.shop");
		context.refresh();
		OrderDao = (OrderDAO) context.getBean("OrderDAOImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void addToOrderTest() {
		CustomerOrder order = new CustomerOrder();
		order.setOrderId(5);
		order.setUser("ashutosh");
		OrderDao.saveOrder(order);
		System.out.println("Added to the Cart");
	}

	// Deleting TestCase
	@Ignore
	@Test
	public void removeorderitemTest() {
		OrderDao.removeallorderitem(1);
		System.out.println("The Cart Deleted");
	}

}