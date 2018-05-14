package com.shop.backend1.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

@Repository("userDAOImpl")
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveUser(User user) {
		Session session= sessionFactory.getCurrentSession();
//		Role role=new Role();
//		role.setRole("ROLE_USER");
//		role.setUserName(user.getUserName());
//		session.saveOrUpdate(role);
//		ShippingAddress shippingAddress=new ShippingAddress();
//		shippingAddress.setUserName(user.getUserName());
//		shippingAddress.setShippingAddress(user.getAddress());
//		shippingAddress.setZipcode(user.getZipcode());
//		shippingAddress.setContact(user.getContact());
//		session.saveOrUpdate(shippingAddress);
//		session.saveOrUpdate(user);
	}
	
}
