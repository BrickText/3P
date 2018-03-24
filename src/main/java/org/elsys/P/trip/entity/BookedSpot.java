package org.elsys.P.trip.entity;

import org.elsys.P.trip.entity.enums.BookingStatus;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;

@Entity
public class BookedSpot {
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

    public BookedSpot() {}

    public BookedSpot(User user, Trip trip, BookingStatus bookingStatus) {
        this.user = user;
        this.trip = trip;
        this.bookingStatus = bookingStatus;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
