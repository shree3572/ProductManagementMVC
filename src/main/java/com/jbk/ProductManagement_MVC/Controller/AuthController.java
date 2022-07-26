package com.jbk.ProductManagement_MVC.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jbk.ProductManagement_MVC.Entity.User;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class AuthController {
	@Autowired
	UserService service;

	@GetMapping(value="/login")
	public String login(@ModelAttribute User user,Model model,HttpSession session)
	{
		User user1=service.loginUser(user);
		if(user1!=null)
		{
			session.setAttribute("username",user.getUsername());
			return "home";
		}
		else {
			model.addAttribute("msg", "Invalid Credentials...!!!");
			return "Login";
		}
	}
}
