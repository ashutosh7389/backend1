package com.shop.backend1.dao;

import java.util.List;

import com.shop.backend1.model.*;

public interface CartDAO {
	public void saveCart(Cart cart);

	public List<Cart> getCartbyusername(String username);
	void removecartitem(int cartitemid);
	void removeallcartitem(String username);
	void aftercheckout(String username);
}

