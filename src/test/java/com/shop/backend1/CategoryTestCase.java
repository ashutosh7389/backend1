package com.shop.backend1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;


public class CategoryTestCase {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.shop");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryImpl");

	}

	// Insertion TestCase
	@Ignore
	@Test
	public void saveCategoryTest() {
		Category category = new Category();
		category.setCategoryName("TestCategory");
		category.setDescription("Category Description");
		categoryDAO.saveCategory(category);
		System.out.println("Category Inserted");
	}

	// Retrieval TestCase
	@Ignore
	@Test
	public void getCategoryByIdTest() {
		Category category = categoryDAO.getById(2);
		System.out.println("Category Name:" + category.getCategoryName());
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteCategoryByIdTest() {
		categoryDAO.getById(1);
		System.out.println("The Category Deleted");
	}

	// Retrieving the Data
	@Ignore
	@Test
	public void listCategoryTest() {
		List<Category> list = categoryDAO.list();
		for (Category category : list) {
			System.out.println(category.getCategoryName());
		}
	}
}
