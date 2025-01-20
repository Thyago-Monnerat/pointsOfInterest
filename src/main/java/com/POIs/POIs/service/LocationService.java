package com.POIs.POIs.service;

import com.POIs.POIs.Exceptions.LocationAlreadyExistsException;
import com.POIs.POIs.model.LocationModel;
import com.POIs.POIs.model.UserReference;
import com.POIs.POIs.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.POIs.POIs.util.DistanceCalculate.euclideanDistanceFormula;
import static com.POIs.POIs.util.ValidateCoords.validateCoords;
import static com.POIs.POIs.util.ValidateDistance.validateDistance;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<String> calculateDistance(UserReference userReference) {

        validateCoords(userReference.getUserX(), userReference.getUserY());
        validateDistance(userReference.getDistance());


        List<LocationModel> locations = locationRepository.findAll();
        List<String> poiList = new ArrayList<>();


        if (!locations.isEmpty()) {
            for (LocationModel lm : locations) {
                double result = euclideanDistanceFormula(lm.getXcoord(), userReference.getUserX(), lm.getYcoord(), userReference.getUserY());
                if (result < userReference.getDistance()) {
                    poiList.add(lm.getName());
                }
            }
        }

        return poiList;
    }

    public String saveLocation(LocationModel locationModel) {

        validateCoords(locationModel.getXcoord(), locationModel.getYcoord());

        if (locationRepository.existsByName(locationModel.getName())) {
            throw new LocationAlreadyExistsException("Local já existe!");
        }
        locationRepository.save(locationModel);


        return "Salvo com sucesso!";
    }


}
