package com.shop.backend1.dao;

import java.util.List;

import com.shop.backend1.model.Category;
import com.shop.backend1.model.Product;

public interface ProductDAO {
	public void saveProduct(Product product);

	List<Product> getallproducts();

	Product getproductbyid(int id);

	void deleteproduct(int id);

	List<Category> getallcategories();

	void savecategory(Category category);

}
