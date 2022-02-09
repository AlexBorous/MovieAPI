package com.borous.oauth0_server.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie implements Serializable {
    BigInteger movieId;
    String backdrop_path;
    String poster_path;
    String title;
    String release_date;
    double vote_average;
    double vote_count;
    String overview;
    boolean isLiked;
}
