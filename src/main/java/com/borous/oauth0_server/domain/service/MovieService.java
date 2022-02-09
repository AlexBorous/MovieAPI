package com.borous.oauth0_server.domain.service;

import com.borous.oauth0_server.domain.model.Movie;

import java.math.BigInteger;
import java.util.List;


public interface MovieService {
    void addMovie(Movie movie, String userId);

    List<Movie> getAllMovies(String userId);

    Movie getMovie(BigInteger id);
}
