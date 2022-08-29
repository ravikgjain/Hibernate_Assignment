package com.HibernateAssignments.problem1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MovieDetails")
public class Movie {
	
	@Id
	private String movieId;
	@Column
	private String movieName;
	@Column
	private String language;
	@Column
	private int releaseIn;
	@Column
	private int revenueInDollars;

	public Movie() {
	}

	public Movie( String movieId,String movieName, String language, int releaseIn, int revenueInDollars) {
		this.movieId=movieId;
		this.movieName = movieName;
		this.language = language;
		this.releaseIn = releaseIn;
		this.revenueInDollars = revenueInDollars;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getReleaseIn() {
		return releaseIn;
	}

	public void setReleaseIn(int releaseIn) {
		this.releaseIn = releaseIn;
	}

	public int getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(int revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releaseIn="
				+ releaseIn + ", revenueInDollars=" + revenueInDollars + "]";
	}
	
	

}
