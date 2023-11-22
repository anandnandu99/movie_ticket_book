// ITheatreService.java
package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.TheatreDTO;
import com.hexaware.ticket_book.entities.Theatre;

import java.util.List;

public interface ITheatreService {

    TheatreDTO addTheatre(TheatreDTO theatreDTO);

    void removeTheatre(int theatreId);

    Theatre getTheatreByName(String name);

    List<TheatreDTO> getAllTheatres();
}
