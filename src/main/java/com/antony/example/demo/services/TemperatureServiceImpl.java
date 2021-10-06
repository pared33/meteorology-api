package com.antony.example.demo.services;

import com.antony.example.demo.models.entity.Temperature;
import com.antony.example.demo.models.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureRepository repository;

    @Override
    public void saveTemperatures(Collection<Double> temperatures, Long idMeteorology) {

        int hour = 0;
        for (Double temperature : temperatures) {
            repository.save(Temperature.builder()
                    .hour(hour++)
                    .temperature(temperature)
                    .idMeteorology(idMeteorology)
                    .build());
        }

    }

    @Override
    public void deleteAllTemperature() {
        repository.deleteAll();
    }
}
