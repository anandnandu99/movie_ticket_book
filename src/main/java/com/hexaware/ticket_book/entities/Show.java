package com.hexaware.ticket_book.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showId;


    private String showName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")

    private LocalDateTime showTime;
    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;
    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Seating> seating;

	public List<Seating> getSeating() {
		return seating;
	}

	public void setSeating(List<Seating> seating) {
		this.seating = seating;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre optional) {
		this.theatre = optional;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	

	

    // Constructors, getters, setters
}
