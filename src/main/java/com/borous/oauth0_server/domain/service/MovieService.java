package com.borous.oauth0_server.domain.service;

import com.borous.oauth0_server.domain.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

public interface MovieService {
    BigInteger addFavoriteMovie(MovieDto movieDto);

}
