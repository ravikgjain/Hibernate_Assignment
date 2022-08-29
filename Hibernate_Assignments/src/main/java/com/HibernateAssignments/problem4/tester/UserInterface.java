package com.HibernateAssignments.problem4.tester;

import com.HibernateAssignments.problem4.dao.MovieEntityDAO;

public class UserInterface {

	public static MovieEntityDAO movieDao;

	public static void main(String[] args) {

		movieDao = new MovieEntityDAO();
		
		movieDao.getMaxRevenue("English");
		
		movieDao.getMinRevenue("English");
		
		movieDao.getSumRevenue("English");

		movieDao.getAvgRevenue("English");
		
		movieDao.getMovieCount("English");

		movieDao.getMovieCountByLanguage();


		
		
		
	}

}
