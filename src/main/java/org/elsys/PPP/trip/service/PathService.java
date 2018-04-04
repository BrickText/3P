package org.elsys.PPP.trip.service;

import org.elsys.PPP.trip.entity.Location;
import org.elsys.PPP.trip.entity.Path;
import org.elsys.PPP.trip.entity.Trip;
import org.elsys.PPP.trip.entity.enums.Transport;
import org.elsys.PPP.trip.repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PathService {
    @Autowired
    private PathRepository pathRepository;

    @Autowired
    private TripService tripService;

    @Autowired LocationService locationService;

    public List<Path> getAllPaths() {
        List<Path> Paths = new ArrayList<>();

        pathRepository.findAll().forEach(Paths::add);
        return Paths;
    }

    public Path getPathById(int id) {
        return pathRepository.findById(id).get();
    }

    public void updatePath(int id, Path Path) {
        if (Path.getId() == id) {
            pathRepository.save(Path);
        }
    }

    public void addOrUpdatePath(Path Path) {
        pathRepository.save(Path);
    }

    public void deletePathById(int id) {
        pathRepository.deleteById(id);
    }

    public void createPath(int tripId, String transportTypeStr, String fromDate, String toDate,
                           int locationId, int orderNum) {
        Trip trip = tripService.getTripById(tripId);
        Transport transportType = Transport.stringToTransport(transportTypeStr);
        Location location = locationService.getLocationById(locationId);

        Path path = new Path(trip, transportType, Date.valueOf(fromDate), Date.valueOf(toDate),
                location, orderNum);
        addOrUpdatePath(path);
    }

    public void deletePathById(int tripId, int userId, int pathId) {

    }
}
