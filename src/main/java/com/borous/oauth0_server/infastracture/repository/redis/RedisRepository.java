package com.borous.oauth0_server.infastracture.repository.redis;

import com.borous.oauth0_server.domain.model.Movie;
import com.borous.oauth0_server.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Primary
@Slf4j
public class RedisRepository implements MovieRepository {
    private final SpringDataRedisRepository orderRepository;

    public RedisRepository(SpringDataRedisRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Movie> findById(BigInteger id) {
        final Optional<MovieEntity> optionalMovieEntity = orderRepository.findByMovieId(id.toString());
        return optionalMovieEntity.map(MovieEntity::toMovie);
    }

    @Override
    public Optional<List<Movie>> findAll(String userId) {
        Iterable<MovieEntity> movieEntityIterable = orderRepository.findAll();
        final List<Movie> movies = StreamSupport.stream(movieEntityIterable.spliterator(), false).filter(Objects::nonNull).map((movieEntity -> movieEntity.toMovie(userId)))
                .collect(Collectors.toList());
        return Optional.of(movies);
    }

    @Override
    public void save(Movie favoriteMovie, String userId) {
        MovieEntity movieEntity = MovieEntity.fromMovie(favoriteMovie, List.of(userId));
        orderRepository.save(movieEntity);
    }

    @Override
    public Optional<Movie> findByMovieId(BigInteger movieId) {
        final Optional<MovieEntity> movieOptional = orderRepository.findById(movieId.toString());
        return movieOptional.map(MovieEntity::toMovie);
    }

    @Override
    public void upsertMovie(Movie movie, String userId) {
        final Optional<MovieEntity> movieEntityOptional = orderRepository.findByMovieId(movie.getMovieId().toString());
        final Optional<MovieEntity> movieEntityNameOptional = orderRepository.findByTitle(movie.getTitle());
        final Optional<MovieEntity> movieEntityNameAndTitle = orderRepository.findByMovieIdAndTitle(movie.getMovieId().toString(), movie.getTitle());

        log.info(movieEntityOptional.toString());
        log.info(movieEntityNameOptional.toString());
        log.info(movieEntityNameAndTitle.toString());
        if (userId == null) {
            orderRepository.save(MovieEntity.fromMovie(movie, null));
            return;
        }
        if (movieEntityOptional.isPresent()) {
            MovieEntity movieEntity = movieEntityOptional.get();
            List<String> userIds = movieEntity.getUserIds();
            if (userIds != null && userIds.contains(userId)) {
                orderRepository.delete(movieEntity);
                userIds.remove(userId);
                movieEntity.setUserIds(userIds);
                orderRepository.save(movieEntity);
                return;
            }
            orderRepository.delete(movieEntity);
            if (userIds == null) {
                userIds = List.of(userId);
            } else {
                userIds.add(userId);
            }
            movieEntity.setUserIds(userIds);
            orderRepository.save(movieEntity);
        } else {
            orderRepository.save(MovieEntity.fromMovie(movie, List.of(userId)));
        }
    }
}
