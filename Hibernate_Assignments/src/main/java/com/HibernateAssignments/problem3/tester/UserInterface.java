package com.HibernateAssignments.problem3.tester;

import java.util.List;

import com.HibernateAssignments.problem3.dao.MovieEntityDAO;
import com.HibernateAssignments.problem3.model.DirectorEntity;
import com.HibernateAssignments.problem3.model.MovieDirector;
import com.HibernateAssignments.problem3.model.MovieEntity;

public class UserInterface {

	public static MovieEntityDAO movieDao;

	public static void main(String[] args) {

		movieDao = new MovieEntityDAO();
		
		DirectorEntity d1 = new DirectorEntity("D101", "Chris Columbus", 1958);
		DirectorEntity d2 = new DirectorEntity("D102", "Patrick Read Johnson", 1962);
		DirectorEntity d3 = new DirectorEntity("D103", "Aamir Khan", 1965);
		DirectorEntity d4 = new DirectorEntity("D104", "R. Balki", 1070);

		
		MovieEntity m1 = new MovieEntity("M1001","Home Alone", "English", 1990, 476700000,d1);
		MovieEntity m2 = new MovieEntity("M1002","Home Alone", "English", 1992, 358900000,d1);
		MovieEntity m3 = new MovieEntity("M1003","Baby's Day Out", "English", 1994, 16800000,d2);
		MovieEntity m4 = new MovieEntity("M1004","Taare Zameen Par", "Hindi", 2007, 16800000,d3);
		MovieEntity m5 = new MovieEntity("M1005","Paa", "Hindi", 2009, 4700000,d4);

/*
		movieDao.addMovie(m1);
		movieDao.addMovie(m2);
		movieDao.addMovie(m3);
		movieDao.addMovie(m4);
		movieDao.addMovie(m5); */
		
		MovieEntity m6 = new MovieEntity("M1006","3 Idiots", "Hindi", 2012, 700000,d4);
		movieDao.addMovie(m6);
		movieDao.updateRevenue("M1006");

		movieDao.deleteMovie("M1006");
		movieDao.getMovieDetailsByLanguage("English");
		movieDao.getMovieDetailsByDirector("D104");
		movieDao.getDistinctLanguages();
		List<MovieDirector> mdlist=movieDao.getMovieDirectorName();
		
		System.out.println("List of Movies and Director Names");
		
		for(MovieDirector md : mdlist)
		{
			System.err.println(md);
		}

		
		
		
	}

}
