package com.jbk.ProductManagement_MVC.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product {
	@Id
	private String prodId;
	private String prodName;
	private double prodPrice;
	private String prodExpDate;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String prodId, String prodName, double prodPrice, String prodExpDate) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodExpDate = prodExpDate;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdExpDate() {
		return prodExpDate;
	}
	public void setProdExpDate(String prodExpDate) {
		this.prodExpDate = prodExpDate;
	}
	
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodExpDate="
				+ prodExpDate + "]";
	}
	
	

}
