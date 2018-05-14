package com.shop.backend1.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

@Repository("orderDAOImpl")
@Transactional
public abstract class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);

	}
	
	public CustomerOrder list(String username) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CustomerOrder where user = ?");
		query.setString(0, username);
		return (CustomerOrder) query.uniqueResult();
	
	}



	public void removeallorderitem(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CustomerOrder where user=?");
		query.setString(0, username);
		CustomerOrder order=(CustomerOrder) query.uniqueResult();
			session.delete(order);
		
	}

}
