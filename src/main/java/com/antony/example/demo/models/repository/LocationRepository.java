package com.antony.example.demo.models.repository;

import com.antony.example.demo.models.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
