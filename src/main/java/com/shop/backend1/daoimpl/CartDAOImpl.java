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


@Repository("cartDAOImpl")
@Transactional 
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	public List<Cart> getCartbyusername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		return query.list();
	}

	public void removecartitem(int cartitemid) {
		Session session = sessionFactory.getCurrentSession();
		Cart cartitem = (Cart) session.get(Cart.class, cartitemid);
		Product product = cartitem.getProducts();
		product.setStock(product.getStock() + cartitem.getQuantity());
		session.delete(cartitem);

	}

	public void removeallcartitem(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		List<Cart> cartitems = query.list();
		for (Cart cartitem : cartitems) {
			Product product = cartitem.getProducts();
			product.setStock(product.getStock() + cartitem.getQuantity());
			session.delete(cartitem);
		}

	}

	public void aftercheckout(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		List<Cart> cartitems = query.list();
		for (Cart cartitem : cartitems)
			session.delete(cartitem);
	}

}
