package com.hexaware.ticket_book.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    private String movieName;
    private String genre;
    private String description;
    private double rating;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Show shows;

	public Movie() {
		super();
	}

	public Movie(int movieId, String movieName, String genre, String description, double rating, Show shows) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.description = description;
		this.rating = rating;
		this.shows = shows;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Show getShows() {
		return shows;
	}

	public void setShows(Show shows) {
		this.shows = shows;
	}

    // Constructors, getters, setters
}
