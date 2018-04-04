package org.elsys.PPP.trip.controller;

import org.elsys.PPP.trip.entity.Location;
import org.elsys.PPP.trip.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createLocation(@RequestParam("name") String name,
                               @RequestParam("longitude") int lng, @RequestParam("latitude") int lat,
                               @RequestParam("description") String description) {
        locationService.createLocation(name, lng, lat, description);
    }

    @RequestMapping(value = "/withpath", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createLocation(@RequestParam("name") String name,
                               @RequestParam("longitude") int lng, @RequestParam("latitude") int lat,
                               @RequestParam("description") String description, @RequestParam("pathId") int pathId) {
        locationService.createLocation(name, lng, lat, description, pathId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLocation(@RequestParam("userId") int userId, @RequestParam("locationId") int locationId) {
        locationService.deleteLocation(locationId, userId);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Location getUserLocation(@PathVariable int id) {
        return getUserLocation(id);
    }
}
