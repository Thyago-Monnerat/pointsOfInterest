package com.POIs.POIs.repository;

import com.POIs.POIs.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<LocationModel, UUID> {
    boolean existsByName(String name);
}
