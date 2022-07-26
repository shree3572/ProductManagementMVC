package com.jbk.ProductManagement_MVC.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement_MVC.Entity.Product;
import com.jbk.ProductManagement_MVC.dao.ProductDao;
@Service
public class ProdServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	@Override
	public boolean addProduct(Product product) {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = date.format(new Date());
	    product.setProdId(timeStamp);
		return dao.addProduct(product);
	}
	
	@Override
	public List<Product> productList() {
		// TODO Auto-generated method stub
		return dao.productList();
	}

}
