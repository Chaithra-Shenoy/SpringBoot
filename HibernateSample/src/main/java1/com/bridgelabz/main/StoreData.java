package com.bridgelabz.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StoreData {
	public static void main(String[] args) {
		try {
			Configuration configure = new Configuration();
			configure.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configure.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Employee emp = new Employee(3,"Priya","Chitta","8975465986");
			
		 

			session.save(emp);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
