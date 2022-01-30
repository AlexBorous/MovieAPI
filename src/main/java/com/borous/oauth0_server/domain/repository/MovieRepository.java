package com.borous.oauth0_server.domain.repository;

import com.borous.oauth0_server.domain.model.Movie;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Optional<Movie> findById(BigInteger id);
    Optional<List<Movie>> findAll();

    void save(Movie favoriteMovie);
}
