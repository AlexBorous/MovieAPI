package com.borous.oauth0_server.infastracture.repository.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SpringDataRedisRepository extends CrudRepository<MovieEntity, String> {
    Optional<MovieEntity> findByMovieId(String movieId);

    Optional<MovieEntity> findByTitle(String title);

    Optional<MovieEntity> findByMovieIdAndTitle(String movieId, String title);

}