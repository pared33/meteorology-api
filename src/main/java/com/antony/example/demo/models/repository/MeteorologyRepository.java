package com.antony.example.demo.models.repository;

import com.antony.example.demo.models.entity.Meteorology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MeteorologyRepository  extends JpaRepository<Meteorology,Long> {

    List<Meteorology> findAllByDate(LocalDate date);
}
