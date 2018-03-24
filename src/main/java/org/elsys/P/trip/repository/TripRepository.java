package org.elsys.P.trip.repository;

import org.springframework.data.repository.CrudRepository;
import org.elsys.P.trip.entity.Trip;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}