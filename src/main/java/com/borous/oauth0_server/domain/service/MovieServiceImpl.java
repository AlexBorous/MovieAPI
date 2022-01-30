package com.borous.oauth0_server.domain.service;

import com.borous.oauth0_server.domain.model.Movie;
import com.borous.oauth0_server.domain.dto.MovieDto;
import com.borous.oauth0_server.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public BigInteger addFavoriteMovie(MovieDto movieDto) {
        Movie movie = new Movie(movieDto,true);
        return null;
    }
}
