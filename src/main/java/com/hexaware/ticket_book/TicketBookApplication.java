package com.hexaware.ticket_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hexaware.ticket_book")

public class TicketBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookApplication.class, args);
	}

}
