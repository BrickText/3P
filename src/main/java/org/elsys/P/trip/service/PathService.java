package org.elsys.P.trip.service;

import org.elsys.P.trip.entity.Path;
import org.elsys.P.trip.entity.Trip;
import org.elsys.P.trip.repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathService {
    @Autowired
    private PathRepository pathRepository;

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
}
