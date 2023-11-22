package com.hexaware.ticket_book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.ticket_book.entities.Seating;

public interface SeatingRepository extends JpaRepository<Seating,Integer> {
    List<Seating> findByBookedFalse();

}
