package com.shop.backend1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class SupplierTestCase {

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.shop");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierImpl");
	
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Supplier Dude");
		supplier.setSupplierContact(72329385);
		supplierDAO.saveSupplier(supplier);
		System.out.println("Added new Supplier");
	}

}