package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OwnerController.class)
class OwnerControllerTest {
    private static final String URL = "/api/v1/owner/";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private OwnerDto ownerDto = OwnerDto.builder()
            .id(999L)
            .firstName("TestFirstName")
            .lastName("TestLastName")
            .createdDate(OffsetDateTime.now(ZoneId.systemDefault()))
            .lastModifiedDate((OffsetDateTime.now(ZoneId.systemDefault())))
            .build();

    @Test
    void createNewOwner() throws Exception {
        String ownerToJson = objectMapper.writeValueAsString(ownerDto);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ownerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getOwnerById() throws Exception {
        mockMvc.perform(get(URL + ownerDto.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateOwnerById() throws Exception {
        String ownerToJson = objectMapper.writeValueAsString(ownerDto);
        mockMvc.perform(put(URL + ownerDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(ownerToJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteOwnerById() throws Exception {
        mockMvc.perform(delete(URL + ownerDto.getId())).andExpect(status().isNoContent());
    }

}
