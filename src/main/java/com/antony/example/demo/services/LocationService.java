package com.antony.example.demo.services;

import com.antony.example.demo.controllers.request.LocationRequest;

public interface LocationService {

    Long  saveLocation(LocationRequest locationRequest);

    void deleteAllLocations();
}
