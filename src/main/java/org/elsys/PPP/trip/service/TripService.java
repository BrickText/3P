package org.elsys.PPP.trip.service;

import org.elsys.PPP.trip.entity.Location;
import org.elsys.PPP.trip.entity.Path;
import org.elsys.PPP.trip.entity.Trip;
import org.elsys.PPP.trip.repository.TripRepository;
import org.elsys.PPP.user.entity.User;
import org.elsys.PPP.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserService userService;

    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();

        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    public List<Trip> getAllFutureTrips() {
        return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
                .filter(t -> t.getStartDate().compareTo(new Date(Calendar.getInstance().getTime().getTime())) >= 0)
                .collect(Collectors.toList());
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

    public void deleteTripById(int userID, int tripID) {
        Trip trip = this.getTripById(tripID);
        User user = userService.getUserById(userID);

        if (trip.getOrganizer() == user) {
            tripRepository.deleteById(tripID);
        }
    }

    public void createTrip(String tripName, int userID, int allSpots, String description, int price,
                           String startDateString, String endDateString) {
        User user = userService.getUserById(userID);

        Date startDate = Date.valueOf(startDateString);
        Date endDate = Date.valueOf(endDateString);

        Trip trip =  new Trip(tripName, user, allSpots, description, price, startDate, endDate);

        this.addOrUpdateTrip(trip);
    }

    public List<Trip> getTripForUser(int userId) {
        return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
                .filter(t -> t.getBookedSpots().stream().anyMatch(bs -> bs.getUser().getId() == userId))
                .collect(Collectors.toList());
    }

    public List<Trip> getPastTrips() {
        return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
                .filter(t -> t.getStartDate().compareTo(new Date(Calendar.getInstance().getTime().getTime())) < 0)
                .collect(Collectors.toList());
    }

    public List<Trip> getPastTripsForUser(int userId) {
        return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
                .filter(t -> t.getStartDate().compareTo(new Date(Calendar.getInstance().getTime().getTime())) < 0
                && t.getBookedSpots().stream().anyMatch(bs -> bs.getUser().getId() == userId))
                .collect(Collectors.toList());
    }
}

