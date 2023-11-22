package com.hexaware.ticket_book.controller;

import com.hexaware.ticket_book.dto.MovieDTO;
import com.hexaware.ticket_book.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO addedMovie = movieService.addMovie(movieDTO);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
        movieService.removeMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/getMovieByName/{movieName}")
    public ResponseEntity<MovieDTO> getMovieByName(@PathVariable String movieName) {
        MovieDTO movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/updateMovie/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable int movieId, @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(movieId, movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
}
