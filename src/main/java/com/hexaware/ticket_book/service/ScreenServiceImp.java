package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.ScreenDTO;
import com.hexaware.ticket_book.entities.Screen;
import com.hexaware.ticket_book.entities.Theatre;
import com.hexaware.ticket_book.repository.ScreenRepository;
import com.hexaware.ticket_book.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImp implements IScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public ScreenDTO addScreen(ScreenDTO screenDTO, int theatreId) {
        Screen screen = new Screen();
        screen.setScreenName(screenDTO.getScreenName());

        // Fetch the theatre by ID
        Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
        if (optionalTheatre.isPresent()) {
            Theatre theatre = optionalTheatre.get();
            screen.setTheatre(theatre);

            // Add the screen to the theatre's list of screens
            theatre.getScreens().add(screen);

            // Save the theatre to update the
            // Save the theatre to update the relationship
            theatreRepository.save(theatre);

            // Save the screen
            screen = screenRepository.save(screen);

            // Convert and return ScreenDTO
            return convertScreenToDTO(screen);
        } else {
            // Handle case where theatre with the given ID is not found
            // You might want to throw an exception or handle it in a way that makes sense for your application
            return null;
        }
    }

    @Override
    public void removeScreen(int screenId) {
        screenRepository.deleteById(screenId);
    }

    @Override
    public List<ScreenDTO> getAllScreens() {
        return screenRepository.findAll().stream()
                .map(this::convertScreenToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScreenDTO> getScreensByTheatre(int theatreId) {
        return screenRepository.findByTheatreId(theatreId).stream()
                .map(this::convertScreenToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert Screen entity to ScreenDTO
    private ScreenDTO convertScreenToDTO(Screen screen) {
        ScreenDTO screenDTO = new ScreenDTO();
        screenDTO.setId(screen.getId());
        screenDTO.setScreenName(screen.getScreenName());
        // You may set other properties if needed

        return screenDTO;
    }
}
