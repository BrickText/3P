package org.elsys.PPP.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.elsys.PPP.trip.entity.BookedSpot;
import org.elsys.PPP.trip.entity.Location;
import org.elsys.PPP.trip.entity.Trip;
import org.elsys.PPP.views.View;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private int id;

    @NotNull
    @JsonView(View.Summary.class)
    private String username;

    @NotNull
    @JsonIgnore
    private String password;

    @NotNull
    @JsonView(View.Summary.class)
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location currentLocation;

    @OneToMany(mappedBy = "organizer")
    private List<Trip> trips;

    @OneToMany(mappedBy = "user")
    private List<BookedSpot> bookedSpots;

    private String facebookAuthenticationToken;

    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonIgnore
    private Collection<Role> roles;

    public User() {}

    public User(@NotNull String username, @NotNull String firstName, @NotNull String lastName,
                @NotNull String password, @NotNull String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User(@NotNull String username, @NotNull String password, @NotNull String email,
                String profilePicture, Location currentLocation, List<Trip> trips,
                List<BookedSpot> bookedSpots, String facebookAuthenticationToken) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.currentLocation = currentLocation;
        this.trips = trips;
        this.bookedSpots = bookedSpots;
        this.facebookAuthenticationToken = facebookAuthenticationToken;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }


    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
}
