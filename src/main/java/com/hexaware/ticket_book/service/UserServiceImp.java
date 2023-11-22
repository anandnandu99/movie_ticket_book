package com.hexaware.ticket_book.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ticket_book.dto.BookingRequestDTO;
import com.hexaware.ticket_book.dto.SeatingDTO;
import com.hexaware.ticket_book.dto.UserDTO;
import com.hexaware.ticket_book.entities.Seating;
import com.hexaware.ticket_book.entities.User;
import com.hexaware.ticket_book.exceptions.BookingException;
import com.hexaware.ticket_book.repository.SeatingRepository;
import com.hexaware.ticket_book.repository.UserRepository;


@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatingRepository seatingRepository;

    @Override
    public UserDTO getUserDTOById(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return convertToUserDTO(user);
        }
        return null;
    }

    @Override
    public SeatingDTO bookSeat(int userId, BookingRequestDTO bookingRequestDTO) throws BookingException {
        User user = userRepository.findById(userId).orElseThrow(() -> new BookingException("User not found"));

        Seating seat = seatingRepository.findById(bookingRequestDTO.getSeatId())
                .orElseThrow(() -> new BookingException("Seat not found"));

        if (seat.isBooked()) {
            throw new BookingException("Seat already booked");
        }

        seat.setBooked(true);
        seat.setUser(user);
        seatingRepository.save(seat);

        return convertToSeatingDTO(seat);
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setBookedSeats(convertToSeatingDTOList(user.getBookedSeats()));
        return userDTO;
    }

    private List<SeatingDTO> convertToSeatingDTOList(List<Seating> seatingList) {
        return seatingList.stream()
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
