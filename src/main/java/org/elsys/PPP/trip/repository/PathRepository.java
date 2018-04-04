package org.elsys.PPP.trip.repository;

import org.elsys.PPP.trip.entity.Path;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends CrudRepository<Path, Integer> {
}
