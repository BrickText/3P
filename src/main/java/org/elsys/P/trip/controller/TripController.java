package org.elsys.P.trip.controller;

import org.elsys.P.trip.entity.Trip;
import org.elsys.P.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value="/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Trip> getAllTrips() {
        System.out.println("Getting all trips was called");
        return tripService.getAllTrips();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void CreateTrip(@RequestParam("user") int userID, @RequestParam("allSpots") int allSpots,
                           @RequestParam("description") String description, @RequestParam("price") int price,
                           @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        tripService.createTrip(userID, allSpots, description, price, startDate, endDate);
    }

    @RequestMapping(value="/t", method= RequestMethod.GET)
    public String test() {
        return "Test";
    }
}
