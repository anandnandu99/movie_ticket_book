// TheatreServiceImp.java
package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.TheatreDTO;
import com.hexaware.ticket_book.entities.Theatre;
import com.hexaware.ticket_book.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImp implements ITheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public TheatreDTO addTheatre(TheatreDTO theatreDTO) {
        Theatre theatre = new Theatre();
        theatre.setName(theatreDTO.getName());

        // Save the theatre
        theatre = theatreRepository.save(theatre);

        // Convert and return TheatreDTO
        return convertTheatreToDTO(theatre);
    }

    @Override
    public void removeTheatre(int theatreId) {
        theatreRepository.deleteById(theatreId);
    }

    @Override
    public Theatre getTheatreByName(String name) {
        return theatreRepository.findByName(name);
    }

    @Override
    public List<TheatreDTO> getAllTheatres() {
        return theatreRepository.findAll().stream()
                .map(this::convertTheatreToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert Theatre entity to TheatreDTO
    private TheatreDTO convertTheatreToDTO(Theatre theatre) {
        if (theatre == null) {
            return null; // or handle the null case as needed
        }

        TheatreDTO theatreDTO = new TheatreDTO();
        theatreDTO.setId(theatre.getId());
        theatreDTO.setName(theatre.getName());

        // You may set other properties if needed

        return theatreDTO;
    }
}
