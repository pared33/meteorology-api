package com.antony.example.demo.services;

import com.antony.example.demo.controllers.request.MeteorologyRequest;
import com.antony.example.demo.models.entity.Meteorology;
import javassist.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;

public interface MeteorologyService {
    void saveMeteorology(MeteorologyRequest meteorologyRequest);
    Collection<Meteorology> getAllMeteorology(String date) throws NotFoundException;

    void deleteAllMeteorology();
}
