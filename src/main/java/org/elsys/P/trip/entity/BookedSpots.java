package org.elsys.P.trip.entity;

import org.elsys.P.trip.entity.enums.BookingStatus;

import javax.persistence.*;

@Entity
public class BookedSpots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private User user;

    private BookingStatus bookingStatus;

    private Trip trip;
}
