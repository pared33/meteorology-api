package com.antony.example.demo.controllers;

import com.antony.example.demo.controllers.request.MeteorologyRequest;
import com.antony.example.demo.services.MeteorologyService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
public class MeteorologyController {

    @Autowired
    private MeteorologyService meteorologyService;

    @PostMapping("/weather")
    public ResponseEntity<?> createDeliveryPlan(@RequestBody() MeteorologyRequest meteorologyRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            meteorologyService.saveMeteorology(meteorologyRequest);
        } catch (DuplicateKeyException e) {
            response.put("mensaje", "Error at save object");
            response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.PRECONDITION_FAILED);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(meteorologyRequest);
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getAllMeteorology(@RequestParam(required = false) String date) throws NotFoundException {
        Map<String, Object> response = new HashMap<>();
        try {
            return ResponseEntity.status(HttpStatus.OK).body(meteorologyService.getAllMeteorology(date));
        } catch (NotFoundException e) {
            response.put("mensaje", "Error");
            response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllMeteorology() {
        meteorologyService.deleteAllMeteorology();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
