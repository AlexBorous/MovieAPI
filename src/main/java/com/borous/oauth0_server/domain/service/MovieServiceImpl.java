package com.borous.oauth0_server.domain.service;

import com.borous.oauth0_server.domain.model.Movie;
import com.borous.oauth0_server.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void addMovie(Movie movie, String userId) {
        movieRepository.upsertMovie(movie, userId);
    }

    @Override
    public List<Movie> getAllMovies(String userId) {
        return movieRepository.findAll(userId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Movie getMovie(BigInteger id) {
        return movieRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
