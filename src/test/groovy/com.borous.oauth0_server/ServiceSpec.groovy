package com.borous.oauth0_server

import com.borous.oauth0_server.domain.model.Movie
import com.borous.oauth0_server.domain.repository.MovieRepository
import com.borous.oauth0_server.domain.service.MovieServiceImpl
import spock.lang.Specification

class ServiceSpec extends Specification {
    def movieRepositoryStub = Stub(MovieRepository.class)
    def movieService = new MovieServiceImpl(movieRepositoryStub)

    def "given a movie , assert that service find by id and repository getMovie return correct value "() {
        given:
        def movie = Movie.builder().isLiked(false).movieId(BigInteger.ONE).overview("overview").build()
        movieRepositoryStub.findById(BigInteger.ONE) >> Optional.of(movie)
        when:
        def movieFromService = movieService.getMovie(BigInteger.ONE)
        then:
        movie == movieFromService
    }

    def "given a movie , assert that service find all and repository getAll returns correct values "() {
        given:
        def movie = List.of(Movie.builder().isLiked(false).movieId(BigInteger.ONE).overview("overview").build())
        movieRepositoryStub.findAll(null) >> Optional.of(movie)
        when:
        def movieFromService = movieService.getAllMovies(null)
        then:
        movie == movieFromService
    }
}