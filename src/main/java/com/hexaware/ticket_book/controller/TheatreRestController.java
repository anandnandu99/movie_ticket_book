// TheatreController.java
package com.hexaware.ticket_book.controller;

import com.hexaware.ticket_book.dto.TheatreDTO;
import com.hexaware.ticket_book.entities.Theatre;
import com.hexaware.ticket_book.service.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreRestController {

    @Autowired
    private ITheatreService theatreService;

    @PostMapping("/addTheatre")
    public ResponseEntity<TheatreDTO> addTheatre(@RequestBody TheatreDTO theatreDTO) {
        TheatreDTO addedTheatre = theatreService.addTheatre(theatreDTO);
        return ResponseEntity.ok(addedTheatre);
    }

    @DeleteMapping("/removeTheatre/{theatreId}")
    public ResponseEntity<String> removeTheatre(@PathVariable int theatreId) {
        theatreService.removeTheatre(theatreId);
        return ResponseEntity.ok("Theatre removed successfully");
    }

    @GetMapping("/getTheatreByName/{name}")
    public ResponseEntity<Theatre> getTheatreByName(@PathVariable String name) {
        Theatre theatre = theatreService.getTheatreByName(name);
        return ResponseEntity.ok(theatre);
    }

    @GetMapping("/getAllTheatres")
    public ResponseEntity<List<TheatreDTO>> getAllTheatres() {
        List<TheatreDTO> theatres = theatreService.getAllTheatres();
        return ResponseEntity.ok(theatres);
    }
}
