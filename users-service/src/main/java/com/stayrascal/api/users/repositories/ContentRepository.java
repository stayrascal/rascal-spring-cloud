package com.stayrascal.api.users.repositories;

import com.stayrascal.api.users.model.nodes.Content;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "content", path = "content")
public interface ContentRepository extends PagingAndSortingRepository<Content, Long> {
    List<Content> findByTitle(@Param("title") String title);
}
