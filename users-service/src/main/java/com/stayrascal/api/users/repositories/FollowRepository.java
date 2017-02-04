package com.stayrascal.api.users.repositories;

import com.stayrascal.api.users.model.rels.Follows;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "follows", path = "follows")
public interface FollowRepository extends PagingAndSortingRepository<Follows, Long> {
}
