package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.MovieDTO;
import java.util.List;

public interface IMovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    void removeMovie(int movieId);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieByName(String movieName);
    MovieDTO updateMovie(int movieId, MovieDTO movieDTO);
}
