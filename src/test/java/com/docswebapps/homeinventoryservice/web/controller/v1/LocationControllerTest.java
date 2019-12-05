package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.LocationService;
import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocationController.class)
class LocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LocationService locationService;

    @Autowired
    private ObjectMapper objectMapper;

    private final LocationDto locationDto = LocationDto.builder()
            .name("TestLocation")
            .build();

    private final Long id = 1L;

    private static final String URL = "/api/v1/location/";

    @Test
    void getAllLocations() throws Exception {
        // Happy Path
        when(this.locationService.getAllLocations()).thenReturn(Arrays.asList(LocationDto.builder().build(), LocationDto.builder().build()));
        this.mockMvc.perform(get(URL)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        // Sad Path
        when(this.locationService.getAllLocations()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get(URL)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    void createNewLocation() throws Exception {
        String locationToJson = objectMapper.writeValueAsString(locationDto);
        when(this.locationService.saveLocation(any(LocationDto.class))).thenReturn(this.id);
        this.mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(locationToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getLocationById() throws Exception {
        // Happy Path
        when(this.locationService.getLocationById(anyLong())).thenReturn(this.locationDto);
        this.mockMvc.perform(get(URL +  this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.locationService.getLocationById(anyLong())).thenReturn(null);
        this.mockMvc.perform(get(URL)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    void updateLocationById() throws Exception {
        String locationToJson = objectMapper.writeValueAsString(locationDto);
        // Happy Path
        when(this.locationService.updateLocation(anyLong(),any(LocationDto.class))).thenReturn(true);
        this.mockMvc.perform(put(URL + this.id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(locationToJson))
                    .andExpect(status().isNoContent());
        // Sad Path
        when(this.locationService.updateLocation(anyLong(),any(LocationDto.class))).thenReturn(false);
        this.mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(locationToJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error updating category, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

    @Test
    void deleteLocationById() throws Exception {
        // Happy Path
        when(this.locationService.deleteLocation(anyLong())).thenReturn(true);
        this.mockMvc.perform(delete(URL +  this.id)).andExpect(status().isNoContent());
        // Sad Path
        when(this.locationService.deleteLocation(anyLong())).thenReturn(false);
        this.mockMvc.perform(delete(URL + this.id))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error deleting category, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

}
