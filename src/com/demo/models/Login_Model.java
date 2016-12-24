package com.demo.models;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.pojo.User;

import java.sql.ResultSet;

public class Login_Model {
	
	public String do_login_process(String username, String password){
		try{
			Database_Connectivity dc = new Database_Connectivity();
			Statement statement = dc.do_db_connect();
			ResultSet rs = statement.executeQuery("select count(*) from user where username='"+username+"' and password='" +password+ "'");
			int count = 0;
			while(rs.next()){
				System.out.println("There are at least one record");
				count = rs.getInt(1);				
			}
			rs.close();
			System.out.println("Count = " +count);
			if(count == 1){
				return "login success";
			}
			else{
				return "login fail";
			}
		}
		catch(Exception e){
			return "Something went wrong. Please try again.";
		}
	}
	
	public String doHibernateLogin(String username, String password){
		try{
			System.out.println("Inside doHibernateLogin");
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			System.out.println("Got Hibernat Connection");
			Session session = sessionFactory.openSession();
			System.out.println("Session Opened");
			session.beginTransaction();
			System.out.println("Transaction Began");
			List<User> user = session.createQuery("From User where username='" +username+ "' and password='" +password+ "'").list();
			System.out.println("Fired Query");
			session.close();
			
			if(user.size() == 1){
				return "login success";
			}
			else{
				return "login failed";
			}
		}
		catch(Exception e){
			return "Please try again!";
		}
	}

}
