package com.jbk.ProductManagement_MVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.ProductManagement_MVC.Entity.Product;
import com.jbk.ProductManagement_MVC.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
    @PostMapping(value="/addProduct")
    public String addProduct(@ModelAttribute Product product,Model model)
    {
       boolean isAdded=service.addProduct(product);
       if(isAdded)
       {
    	model.addAttribute("msg", "Product Added Sucessfully");
    	return "addProduct";
       }
       else {
    	 model.addAttribute("msg", "Product not Added...!!! ");
    	 return "addProduct";
     }

  }
    @GetMapping(value="/productList")
    public String productList(Model model)
    {
    	List<Product> list=service.productList();
    	for (Product product : list) {
			System.out.println(product);
		}
    	model.addAttribute("products", list);
    	return "productList";
    }
}