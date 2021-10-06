package com.antony.example.demo.services;

import com.antony.example.demo.controllers.request.LocationRequest;
import com.antony.example.demo.models.entity.Location;
import com.antony.example.demo.models.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Long saveLocation(LocationRequest locationRequest) {
        return repository.save(Location.builder()
                .lat(locationRequest.getLat())
                .lon(locationRequest.getLon())
                .city(locationRequest.getCity())
                .state(locationRequest.getState())
                .build()).getId();
    }

    @Override
    public void deleteAllLocations() {
        repository.deleteAll();
    }
}
