package com.HibernateAssignments.problem1.tester;

import com.HibernateAssignments.problem1.dao.MovieDAO;
import com.HibernateAssignments.problem1.model.Movie;

public class UserInterface {

	public static MovieDAO movieDao;

	public static void main(String[] args) {

		movieDao = new MovieDAO();
		
		Movie m1 = new Movie("100","Pulp Fiction", "English", 1990, 50000);
		Movie m2 = new Movie("101","Forest Gump", "English", 1990, 50000);

		movieDao.addMovie(m1);
		
		movieDao.deleteMovie("101");
		
		m1 = new Movie("100","Forest Gump", "English", 1999, 52000);
		movieDao.updateMovie(m1);
		
		m1=movieDao.getMovieDetails("100");
		System.out.println(m1);
		
		
		
	}

}
