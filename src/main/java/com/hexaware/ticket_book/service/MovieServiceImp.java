package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.MovieDTO;
import com.hexaware.ticket_book.entities.Movie;
import com.hexaware.ticket_book.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = convertDTOToMovie(movieDTO);
        movie = movieRepository.save(movie);
        return convertMovieToDTO(movie);
    }

    @Override
    public void removeMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertMovieToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieByName(String movieName) {
        Movie movie = movieRepository.findByMovieName(movieName);
        return convertMovieToDTO(movie);
    }

    @Override
    public MovieDTO updateMovie(int movieId, MovieDTO movieDTO) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            // Update the existing movie with new information
            existingMovie.setMovieName(movieDTO.getMovieName());
            existingMovie.setGenre(movieDTO.getGenre());
            existingMovie.setDescription(movieDTO.getDescription());
            existingMovie.setRating(movieDTO.getRating());

            // Save the updated movie
            existingMovie = movieRepository.save(existingMovie);
            return convertMovieToDTO(existingMovie);
        } else {
            // Handle case where movie with the given ID is not found
            // You might want to throw an exception or handle it in a way that makes sense for your application
            return null;
        }
    }

    // Helper method to convert MovieDTO to Movie entity
    private Movie convertDTOToMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setMovieName(movieDTO.getMovieName());
        movie.setGenre(movieDTO.getGenre());
        movie.setDescription(movieDTO.getDescription());
        movie.setRating(movieDTO.getRating());
        return movie;
    }

    // Helper method to convert Movie entity to MovieDTO
    private MovieDTO convertMovieToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setMovieName(movie.getMovieName());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setRating(movie.getRating());
        return movieDTO;
    }
}
