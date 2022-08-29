package com.HibernateAssignments.problem3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieEntity {

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

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "directorId")
	private DirectorEntity director;

	public MovieEntity() {
	}

	public MovieEntity(String movieId, String movieName, String language, int releaseIn, int revenueInDollars,
			DirectorEntity director) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releaseIn = releaseIn;
		this.revenueInDollars = revenueInDollars;
		this.director = director;
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

	public DirectorEntity getDirector() {
		return director;
	}

	public void setDirector(DirectorEntity director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language
				+ ", releaseIn=" + releaseIn + ", revenueInDollars=" + revenueInDollars + ", director=" + director
				+ "]";
	}

}
