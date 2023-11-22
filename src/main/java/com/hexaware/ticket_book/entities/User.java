// User.java
package com.hexaware.ticket_book.entities;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Seating> bookedSeats;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Seating> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Seating> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

    // Constructors, getters, setters
}
