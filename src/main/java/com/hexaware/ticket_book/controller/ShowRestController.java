package com.hexaware.ticket_book.controller;

import com.hexaware.ticket_book.dto.ShowDTO;
import com.hexaware.ticket_book.service.IShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowRestController {

    @Autowired
    IShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<ShowDTO> addShow(@RequestBody ShowDTO showDTO) {
        ShowDTO addedShow = showService.addShow(showDTO);

        if (addedShow != null) {
            return new ResponseEntity<>(addedShow, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getShows")
    public ResponseEntity<List<ShowDTO>> getAllShows() {
        List<ShowDTO> allShows = showService.getAllShows();

        if (!allShows.isEmpty()) {
            return new ResponseEntity<>(allShows, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
