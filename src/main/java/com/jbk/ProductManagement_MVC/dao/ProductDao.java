package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import com.jbk.ProductManagement_MVC.Entity.Product;


public interface ProductDao {
	public boolean addProduct(Product product);

	public List<Product> productList();

}
