package com.HibernateAssignments.problem5.tester;

import java.util.HashSet;
import java.util.Set;

import com.HibernateAssignments.problem4.dao.MovieEntityDAO;
import com.HibernateAssignments.problem5.dao.AssetsDAO;
import com.HibernateAssignments.problem5.dao.EmployeeDAO;
import com.HibernateAssignments.problem5.model.Assets;
import com.HibernateAssignments.problem5.model.Employee;

public class UserInterface {

	public static EmployeeDAO empDao;
	
	public static AssetsDAO assetsDao;

	public static void main(String[] args) {

		empDao = new EmployeeDAO();
		assetsDao= new AssetsDAO();
		
		Assets a1= new Assets(101, 101, 101, "Mobile", 10000, "Mumbai");
		Assets a2= new Assets(102, 102, 102, "Laptop", 80000, "Mumbai");
		Assets a3= new Assets(103, 103, 103, "Desktop", 30000, "Chennai");
		Assets a4= new Assets(104, 104, 104, "Mobile", 10000, "Chennai");
		Assets a5= new Assets(105, 105, 105, "Laptop", 80000, "Bangalore");
		
		Set<Assets> s1 = new HashSet<Assets>();
		
		s1.add(a1);
		s1.add(a2);
		
		Set<Assets> s2 = new HashSet<Assets>();
		s2.add(a3);
		s2.add(a4);
		s2.add(a5);


		Employee e1 = new Employee(101, "John", "John123", s1);
		Employee e2 = new Employee(102, "Andy", "Andy123", s2);

		//empDao.addEmployee(e2);
		
		//empDao.updatePassword("password_123", 101);
		
		//empDao.deleteEmployee(101);
		
		//assetsDao.getAssetById(101);
		
		//assetsDao.getMaxPriceAsset();
		
		//empDao.getEmployeeCount();
		
		//empDao.getEmployees();
		
		//empDao.getEmployeeById(101);
		
		//empDao.getAvgAssetPrice();
		
		empDao.getAvgAssetPrice();


		
		
		
	}

}
