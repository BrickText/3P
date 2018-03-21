package org.elsys.P.trip.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location currentLocation;

    @OneToMany(mappedBy = "organizer")
    private List<Trip> trips;

    @OneToMany(mappedBy = "user")
    private List<BookedSpots> bookedSpots;

    private String facebookAuthenticationToken;

    public int getId() {
        return id;
    }

    public String getUseriname() {
        return username;
    }

    public void setUseriname(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getFacebookAuthenticationToken() {
        return facebookAuthenticationToken;
    }

    public void setFacebookAuthenticationToken(String facebookAuthenticationToken) {
        this.facebookAuthenticationToken = facebookAuthenticationToken;
    }
}
