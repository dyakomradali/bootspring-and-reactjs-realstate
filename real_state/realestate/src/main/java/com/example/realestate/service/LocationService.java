package com.example.realestate.service;

import com.example.realestate.model.Location;
import com.example.realestate.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public void addlocation(Location lo) {
        locationRepository.save(lo);
    }

    public Location getbyid(int id) {
        return locationRepository.findById(id).orElse(null);
    }

    public void updatelocation(Location lo) {
        locationRepository.save(lo);
    }

    public void deletelocationbyid(int id) {
        locationRepository.deleteById(id);
    }

    public void deleteall() {
        locationRepository.deleteAll();
    }

    public Page<Location> getAllPaginated(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }
}
