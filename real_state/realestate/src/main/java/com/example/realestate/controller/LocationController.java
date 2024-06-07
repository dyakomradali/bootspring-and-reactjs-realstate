package com.example.realestate.controller;

import com.example.realestate.model.Location;
import com.example.realestate.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/getAll")
    public List<Location> showAll() {
        return locationService.getAll();
    }

    @PostMapping("/add")
    public void save(@RequestBody Location location) {
        locationService.addlocation(location);
    }

    @GetMapping("/getById")
    public Location show(@RequestParam int id) {
        return locationService.getbyid(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Location location) {
        locationService.updatelocation(location);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        locationService.deleteall();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        locationService.deletelocationbyid(id);
    }

    @GetMapping("/getAllPaginated")
    public Page<Location> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return locationService.getAllPaginated(pageable);
    }
}
