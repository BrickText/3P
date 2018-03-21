package org.elsys.P.trip.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User organizer;

    @NotNull
    private int allSpots;

    @NotNull
    private int freeSpots;

    private String description;

    @NotNull
    private int price;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @OneToMany(mappedBy = "trip")
    private List<BookedSpots> bookedSpots;

    @OneToMany(mappedBy = "trip")
    private List<Path> paths;

    public int getId() {
        return id;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public int getAllSpots() {
        return allSpots;
    }

    public void setAllSpots(int allSpots) {
        this.allSpots = allSpots;
    }

    public int getFreeSpots() {
        return freeSpots;
    }

    public void setFreeSpots(int freeSpots) {
        this.freeSpots = freeSpots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
