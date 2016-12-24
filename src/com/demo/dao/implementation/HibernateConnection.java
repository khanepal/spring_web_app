package com.demo.dao.implementation;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.demo.pojo.Products;
import com.demo.pojo.User;

public class HibernateConnection {
	
	public static SessionFactory sessionFactory;
	
	public static SessionFactory doHibernateConnection(){
		System.out.println("Inside doHibernateConnection() method");
		Properties database = new Properties();
		System.out.println("Properties instantiated");
		database.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "krishna");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/spring");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		System.out.println("All the properties are set");
		Configuration cfg = new Configuration()
				.setProperties(database)
				.addPackage("com.demo.pojo")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Products.class);
		System.out.println("Configuration created");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		System.out.println("StandardServiceRegistryBuilder created");
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		System.out.println("sessionFactory built");
		
		return sessionFactory;
	}

}
