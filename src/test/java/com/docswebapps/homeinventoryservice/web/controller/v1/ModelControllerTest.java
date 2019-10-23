package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.ModelDto;
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

@WebMvcTest(ModelController.class)
class ModelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL= "/api/v1/model/";

    private ModelDto modelDto = ModelDto.builder()
            .id(999L)
            .name("TestModel")
            .createdDate(OffsetDateTime.now(ZoneId.systemDefault()))
            .lastModifiedDate(OffsetDateTime.now(ZoneId.systemDefault()))
            .build();

    @Test
    void createNewModel() throws Exception {
        String modelDtoJson = objectMapper.writeValueAsString(modelDto);

        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(modelDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getModelById() throws Exception {
        mockMvc.perform(get(URL + modelDto.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateModelById() throws Exception {
        String modelDtoJson = objectMapper.writeValueAsString(modelDto);

        mockMvc.perform(put(URL + modelDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(modelDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteModelById() throws Exception {
        mockMvc.perform(delete(URL + modelDto.getId())).andExpect(status().isNoContent());
    }
}
