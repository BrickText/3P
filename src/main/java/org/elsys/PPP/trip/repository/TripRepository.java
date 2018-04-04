package org.elsys.PPP.trip.repository;

import org.elsys.PPP.trip.entity.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}
