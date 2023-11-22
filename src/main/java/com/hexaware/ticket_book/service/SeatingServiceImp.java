package com.hexaware.ticket_book.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ticket_book.dto.SeatingDTO;
import com.hexaware.ticket_book.entities.Seating;
import com.hexaware.ticket_book.repository.SeatingRepository;

@Service
public class SeatingServiceImp implements ISeatingService {

    @Autowired
    private SeatingRepository seatingRepository;

    @Override
    public List<SeatingDTO> getAllAvailableSeats() {
        List<Seating> availableSeats = seatingRepository.findByBookedFalse();
        return availableSeats.stream()
                .map(this::convertToSeatingDTO)
                .collect(Collectors.toList());
    }

    private SeatingDTO convertToSeatingDTO(Seating seating) {
        SeatingDTO seatingDTO = new SeatingDTO();
        seatingDTO.setSeatingId(seating.getSeatingId());
        seatingDTO.setSeatNumber(seating.getSeatNumber());
        seatingDTO.setSeatCost(seating.getSeatCost());
        seatingDTO.setBooked(seating.isBooked());
        return seatingDTO;
    }
}
