package org.elsys.P.trip.service;

import org.elsys.P.trip.entity.Location;
import org.elsys.P.trip.entity.Path;
import org.elsys.P.trip.entity.Trip;
import org.elsys.P.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();

        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    public Trip getTripById(int id) {
        return tripRepository.findById(id).get();
    }

    public void updateTrip(int id, Trip trip) {
        if (trip.getId() == id) {
            tripRepository.save(trip);
        }
    }

    public Location getTripStartLocation(Trip trip) {
        List<Path> paths = trip.getPaths();
        paths.sort((o1, o2) -> Integer.compare(o1.getOrderNum(), o2.getOrderNum()));
        return paths.get(0).getLocation();
    }

    public Location getTripEndLocation(Trip trip) {
        List<Path> paths = trip.getPaths();
        paths.sort((o1, o2) -> Integer.compare(o2.getOrderNum(), o1.getOrderNum()));
        return paths.get(0).getLocation();
    }

    public List<Trip> getTripsWithLocation(Location loc) {
        return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
                .filter(t -> {
                    List<Path> pathsWLocation= t.getPaths().stream()
                            .filter(p -> p.getLocation() == loc).collect(Collectors.toList());
                    return pathsWLocation.size() > 0;
                })
                .collect(Collectors.toList());
    }

    public void addOrUpdateTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void deleteTripById(int id) {
        tripRepository.deleteById(id);
    }

    public void createTrip(int allSpots, int freeSpots, int price, Date startDate, Date endDate) {
        Trip trip =  new Trip(null, allSpots, freeSpots, "",
                price, startDate, endDate, null, null);

        this.addOrUpdateTrip(trip);
    }
}

