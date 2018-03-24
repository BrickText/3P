package org.elsys.P.trip.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="trip", schema = "public")
public class Trip {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
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

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<BookedSpot> bookedSpots;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Path> paths;

    public Trip() {}

    public Trip(int id, User organizer, int allSpots, int freeSpots, String description, int price,
                Date startDate, Date endDate, List<BookedSpot> bookedSpots, List<Path> paths) {
        this.id = id;
        this.organizer = organizer;
        this.allSpots = allSpots;
        this.freeSpots = freeSpots;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookedSpots = bookedSpots;
        this.paths = paths;
    }

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

    public List<Path> getPaths() {
        return paths;
    }
}
