package com.antony.example.demo.models.repository;

import com.antony.example.demo.models.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature,Long> {
}
