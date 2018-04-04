package org.elsys.PPP.trip.controller;

import org.elsys.PPP.trip.entity.Trip;
import org.elsys.PPP.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    public List<Trip> getAllFutureTrips() {
        return tripService.getAllFutureTrips();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Trip getTripById(@PathVariable int id) {
        return tripService.getTripById(id);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public List<Trip> getTripForUser(@PathVariable int userId) {
        return tripService.getTripForUser(userId);
    }

    @RequestMapping(value = "/past", method = RequestMethod.GET)
    public List<Trip> getPastTrips() {
        return tripService.getPastTrips();
    }

    @RequestMapping(value = "/past/{id}", method = RequestMethod.GET)
    public List<Trip> getPastTripsForUser(@PathVariable int id) {
        return tripService.getPastTripsForUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createTrip(@RequestParam("userId") int userID, @RequestParam("allSpots") int allSpots,
                           @RequestParam("description") String description, @RequestParam("price") int price,
                           @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        System.out.println(userID + allSpots + description + price + startDate + endDate);
        tripService.createTrip(userID, allSpots, description, price, startDate, endDate);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTrip(@RequestParam("userId") int userID, @RequestParam("tripId") int tripID) {
        tripService.deleteTripById(userID, tripID);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}
