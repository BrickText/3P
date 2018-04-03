package org.elsys.P.trip.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.elsys.P.trip.entity.BookedSpot;
import org.elsys.P.trip.entity.enums.BookingStatus;
import org.elsys.P.trip.entity.views.View;
import org.elsys.P.trip.service.BookedSpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/bookedspots")
public class BookedSpotsController {
    @Autowired
    private BookedSpotsService bookedSpotsService;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(View.Summary.class)
    public List<BookedSpot> getAllBookedSpots () {
        return bookedSpotsService.getAllBookedSpots();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createBookedSpot (@RequestParam("userId") int userId, @RequestParam("tripId") int tripId) {
        bookedSpotsService.createBookedSpot(userId, tripId);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBookedSpot (@RequestParam("id") int id) {
        bookedSpotsService.deleteBookedSpotById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirm")
    @ResponseStatus(value = HttpStatus.OK)
    public void confirmBookedSpot (@RequestParam("userId") int userId,
                                  @RequestParam("bookedSpotId") int bookedSpotId) {

        bookedSpotsService.updateBookingStatus(userId, bookedSpotId, BookingStatus.CONFIRMED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/unconfirm")
    @ResponseStatus(value = HttpStatus.OK)
    public void unconfirmBookedSpot (@RequestParam("userId") int userId,
                                  @RequestParam("bookedSpotId") int bookedSpotId) {

        bookedSpotsService.updateBookingStatus(userId, bookedSpotId, BookingStatus.NOT_CONFIRMED);
    }

}
