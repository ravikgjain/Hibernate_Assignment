package com.HibernateAssignments.problem4.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.util.HibernateUtil;



public class MovieEntityDAO {
	
	
	
	public MovieEntityDAO() {
	}

	
	public void getMaxRevenue(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select max(m.revenueInDollars) from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		int maxRevenue=(int) selQuery.getResultList().get(0);	
		System.out.println("Maximum Revenue of movies in "+language+" is "+maxRevenue);
	}
	
	public void getMinRevenue(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select min(m.revenueInDollars) from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		int minRevenue=(int) selQuery.getResultList().get(0);	
		System.out.println("Minimum Revenue of movies in "+language+" is "+minRevenue);
	}
	
	public void getSumRevenue(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select sum(m.revenueInDollars) from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		long sumRevenue=(long) selQuery.getResultList().get(0);	
		System.out.println("Sum of  Revenue of movies in "+language+" is "+sumRevenue);
	}
	
	public void getAvgRevenue(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select avg(m.revenueInDollars) from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		double avgRevenue=(double) selQuery.getResultList().get(0);	
		System.out.println("Average Revenue of movies in "+language+" is "+avgRevenue);
	}
	
	public void getMovieCount(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select count(1) from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		long count=(long) selQuery.getResultList().get(0);	
		System.out.println("count of movies in "+language+" is "+count);
	}
	
	public void getMovieCountByLanguage() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m.language,count(1) as movieCount from MovieEntity m "
				+ "group by language having count(1) > 1 order by count(1) desc");
		
		List<Object[]> list = selQuery.getResultList();
		
		for (Object[] object : list) {
			System.out.println(object[0]+"-"+object[1]);
		}
	}
	
	
	

	
}
