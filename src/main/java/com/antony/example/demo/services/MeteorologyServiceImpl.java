package com.antony.example.demo.services;

import com.antony.example.demo.controllers.request.MeteorologyRequest;
import com.antony.example.demo.models.entity.Meteorology;
import com.antony.example.demo.models.repository.MeteorologyRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class MeteorologyServiceImpl implements MeteorologyService {

    @Autowired
    private MeteorologyRepository repository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private TemperatureService temperatureService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void saveMeteorology(MeteorologyRequest meteorologyRequest) {

        if (repository.findById(meteorologyRequest.getId()).isPresent()) {
            throw new DuplicateKeyException("Duplicate id");
        }

        Meteorology meteorology = Meteorology.builder()
                .id(meteorologyRequest.getId())
                .date(meteorologyRequest.getDate())
                .idLocation(locationService.saveLocation(meteorologyRequest.getLocation()))
                .build();

        repository.save(meteorology);

        temperatureService.saveTemperatures(meteorologyRequest.getTemperature(), meteorology.getId());

    }

    @Override
    public Collection<Meteorology> getAllMeteorology(String date) throws NotFoundException {
        if (date != null) {
            Collection<Meteorology> meteorologies = repository.findAllByDate(LocalDate.parse(date)).stream()
                    .sorted(Comparator.comparingLong(Meteorology::getId))
                    .collect(Collectors.toList());

            if (meteorologies.isEmpty()) {
                throw new NotFoundException("not information");
            } else
                return meteorologies;
        }
        return repository.findAll().stream()
                .sorted(Comparator.comparingLong(Meteorology::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllMeteorology() {
//        locationService.deleteAllLocations();
//        temperatureService.deleteAllTemperature();
        repository.deleteAll();
    }


}
