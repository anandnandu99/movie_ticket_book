package com.hexaware.ticket_book.repository;

import com.hexaware.ticket_book.entities.Screen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findByTheatreId(int theatreId);

    // Add custom query methods if needed
}
