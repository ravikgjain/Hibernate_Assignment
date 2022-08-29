package com.HibernateAssignments.problem3.model;

public class MovieDirector {
	
	private String movieName;
	private String directorName;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public MovieDirector(String movieName, String directorName) {
		super();
		this.movieName = movieName;
		this.directorName = directorName;
	}
	@Override
	public String toString() {
		return " [movieName=" + movieName + ", directorName=" + directorName + "]";
	}
	
	

}
