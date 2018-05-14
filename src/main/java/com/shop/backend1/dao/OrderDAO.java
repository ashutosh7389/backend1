package com.shop.backend1.dao;

import java.util.List;



import com.shop.backend1.model.*;


public interface OrderDAO {

	public CustomerOrder list(String username);
	public void saveOrder(CustomerOrder order);
	void removeallorderitem(int i);
	
}
