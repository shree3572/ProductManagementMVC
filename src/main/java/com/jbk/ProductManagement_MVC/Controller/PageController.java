package com.jbk.ProductManagement_MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping(value="/")
	public String loginPage()
	{
		return "Login";
	}
	
	@RequestMapping(value="/addUserPage")
	public String addUserPage()
	{
		return "addUser";
	}
	
	@RequestMapping(value="/addProductPage")
	public String addProduct()
	{
		return "addProduct";
	}
	
	
}
