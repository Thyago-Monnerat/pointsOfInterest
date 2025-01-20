package com.POIs.POIs.controller;

import com.POIs.POIs.model.LocationModel;
import com.POIs.POIs.model.UserReference;
import com.POIs.POIs.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("nearby")
    public List<String> getLocations(@ModelAttribute UserReference userReference) {
        return locationService.calculateDistance(userReference);
    }

    @PostMapping("add")
    public String addLocation(@RequestBody LocationModel locationModel) {
        return locationService.saveLocation(locationModel);
    }
}

