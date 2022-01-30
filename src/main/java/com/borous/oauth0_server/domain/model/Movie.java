package com.borous.oauth0_server.domain.model;

import com.borous.oauth0_server.domain.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    MovieDto movieDto;
    boolean isLiked;
}
