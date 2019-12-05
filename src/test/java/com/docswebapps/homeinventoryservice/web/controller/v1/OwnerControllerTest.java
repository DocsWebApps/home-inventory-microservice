package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.OwnerService;
import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OwnerController.class)
class OwnerControllerTest {
    private static final String URL = "/api/v1/owner/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Autowired
    private ObjectMapper objectMapper;

    private final OwnerDto ownerDto = OwnerDto.builder()
            .name("TestOwner")
            .build();

    private final Long id = 1L;

    @Test
    void getAllOwners() throws Exception {
        // Happy Path
        when(this.ownerService.getAllOwners()).thenReturn(Collections.singletonList(this.ownerDto));
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.ownerService.getAllOwners()).thenReturn(new ArrayList<>());
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void createNewOwner() throws Exception {
        String ownerToJson = objectMapper.writeValueAsString(ownerDto);
        when(this.ownerService.saveOwner(any(OwnerDto.class))).thenReturn(this.id);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ownerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getOwnerById() throws Exception {
        // Happy Path
        when(this.ownerService.getOwnerById(anyLong())).thenReturn(ownerDto);
        mockMvc.perform(get(URL +  this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.ownerService.getOwnerById(anyLong())).thenReturn(null);
        mockMvc.perform(get(URL + this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateOwnerById() throws Exception {
        // Happy Path
        String ownerToJson = objectMapper.writeValueAsString(ownerDto);
        when(this.ownerService.updateOwner(anyLong(), any(OwnerDto.class))).thenReturn(true);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ownerToJson))
                .andExpect(status().isNoContent());
        // Sad Path
        when(this.ownerService.updateOwner(anyLong(), any(OwnerDto.class))).thenReturn(false);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ownerToJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error updating owner, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

    @Test
    void deleteOwnerById() throws Exception {
        // Happy Path
        when(this.ownerService.deleteOwner(anyLong())).thenReturn(true);
        mockMvc.perform(delete(URL +  this.id)).andExpect(status().isNoContent());
        // Sad Path
        when(this.ownerService.deleteOwner(anyLong())).thenReturn(false);
        mockMvc.perform(delete(URL + this.id))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error deleting owner, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

}
