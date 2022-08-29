package com.HibernateAssignments.problem5.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.problem5.model.Employee;
import com.HibernateAssignments.util.HibernateUtil;

public class EmployeeDAO {
	
	public String addEmployee(Employee emp) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		return "Candidate details are successfully added.";
	}
	
	
	public void deleteEmployee(int empId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query delQuery = session.createQuery("delete from Employee m where m.empId=?1");
		delQuery.setParameter(1, empId);
		int rows=delQuery.executeUpdate();
		System.out.println(rows+" deleted");
		session.getTransaction().commit();
	}
	
	public void updatePassword(String newPassword,int empId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query updateQuery = session.createQuery("update Employee m set m.password=?1 "
				+ " where m.empId=?2");
		updateQuery.setParameter(1, newPassword);
		updateQuery.setParameter(2, empId);
		int rows=updateQuery.executeUpdate();
		System.out.println(rows+" updated");
		session.getTransaction().commit();
	}
	
	public void getEmployeeCount() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select count(1) from Employee m ");
		long count=(long) selQuery.getResultList().get(0);	
		System.out.println("count of Employees is "+count);
	}
	
	public void getEmployees() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from Employee m order by m.empName desc ");
		List<Employee> employees= selQuery.getResultList();	
		System.out.println("Employees in descending order of thier name");
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	public void getEmployeeById(int empId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Employee e = session.get(Employee.class, empId);
		System.out.println(e);
	}

	public void getAvgAssetPrice() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query query = session.getNamedQuery("findAvgAssetPriceByLocation");
		
		List<Object[]> list=query.getResultList();
		for(Object[] obj:list)
			System.out.println(obj[1]+"-"+obj[0]);
	}
}
