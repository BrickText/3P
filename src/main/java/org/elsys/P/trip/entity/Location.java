package org.elsys.P.trip.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int longtitude;

    @OneToOne
    @JoinColumn(name = "path_id")
    private Path path;

    @NotNull
    private int latitude;

    @NotNull
    private String description;

    @OneToMany(mappedBy = "currentLocation")
    private List<User> users;

    public Location() {}

    public Location(@NotNull String name, @NotNull int longtitude, Path path,
                    @NotNull int latitude, @NotNull String description, List<User> users) {
        this.name = name;
        this.longtitude = longtitude;
        this.path = path;
        this.latitude = latitude;
        this.description = description;
        this.users = users;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> user) {
        this.users = user;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(int longtitude) {
        this.longtitude = longtitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
