package com.jbk.ProductManagement_MVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement_MVC.Entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sf;

	public User loginUser(User user) {
		Session session = sf.openSession();
		User use = null;
		try {
			use = session.get(User.class, user.getUsername());
			if (use != null) {
				if (!use.getPassword().equals(user.getPassword()))

				{
					return null;
				}
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			session.close();
		}

		return use;
	}

	@Override
	public boolean addUser(User user) {
		Session session = sf.openSession();
		
		Transaction transction = session.beginTransaction();
		boolean isAdded = false;
		try {
			User use = session.get(User.class, user.getUsername());
			if (use == null) {
				session.save(user);
				transction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isAdded;
	}

	@Override
	public List<User> userList() {
		Session session=sf.openSession();
		List<User> list=null;
		try {
		 list=session.createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return list;
	}

	@Override
	public User getUserByName(String username) {
		Session session=sf.openSession();
		User user=null;
		try {
			 user=session.get(User.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}

}
