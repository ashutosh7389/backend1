package com.shop.backend1.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;


@Repository("productDAOImpl")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProduct(Product product) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	public List<Product> getallproducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		List<Product> products=query.list();
		return products;
	}

	public Product getproductbyid(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product) session.get(Product.class, id);
		return product;
	}
	public void deleteproduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(product);
		
	}
	public void deleteproducts(int id) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(id);
		
	}
	public List<Category> getallcategories() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}
	public void savecategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
	}

	public void deleteproduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		session.delete(product);
		tx.commit();
		session.close();
	}

	
}
