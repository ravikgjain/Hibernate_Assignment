package com.HibernateAssignments.problem3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HollyWoodEntity {
	
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

	public HollyWoodEntity() {
	}

	public HollyWoodEntity( String movieId,String movieName, String language, int releaseIn, int revenueInDollars) {
		this.movieId=movieId;
		this.movieName = movieName;
		this.language = language;
		this.releaseIn = releaseIn;
		this.revenueInDollars = revenueInDollars;
	}
	
	public HollyWoodEntity(MovieEntity movie)
	{
		this.movieId=movie.getMovieId();
		this.movieName = movie.getMovieName();
		this.language = movie.getLanguage();
		this.releaseIn = movie.getReleaseIn();
		this.revenueInDollars = movie.getRevenueInDollars();
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
		return "HollyWoodEntity [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releaseIn="
				+ releaseIn + ", revenueInDollars=" + revenueInDollars + "]";
	}
	
	

}
