package com.antony.example.demo.controllers;

import com.antony.example.demo.controllers.request.MeteorologyRequest;
import com.antony.example.demo.services.MeteorologyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MeteorologyController.class)
class MeteorologyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MeteorologyController meteorologyController;

    @MockBean
    MeteorologyService meteorologyServiceMock;

    @BeforeEach
    void setUp() {
        reset(meteorologyServiceMock);
    }

    @Test
    void contextLoads() {
        assertNotNull(meteorologyController);
    }

    @Test
    void createDeliveryPlan() throws Exception {
        MeteorologyRequest request = MeteorologyRequest.builder().build();
        this.mockMvc.perform(post("/weather").contentType(MediaType.APPLICATION_JSON).content(asJsonString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllMeteorology() throws Exception {
        this.mockMvc.perform(get("/weather").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAllMeteorology() throws Exception {
        this.mockMvc.perform(delete("/delete").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
