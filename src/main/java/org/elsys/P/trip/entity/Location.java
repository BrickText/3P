package org.elsys.P.trip.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int longtitude;

    @NotNull
    private int latitude;
}
