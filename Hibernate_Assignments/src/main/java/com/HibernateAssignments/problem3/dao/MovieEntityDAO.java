package com.HibernateAssignments.problem3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.problem3.model.HollyWoodEntity;
import com.HibernateAssignments.problem3.model.MovieDirector;
import com.HibernateAssignments.problem3.model.MovieEntity;
import com.HibernateAssignments.util.HibernateUtil;

public class MovieEntityDAO {
	
	
	
	public MovieEntityDAO() {
	}

	public String addMovie(MovieEntity movie) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		return "Candidate details are successfully added.";
	}
	
	public String addHollywoodMovie() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query selQuery = session.createQuery("select m from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, "English");
		List<MovieEntity> movies=selQuery.getResultList();	
		for(MovieEntity movie:movies)
		{
			session.save(new HollyWoodEntity(movie));
		}
		session.getTransaction().commit();
		return "Hollywood movie Details are successfully added.";
	}
	
	public void deleteMovie(String movieId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query delQuery = session.createQuery("delete from MovieEntity m where m.movieId=?1");
		delQuery.setParameter(1, movieId);
		int rows=delQuery.executeUpdate();
		System.out.println(rows+" deleted");
		session.getTransaction().commit();
	}
	
	public void updateRevenue(String movieId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m.revenueInDollars from MovieEntity m where m.movieId=?1");
		selQuery.setParameter(1, movieId);
		int revenue=(int) selQuery.getResultList().get(0);
		revenue=100000 + revenue;
		session.beginTransaction();
		Query updateQuery = session.createQuery("update MovieEntity m set m.revenueInDollars=?1 "
				+ " where m.movieId=?2");
		updateQuery.setParameter(1, revenue);
		updateQuery.setParameter(2, movieId);
		int rows=updateQuery.executeUpdate();
		System.out.println(rows+" updated");
		session.getTransaction().commit();
	}
	
	public void getMovieDetailsByLanguage(String language) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from MovieEntity m where m.language=?1");
		selQuery.setParameter(1, language);
		List<MovieEntity> movies=selQuery.getResultList();	
		System.out.println("List of movies in "+language);

		for(MovieEntity movie:movies)
		{
			System.out.println(movie);
		}
	}
	
	public void getMovieDetailsByDirector(String directorId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from MovieEntity m where directorId=?1");
		selQuery.setParameter(1, directorId);
		List<MovieEntity> movies=selQuery.getResultList();	
		
		System.out.println("List of movies directed by "+directorId);
		for(MovieEntity movie:movies)
		{
			System.out.println(movie);
		}
	}
	
	public void getDistinctLanguages() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select distinct m.language from MovieEntity m ");
		List<String> languages=selQuery.getResultList();	
		System.out.println("List of languages");
		for(String l:languages)
		{
			System.out.println(l);
		}
	}
	
	public List<MovieDirector> getMovieDirectorName() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from MovieEntity m ");
		List<MovieEntity> list=selQuery.getResultList();	
		System.out.println("List of languages");
		List<MovieDirector> mdlist= new ArrayList<>();
		for(MovieEntity movie:list)
		{
			mdlist.add(new MovieDirector(movie.getMovieName(), movie.getDirector().getDirectorName()));
		}
		
		return mdlist;
		
	}
	

}
