package org.elsys.P.trip.entity;

import org.elsys.P.trip.entity.enums.BookingStatus;

import javax.persistence.*;

@Entity
public class BookedSpots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private BookingStatus bookingStatus;
}
