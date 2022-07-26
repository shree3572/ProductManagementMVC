package com.jbk.ProductManagement_MVC.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.ProductManagement_MVC.Entity.User;
import com.jbk.ProductManagement_MVC.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User loginUser(User user) {
		User userObj=dao.loginUser(user);
		return userObj;
	}

	@Override
	public boolean addUser(User user)  {
		/*
		 This is mail sending testing code

		*/
		 
		 String message="Welcome "+user.getUsername()+" in Product Management System"+'\n'+" Your login details as follows "+'\n'+
		                " User id :"+user.getUsername()+'\n'+" User password :"+user.getPassword();
		 String subject="Login Confirmation";
		 String to="pawars3572@gmail.com";
		 String from="techshree9@gmail.com";
		 
		sendEmail(message,subject,to,from);
		
		return dao.addUser(user);
	}
	
	 public void sendEmail(String message,String subject,String to,String from) 
	 {
		 String host="smtp.gmail.com";
		 Properties properties=System.getProperties();
		 System.out.println("Properties"+properties);
		 properties.put("mail.smtp.host", host);
		 properties.put("mail.smtp.port", "465");
		 properties.put("mail.smtp.ssl.enable","true");
		 properties.put("mail.smtp.auth", "true");
		 
		 Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("techshree9@gmail.com", "kyjkyiczqqrabdzp");
			}
			 });
		 
		 session.setDebug(true);
		
		 MimeMessage m= new MimeMessage(session);
		try { 
		 m.setFrom(from);
		 m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 m.setSubject(subject);
		 m.setText(message);
		 Transport.send(m); 
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		
		 
		 
		 
	 }

	@Override
	public List<User> userList() {
		
		return dao.userList();
	}

	@Override
	public User getUserByName(String username) {
		
		return dao.getUserByName(username);
	}

}
