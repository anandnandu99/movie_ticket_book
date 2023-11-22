package com.hexaware.ticket_book.dto;

public class SeatingDTO {
    private int seatingId;
    private int seatNumber;
    private double seatCost;
    private boolean booked;
	public int getSeatingId() {
		return seatingId;
	}
	public void setSeatingId(int seatingId) {
		this.seatingId = seatingId;
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
