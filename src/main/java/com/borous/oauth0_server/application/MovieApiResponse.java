package com.borous.oauth0_server.application;

import com.borous.oauth0_server.domain.model.Movie;

import java.util.List;

record MovieApiResponse(List<Movie> movies) {

    public List<Movie> getMovie() {
        return movies;
    }
}
