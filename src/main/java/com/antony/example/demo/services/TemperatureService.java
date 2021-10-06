package com.antony.example.demo.services;

import java.util.Collection;

public interface TemperatureService {

    void saveTemperatures(Collection<Double> temperatures, Long idMeteorology);

    void deleteAllTemperature();
}
