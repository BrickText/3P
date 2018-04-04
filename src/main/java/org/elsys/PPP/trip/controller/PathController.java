package org.elsys.PPP.trip.controller;

import org.elsys.PPP.trip.entity.Path;
import org.elsys.PPP.trip.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/path")
public class PathController {

    @Autowired
    private PathService pathService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Path> getAllPaths() {
        return pathService.getAllPaths();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createPath(@RequestParam("tripId") int tripId,
                           @RequestParam("transportType") String transportType,
                           @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
                           @RequestParam("locationId") int locationId, @RequestParam("orderNum") int orderNum) {
        pathService.createPath(tripId, transportType, fromDate, toDate, locationId, orderNum);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePath(@RequestParam("tripId") int tripId, @RequestParam("userId") int userId,
                            @RequestParam("pathId") int pathId) {
        pathService.deletePathById(tripId, userId, pathId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Path getPath(@PathVariable int id) {
        return pathService.getPathById(id);
    }
}
