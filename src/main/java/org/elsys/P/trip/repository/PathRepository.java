package org.elsys.P.trip.repository;

import org.elsys.P.trip.entity.Path;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends CrudRepository<Path, Integer> {
}
