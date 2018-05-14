package com.shop.backend1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;


public class ProductTestCase {

	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productImpl");		
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveProductTest() {
		System.out.println("Test to add");
 		Product product = new Product();
		product.setProductName("Product");
		product.setPrice(500);
		product.setProductDescription("An item being sold");
		product.setCategory("ProductCategory");
		productDAO.saveProduct(product);
		System.out.println("Product Inserted");
	}

	// Retrieval TestCase
	@Ignore
	@Test
	public void getProductByIdTest() {
		Product product = productDAO.getproductbyid(7);
		System.out.println("Product Name:" + product.getProductName());
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteProductTest() {
		productDAO.deleteproduct(3);
		System.out.println("The Product Deleted");
	}

	// Retrieving the Data
	@Ignore
	@Test
	public void getAllProductsTest() {
		List<Product> list = productDAO.getallproducts();
		for (Product product : list) {
			System.out.print(product.getProductId() + ": ");
			System.out.println(product.getProductName());
		}
		System.out.println("Product Displayed");
	}

}