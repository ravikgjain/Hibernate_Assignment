package com.HibernateAssignments.problem2.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.problem2.model.Customer;
import com.HibernateAssignments.problem2.model.Locker;
import com.HibernateAssignments.util.HibernateUtil;

public class UserInterface {


	public static void main(String[] args) {

		Locker l = new Locker("LOC101", "small", 1100);
		
		Customer c = new Customer(7001, "William", "17-05-1995", "Kolkata", "9067767872", l);
		
		SessionFactory sf =HibernateUtil.getSessionFactory(); 
		
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
