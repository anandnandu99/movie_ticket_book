package com.hexaware.ticket_book.dto;

import java.util.List;

public class UserDTO {
    private int userId;
    private String username;
    private List<SeatingDTO> bookedSeats;
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
	public List<SeatingDTO> getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(List<SeatingDTO> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

 
}
