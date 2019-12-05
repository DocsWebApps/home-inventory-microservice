package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.service.ModelService;
import com.docswebapps.homeinventoryservice.web.model.ModelDto;
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

@WebMvcTest(ModelController.class)
class ModelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelService modelService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL= "/api/v1/model/";

    private final ModelDto modelDto = ModelDto.builder()
            .name("TestModel")
            .modelMake(Make.builder().name("TestMake").build())
            .build();

    private final Long id = 1L;

    @Test
    void getAllModels() throws Exception {
        // Happy Path
        when(this.modelService.getAllModels()).thenReturn(Collections.singletonList(this.modelDto));
        this.mockMvc.perform(get(URL)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        // Sad Path
        when(this.modelService.getAllModels()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get(URL)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    void createNewModel() throws Exception {
        String modelDtoJson = objectMapper.writeValueAsString(modelDto);
        // Happy Path
        when(this.modelService.saveModel(any(ModelDto.class))).thenReturn(this.id);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(modelDtoJson))
                .andExpect(status().isCreated());
        // Sad Path
        when(this.modelService.saveModel(any(ModelDto.class))).thenReturn(-1L);
        this.mockMvc.perform(post(URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(modelDtoJson))
                    .andExpect(status().isBadRequest())
                    .andExpect(result -> {
                        assertEquals("Error saving model, contact an administrator!", result.getResponse().getContentAsString());
                    });
    }

    @Test
    void getModelById() throws Exception {
        // Happy Path
        when(this.modelService.getModelById(anyLong())).thenReturn(this.modelDto);
        this.mockMvc.perform(get(URL +  this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.modelService.getModelById(anyLong())).thenReturn(null);
        this.mockMvc.perform(get(URL + this.id)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    void updateModelById() throws Exception {
        String modelDtoJson = objectMapper.writeValueAsString(modelDto);
        // Happy Path
        when(this.modelService.updateModel(anyLong(),any(ModelDto.class))).thenReturn(true);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(modelDtoJson))
                .andExpect(status().isNoContent());
        // Sad Path
        when(this.modelService.updateModel(anyLong(),any(ModelDto.class))).thenReturn(false);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(modelDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error updating model, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

    @Test
    void deleteModelById() throws Exception {
        String modelDtoJson = objectMapper.writeValueAsString(modelDto);
        // Happy Path
        when(this.modelService.deleteModel(anyLong())).thenReturn(true);
        mockMvc.perform(delete(URL +  this.id))
                .andExpect(status().isNoContent());
        // Sad Path
        when(this.modelService.deleteModel(anyLong())).thenReturn(false);
        mockMvc.perform(delete(URL +  this.id))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error deleting model, contact an administrator!", result.getResponse().getContentAsString());
                });
    }
}
