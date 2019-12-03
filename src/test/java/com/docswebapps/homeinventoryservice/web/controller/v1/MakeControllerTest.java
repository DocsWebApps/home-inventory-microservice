package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.MakeService;
import com.docswebapps.homeinventoryservice.web.model.MakeDto;
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

@WebMvcTest(MakeController.class)
class MakeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MakeService makeService;

    private static final String URL= "/api/v1/make/";

    private final MakeDto makeDto = MakeDto.builder()
            .name("TestMake")
            .build();

    private final Long id = 1L;

    @Test
    void getAllMakes() throws Exception {
        // Happy Path
        when(this.makeService.getAllMakes()).thenReturn(Collections.singletonList(this.makeDto));
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Sad Path
        when(this.makeService.getAllMakes()).thenReturn(new ArrayList<>());
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void createNewMake() throws Exception {
        String makeDtoJson = objectMapper.writeValueAsString(makeDto);
        when(this.makeService.saveMake(any(MakeDto.class))).thenReturn(this.id);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getMakeById() throws Exception {
        // Happy Path
        when(this.makeService.getMakeById(anyLong())).thenReturn(makeDto);
        mockMvc.perform(get(URL +  this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Sad Path
        when(this.makeService.getMakeById(anyLong())).thenReturn(MakeDto.builder().build());
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateMakeById() throws Exception {
        String makeDtoJson = objectMapper.writeValueAsString(makeDto);
        // Happy Path
        when(this.makeService.updateMake(anyLong(), any(MakeDto.class))).thenReturn(true);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeDtoJson))
                .andExpect(status().isNoContent());

        // Sad Path
        when(this.makeService.updateMake(anyLong(), any(MakeDto.class))).thenReturn(false);
        mockMvc.perform(put(URL + this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(makeDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error updating make, contact an administrator!", result.getResponse().getContentAsString());
                });
    }

    @Test
    void deleteMakeById() throws Exception {
        // Happy Path
        when(this.makeService.deleteMake(anyLong())).thenReturn(true);
        mockMvc.perform(delete(URL +  this.id)).andExpect(status().isNoContent());

        // Sad Path
        when(this.makeService.deleteMake(anyLong())).thenReturn(false);
        mockMvc.perform(delete(URL +  this.id))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error deleting make, contact an administrator!", result.getResponse().getContentAsString());
                });
    }
}
