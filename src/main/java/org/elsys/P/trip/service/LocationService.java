package org.elsys.P.trip.service;

import org.elsys.P.trip.entity.Location;
import org.elsys.P.trip.entity.Path;
import org.elsys.P.trip.entity.Trip;
import org.elsys.P.trip.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        java.util.List<Location> locations = new ArrayList<>();

        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Location getLocationById(int id) {
        return locationRepository.findById(id).get();
    }

    public void updateLocation(int id, Location loc) {
        if (loc.getId() == id) {
            locationRepository.save(loc);
        }
    }

    public Location getTripEndLocation(Trip trip) {
        List<Path> paths = trip.getPaths();
        paths.sort((o1, o2) -> Integer.compare(o2.getOrderNum(), o1.getOrderNum()));
        return paths.get(0).getLocation();
    }

    public void addOrUpdateLocation(Location loc) {
        locationRepository.save(loc);
    }

    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }

}