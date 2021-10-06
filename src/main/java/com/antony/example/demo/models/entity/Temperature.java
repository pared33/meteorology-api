package com.antony.example.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "temperatures")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_meteorology")
    private Long idMeteorology;

    @Column(name = "hour")
    private Integer hour;

    @Column(name = "temperature")
    private Double temperature;

}
