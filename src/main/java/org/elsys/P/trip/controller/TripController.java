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

//    Couldn't find possible way to convert dynamically String to SQL Datetime
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void CreateTrip(@RequestParam("allSpots") int allSpots, @RequestParam("freeSpots") int freeSpots,
                           @RequestParam("price") int price) {
        System.out.println(allSpots);
        tripService.createTrip(allSpots, freeSpots, price, new Date(Calendar.getInstance().getTime().getTime()),
                new Date(Calendar.getInstance().getTime().getTime()));
    }

    @RequestMapping(value="/t", method= RequestMethod.GET)
    public String test() {
        return "Test";
    }
}
