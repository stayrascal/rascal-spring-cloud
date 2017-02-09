package com.stayrascal.api.movie.model.rels;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stayrascal.api.movie.model.nodes.Genre;
import com.stayrascal.api.movie.model.nodes.Movie;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "HAS_GENER")
public class HasGenre {

    @GraphId
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Genre genre;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
