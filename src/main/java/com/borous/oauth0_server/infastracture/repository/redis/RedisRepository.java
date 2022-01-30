package com.borous.oauth0_server.infastracture.repository.redis;

import com.borous.oauth0_server.domain.model.Movie;
import com.borous.oauth0_server.domain.repository.MovieRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class RedisRepository implements MovieRepository {
    private final SpringDataRedisRepository orderRepository;

    public RedisRepository(SpringDataRedisRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Movie> findById(BigInteger id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Movie>> findAll() {
        return Optional.empty();
    }

    @Override
    public void save(Movie favoriteMovie) {
        MovieEntity movieEntity = MovieEntity.builder()
                .movie(favoriteMovie)
                .build();
        orderRepository.save(movieEntity);
    }
}
