package com.shop.backend1.dao;

import java.util.List;


import com.shop.backend1.model.*;



public interface CategoryDAO {
	public void saveCategory(Category category);
	public void delete(int categoryId);
	public Category getById(int categoryId);
	public List<Category> list();
}
