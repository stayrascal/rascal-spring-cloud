package com.stayrascal.api.users.repositories;

import com.stayrascal.api.users.model.nodes.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    List<Event> findByEventType(@Param("eventType") String eventType);
}
