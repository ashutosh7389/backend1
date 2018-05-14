package com.shop.backend1;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

public class CartTestCase {

	static CartDAO cartDao;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.shop");
		context.refresh();
		cartDao = (CartDAO) context.getBean("cartImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void addToCartTest() {
		Cart cart = new Cart();
		cart.setPrice(8);
		cart.setProductName("Chair");
		cart.setPrice(300);
		cart.setQuantity(6);
		cart.setUser("ashutosh");
		cartDao.saveCart(cart);
		System.out.println("Added to the Cart");
	}

	// Deleting TestCase
	@Ignore
	@Test
	public void removecartitemTest() {
		cartDao.removecartitem(1);
		System.out.println("The Cart Deleted");
	}

	// Displaying TestCase
	@Ignore
	@Test
	public void getCartItemsTest() {

		List<Cart> list = cartDao.getCartbyusername("Leanne");
		for (Cart cart : list) {
			System.out.println("CartID :" + cart.getCartId());
			System.out.println("Product :" + cart.getProductName());
			System.out.println("Price :" + cart.getPrice());
			System.out.println("Quantity : " + cart.getQuantity());
		}
		System.out.println("Cart item Displayed:");
	}

}