package com.HibernateAssignments.problem1.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.problem1.model.Movie;
import com.HibernateAssignments.util.HibernateUtil;

public class MovieDAO {
	
	
	
	public MovieDAO() {
	}

	public String addMovie(Movie movie) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		return "Candidate details are successfully added.";
	}
	
	public void deleteMovie(String movieId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query delQuery = session.createQuery("delete from Movie m where m.movieId=?1");
		delQuery.setParameter(1, movieId);
		int rows=delQuery.executeUpdate();
		System.out.println(rows+" deleted");
		session.getTransaction().commit();
	}
	
	public void updateMovie(Movie movie) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query delQuery = session.createQuery("update Movie m set m.movieName=?1,m.language=?2,m.releaseIn=?3,m.revenueInDollars=?4 "
				+ " where m.movieId=?5");
		delQuery.setParameter(1, movie.getMovieName());
		delQuery.setParameter(2, movie.getLanguage());
		delQuery.setParameter(3, movie.getReleaseIn());
		delQuery.setParameter(4, movie.getRevenueInDollars());
		delQuery.setParameter(5, movie.getMovieId());
		int rows=delQuery.executeUpdate();
		System.out.println(rows+" updated");
		session.getTransaction().commit();
	}
	
	public Movie getMovieDetails(String movieId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from Movie m where m.movieId=?1");
		selQuery.setParameter(1, movieId);
		Movie movie=(Movie) selQuery.getResultList().get(0);		
		return movie;
	}
	

}
