package com.jbk.ProductManagement_MVC.service;

import java.util.List;

import com.jbk.ProductManagement_MVC.Entity.Product;

public interface ProductService {
	
	public boolean addProduct(Product product);
	public List<Product> productList();
}
