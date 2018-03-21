package org.elsys.P.trip.service;

import org.elsys.P.trip.entity.*;
import org.elsys.P.trip.entity.enums.BookingStatus;
import org.elsys.P.trip.repository.BookedSpotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedSpotsService {
    @Autowired
    private BookedSpotsRepository bookedSpotsRepository;

    public List<BookedSpot> getAllLocations() {
        java.util.List<BookedSpot> bookedSpots = new ArrayList<>();

        bookedSpotsRepository.findAll().forEach(bookedSpots::add);
        return bookedSpots;
    }

    public BookedSpot getLocationById(int id) {
        return bookedSpotsRepository.findById(id).get();
    }

    public void updateLocation(int id, BookedSpot bs) {
        if (bs.getId() == id) {
            bookedSpotsRepository.save(bs);
        }
    }

    public void addOrUpdateLocation(BookedSpot bs) {
        bookedSpotsRepository.save(bs);
    }

    public void deleteLocationById(int id) {
        bookedSpotsRepository.deleteById(id);
    }

    public void updateBookingStatus(User us, BookedSpot bSpot, BookingStatus bStatus) {
        if (bSpot.getTrip().getOrganizer() == us) {
            bSpot.setBookingStatus(bStatus);
            bookedSpotsRepository.save(bSpot);
        }
    }
}
