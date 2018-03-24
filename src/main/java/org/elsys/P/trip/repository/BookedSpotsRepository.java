package org.elsys.P.trip.repository;

import org.elsys.P.trip.entity.BookedSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSpotsRepository extends CrudRepository<BookedSpot, Integer> {
}
