package com.stayrascal.api.users.v1.repositories;

import com.stayrascal.api.users.v1.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
