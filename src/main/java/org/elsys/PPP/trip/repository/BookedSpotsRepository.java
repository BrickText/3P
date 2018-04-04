package org.elsys.PPP.trip.repository;

import org.elsys.PPP.trip.entity.BookedSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSpotsRepository extends CrudRepository<BookedSpot, Integer> {
}
