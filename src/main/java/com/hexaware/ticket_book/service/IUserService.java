package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.BookingRequestDTO;
import com.hexaware.ticket_book.dto.SeatingDTO;
import com.hexaware.ticket_book.dto.UserDTO;

public interface IUserService {
    UserDTO getUserDTOById(int userId);

    SeatingDTO bookSeat(int userId, BookingRequestDTO bookingRequestDTO);
}
