package com.stayrascal.api.movie.repositories;

import com.stayrascal.api.movie.model.nodes.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
    List<Movie> findByTitle(@Param("title") String title);
}
