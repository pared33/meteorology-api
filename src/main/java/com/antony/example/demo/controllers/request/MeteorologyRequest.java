package com.antony.example.demo.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeteorologyRequest {

    private Long id;
    private LocalDate date;
    private LocationRequest  location;
    private List<Double> temperature;
}
