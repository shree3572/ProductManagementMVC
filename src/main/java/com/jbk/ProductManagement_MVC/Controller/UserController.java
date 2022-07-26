package com.jbk.ProductManagement_MVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.ProductManagement_MVC.Entity.User;
import com.jbk.ProductManagement_MVC.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
@PostMapping(value="/addUser")
public String addUser(@ModelAttribute User user,Model model)
{
     boolean isAdded=service.addUser(user);
     if(isAdded)
     {
    	model.addAttribute("msg", "User Added Sucessfully");
    	return "addUser";
     }
     else {
    	 model.addAttribute("msg", "User not Added...!!! ");
    	 return "addUser";
     }
	
}

@GetMapping(value="/userList")
public String userList(Model model)
{
	List<User> list=service.userList();
	for (User user : list) {
		System.out.println(user);
	}
	model.addAttribute("users", list);
	return "userList";
}

@RequestMapping(value="/profile")
public String profile(@RequestParam String username,Model model)
{
	User user=service.getUserByName(username);
	System.out.println(user);
	model.addAttribute("user", user);
	return "profile";
}

}
