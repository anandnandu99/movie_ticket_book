// TheatreRepository.java
package com.hexaware.ticket_book.repository;

import com.hexaware.ticket_book.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    Theatre findByName(String name);

    // You can add custom query methods here if needed
}
