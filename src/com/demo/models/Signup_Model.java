package com.demo.models;

import java.sql.Statement;

import org.hibernate.Session;

import com.demo.pojo.User;

public class Signup_Model {
	
	public String doSignUp(String username, String password, String gender, String vehicle, String country, String image){
		try{
			Database_Connectivity dc = new Database_Connectivity();
			Statement statement = dc.do_db_connect();
			
			statement.execute("insert into user values('" +username+ "','" +password+ "','" +gender+ "','" +vehicle+ "','" +country+ "','" +image+ "')");
			return "Sing Up successful!";
		}
		catch(Exception e){
			System.out.println(e);
			return "Something went wrong, please try again!";
		}
	}
	
	public String doHibernateSignUp(User user){
		System.out.println("Inside doHibernateSignup method");
		try{
			Session session = HibernateConnection.doHibernateConnection().openSession();
			System.out.println("Session created");
			session.beginTransaction();
			session.saveOrUpdate(user);
			
			session.getTransaction().commit();
			session.close();
			return "Signup successful";
		}
		catch(Exception e){
			e.printStackTrace();
			return "There is a record with this user already.";
		}
	}

}
