package com.antony.example.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "meteorology")
public class Meteorology {

    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "id_location")
    private Long idLocation;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_location", referencedColumnName = "id", insertable = false, updatable = false)
    private Location location;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_meteorology")
    private Collection<Temperature> temperatures;
}
