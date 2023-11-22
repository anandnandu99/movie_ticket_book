package com.hexaware.ticket_book.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seating")
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seatingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int seatNumber;
    private double seatCost;
    private boolean booked;
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public int getSeatingId() {
		return seatingId;
	}
	public void setSeatingId(int seatingId) {
		this.seatingId = seatingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getSeatCost() {
		return seatCost;
	}
	public void setSeatCost(double seatCost) {
		this.seatCost = seatCost;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}

}
