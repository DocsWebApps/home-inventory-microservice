package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.MakeDto;
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

@WebMvcTest(MakeController.class)
class MakeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL= "/api/v1/make/";

    private MakeDto makeDto = MakeDto.builder()
            .id(999L)
            .name("TestMake")
            .createdDate(OffsetDateTime.now(ZoneId.systemDefault()))
            .lastModifiedDate(OffsetDateTime.now(ZoneId.systemDefault()))
            .build();

    @Test
    void createNewMake() throws Exception {
        String makeDtoJson = objectMapper.writeValueAsString(makeDto);

        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getMakeById() throws Exception {
        mockMvc.perform(get(URL + makeDto.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateMakeById() throws Exception {
        String makeDtoJson = objectMapper.writeValueAsString(makeDto);

        mockMvc.perform(put(URL + makeDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteMakeById() throws Exception {
        mockMvc.perform(delete(URL + makeDto.getId())).andExpect(status().isNoContent());
    }
}
