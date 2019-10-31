package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocationController.class)
class LocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final LocationDto locationDto = LocationDto.builder()
            .name("TestLocation")
            .build();

    private final Long id = 999L;

    private static final String URL = "/api/v1/location/";

    @Test
    void createNewLocation() throws Exception {
        String locationToJson = objectMapper.writeValueAsString(locationDto);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(locationToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getLocationById() throws Exception {
        mockMvc.perform(get(URL +  this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateLocationById() throws Exception {
        String locationToJson = objectMapper.writeValueAsString(locationDto);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(locationToJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteLocationById() throws Exception {
        mockMvc.perform(delete(URL +  this.id)).andExpect(status().isNoContent());
    }

}
