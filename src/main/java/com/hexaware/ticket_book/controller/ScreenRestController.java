package com.hexaware.ticket_book.controller;

import com.hexaware.ticket_book.dto.ScreenDTO;
import com.hexaware.ticket_book.service.IScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenRestController {

    @Autowired
    private IScreenService screenService;

    @PostMapping("/add/{theatreId}")
    public ResponseEntity<ScreenDTO> addScreen(@RequestBody ScreenDTO screenDTO, @PathVariable int theatreId) {
        ScreenDTO addedScreen = screenService.addScreen(screenDTO, theatreId);
        if (addedScreen != null) {
            return new ResponseEntity<>(addedScreen, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{screenId}")
    public ResponseEntity<Void> removeScreen(@PathVariable int screenId) {
        screenService.removeScreen(screenId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScreenDTO>> getAllScreens() {
        List<ScreenDTO> screens = screenService.getAllScreens();
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<ScreenDTO>> getScreensByTheatre(@PathVariable int theatreId) {
        List<ScreenDTO> screens = screenService.getScreensByTheatre(theatreId);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }
}
