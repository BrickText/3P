package org.elsys.PPP.trip.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.elsys.PPP.trip.entity.enums.BookingStatus;
import org.elsys.PPP.user.entity.User;
import org.elsys.PPP.views.View;

import javax.persistence.*;

@Entity
@Table(name="booked_spot", schema = "public")
public class BookedSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(View.Summary.class)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    @JsonView(View.Summary.class)
    private Trip trip;

    @JsonView(View.Summary.class)
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
