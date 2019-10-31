package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {
    private static final String URL = "/api/v1/category/";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final CategoryDto categoryDto = CategoryDto.builder()
            .name("CategoryTest")
            .build();

    private final Long id = 999L;

    @Test
    void createCategory() throws Exception {
        String categoryToJson = objectMapper.writeValueAsString(categoryDto);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getCategoryById() throws Exception {
        mockMvc.perform(get(URL + this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateCategoryById() throws Exception {
        String categoryToJson = objectMapper.writeValueAsString(categoryDto);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryToJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteCategoryById() throws Exception {
        mockMvc.perform(delete(URL +  this.id)).andExpect(status().isNoContent());
    }

}
