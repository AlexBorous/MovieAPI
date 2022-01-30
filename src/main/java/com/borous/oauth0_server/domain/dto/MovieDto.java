package com.borous.oauth0_server.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class MovieDto {
    BigInteger movie_id;
    String backdrop_path;
    String poster_path;
    String title;
    String release_date;
    double vote_average;
    double vote_count;
    String overview;
}
