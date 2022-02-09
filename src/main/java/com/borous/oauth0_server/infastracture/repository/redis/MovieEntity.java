package com.borous.oauth0_server.infastracture.repository.redis;

import com.borous.oauth0_server.domain.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@RedisHash("Movie")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
class MovieEntity implements Serializable {
    @Id
    private String id;
    @Indexed
    String movieId;
    String backdropPath;
    String posterPath;
    String title;
    String releaseDate;
    double voteAverage;
    double voteCount;
    String overview;
    List<String> userIds;

    static MovieEntity fromMovie(Movie movie, List<String> userIds) {
        return MovieEntity.builder()
                .id(movie.getMovieId().toString() + movie.getTitle())
                .backdropPath(movie.getBackdrop_path())
                .movieId(movie.getMovieId().toString())
                .posterPath(movie.getPoster_path())
                .title(movie.getTitle())
                .releaseDate(movie.getRelease_date())
                .voteAverage(movie.getVote_average())
                .voteCount(movie.getVote_count())
                .overview(movie.getOverview())
                .userIds(userIds)
                .build();
    }

    void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    Movie toMovie() {
        return new Movie(BigInteger.valueOf(Long.parseLong(this.movieId)), this.backdropPath, this.posterPath, title, releaseDate, voteAverage, voteCount, overview, false);
    }

    Movie toMovie(String userId) {
        return new Movie(BigInteger.valueOf(Long.parseLong(this.movieId)), this.backdropPath, this.posterPath, title, releaseDate, voteAverage, voteCount, overview, this.userIds != null && this.userIds.contains(userId));
    }
}
