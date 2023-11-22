package com.hexaware.ticket_book.repository;

import com.hexaware.ticket_book.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findByMovieName(String movieName);

    // You can add custom query methods here if needed
}
