package org.elsys.PPP.trip.service;

import org.elsys.PPP.trip.entity.*;
import org.elsys.PPP.trip.entity.enums.BookingStatus;
import org.elsys.PPP.trip.repository.BookedSpotsRepository;
import org.elsys.PPP.user.entity.User;
import org.elsys.PPP.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedSpotsService {
    @Autowired
    private BookedSpotsRepository bookedSpotsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    public List<BookedSpot> getAllBookedSpots() {
        List<BookedSpot> bookedSpots = new ArrayList<>();

        bookedSpotsRepository.findAll().forEach(bookedSpots::add);
        return bookedSpots;
    }

    public BookedSpot getBookedSpotById(int id) {
        return bookedSpotsRepository.findById(id).get();
    }

    public void updateBookedSpot(int id, BookedSpot bs) {
        if (bs.getId() == id) {
            bookedSpotsRepository.save(bs);
        }
    }

    public void addOrUpdateBookedSpot(BookedSpot bs) {
        bookedSpotsRepository.save(bs);
    }

    public void deleteBookedSpotById(int id) {
        bookedSpotsRepository.deleteById(id);
    }

    public void createBookedSpot (int userId, int tripId) {
        User user = userService.getUserById(userId);
        Trip trip = tripService.getTripById(tripId);
        BookingStatus bs = BookingStatus.NOT_CONFIRMED;

        this.addOrUpdateBookedSpot(new BookedSpot (user, trip, bs));
    }

    public void updateBookingStatus(User us, BookedSpot bSpot, BookingStatus bStatus) {
        if (bSpot.getTrip().getOrganizer() == us) {
            bSpot.setBookingStatus(bStatus);
            bookedSpotsRepository.save(bSpot);
        }
    }

    public void updateBookingStatus(int userId, int bookedSpotId, BookingStatus bs) {
      this.updateBookingStatus(userService.getUserById(userId),
      this.getBookedSpotById(bookedSpotId), bs);

    }
}
