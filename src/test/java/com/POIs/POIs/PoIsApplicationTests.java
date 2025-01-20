package com.POIs.POIs;

import com.POIs.POIs.Exceptions.CoordLessThanZeroException;
import com.POIs.POIs.Exceptions.DistanceLessThanOneException;
import com.POIs.POIs.Exceptions.LocationAlreadyExistsException;
import com.POIs.POIs.model.LocationModel;
import com.POIs.POIs.model.UserReference;
import com.POIs.POIs.repository.LocationRepository;
import com.POIs.POIs.service.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PoIsApplicationTests {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @Test
    @DisplayName("Saving duplicated name")
    void ShouldThrowLocationAlreadyExistisException() {
        LocationModel locationModel = mock();

        when(locationModel.getName()).thenReturn("nameX");
        when(locationRepository.existsByName("nameX")).thenReturn(true);

        Assertions.assertThrows(LocationAlreadyExistsException.class, () -> locationService.saveLocation(locationModel));
    }

    @Test
    @DisplayName("Coords less than 0")
    void ShouldThrowhCoordsLessThanZeroException(){
        LocationModel locationModel = mock();

        when(locationModel.getYcoord()).thenReturn(-1);

        Assertions.assertThrows(CoordLessThanZeroException.class, ()->locationService.saveLocation(locationModel));
    }

    @Test
    @DisplayName("Distance less than 1")
    void ShoudThrowDistanceLessThanOneException(){
        UserReference userReference = mock();

        when(userReference.getDistance()).thenReturn(0);

        Assertions.assertThrows(DistanceLessThanOneException.class, ()->locationService.calculateDistance(userReference));
    }

}
