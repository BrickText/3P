package org.elsys.P.trip.entity;

import org.elsys.P.trip.entity.enums.Transport;

import javax.persistence.*;
import java.util.Date;

public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Trip trip;

    private Transport transportType;

    private Date fromDate;

    private Date toDate;

    private Location fromLocation;

    private Location toLocation;

}
