package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement_MVC.Entity.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
   @Autowired
   SessionFactory sf;
	
	@Override
	public boolean addProduct(Product product) {
		Session session=sf.openSession();
		Transaction transction=session.beginTransaction();
		try {
			session.save(product);
			transction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> productList() {
		 Session session=sf.openSession();
		 List<Product> list=null;
		try {
			list=session.createCriteria(Product.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return list;
	}
	

}
