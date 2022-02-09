package com.borous.oauth0_server.application;

import com.borous.oauth0_server.domain.model.Movie;
import com.borous.oauth0_server.domain.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("api/movie")
@Slf4j
class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public MovieApiResponse findAll(@Nullable @RequestParam String user) {
        List<Movie> movies = movieService.getAllMovies(user);
        return new MovieApiResponse(movies);
    }

    @GetMapping("/{id}")
    public MovieApiResponse find(@PathVariable("id") BigInteger id) {
        return new MovieApiResponse(List.of(movieService.getMovie(id)));
    }

    @PostMapping
    public MovieApiResponse addMovie(@RequestBody MovieApiRequest movie) {
        log.info("Request came " + movie);
        movieService.addMovie(movie.getMovie(), movie.getUserId());
        return new MovieApiResponse(List.of(movie.getMovie()));
    }
}