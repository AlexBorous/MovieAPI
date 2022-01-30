package com.borous.oauth0_server.infastracture.repository.redis;

import com.borous.oauth0_server.domain.model.Movie;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Movie")
@Data
@Builder
class MovieEntity {
    @Id
    private String id;
    private Movie movie;

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
