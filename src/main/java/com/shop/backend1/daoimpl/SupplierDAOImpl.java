package com.shop.backend1.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

@Repository("supplierDAOImpl")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveSupplier(Supplier supplier) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}

}
