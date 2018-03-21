package org.elsys.P.trip.entity;

import org.elsys.P.trip.entity.enums.Transport;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private Transport transportType;

    private Date fromDate;

    private Date toDate;

    private int orderNum;

    @OneToOne(mappedBy = "path")
    private Location location;

    public Path(Trip trip, Transport transportType, Date fromDate, Date toDate, Location location, int orderNum) {
        this.trip = trip;
        this.transportType = transportType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.location = location;
        this.orderNum = orderNum;
    }

    public int getId() {
        return id;
    }

    public Trip getTrip() {

        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Transport getTransportType() {
        return transportType;
    }

    public void setTransportType(Transport transportType) {
        this.transportType = transportType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
