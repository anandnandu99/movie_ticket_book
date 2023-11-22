package com.hexaware.ticket_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.ticket_book.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {    // You can add custom query methods here if needed
}
