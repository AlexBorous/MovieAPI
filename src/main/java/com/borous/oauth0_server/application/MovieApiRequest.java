package com.borous.oauth0_server.application;

import com.borous.oauth0_server.domain.model.Movie;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
class MovieApiRequest implements Serializable {
    @NonNull
    private final Movie movie;
    private final String userId;

    @JsonCreator
    MovieApiRequest(@JsonProperty("movie") final Movie movie, @JsonProperty("userId") final String userId) {
        this.movie = movie;
        this.userId = userId;
    }

}
