package org.elsys.P.trip.repository;

import org.elsys.P.trip.entity.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Integer> {
}
