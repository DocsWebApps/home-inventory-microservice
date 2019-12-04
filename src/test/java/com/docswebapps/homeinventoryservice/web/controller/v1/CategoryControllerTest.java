package com.docswebapps.homeinventoryservice.web.controller.v1;

import com.docswebapps.homeinventoryservice.service.CategoryService;
import com.docswebapps.homeinventoryservice.web.model.CategoryDto;
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

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {
    private static final String URL = "/api/v1/category/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    private final CategoryDto categoryDto = CategoryDto.builder()
            .name("TestCategory")
            .build();

    private final Long id = 1L;

    @Test
    void getAllCategories() throws Exception {
        // Happy Path
        when(this.categoryService.getAllCategories())
                .thenReturn(Arrays.asList(CategoryDto.builder().build(), CategoryDto.builder().build()));
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.categoryService.getAllCategories()).thenReturn(new ArrayList<>());
        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void createCategory() throws Exception {
        String categoryToJson = objectMapper.writeValueAsString(categoryDto);
        when(this.categoryService.saveCategory(any(CategoryDto.class))).thenReturn(this.id);
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void getCategoryById() throws Exception {
        // Happy Path
        when(this.categoryService.getCategoryById(anyLong())).thenReturn(categoryDto);
        mockMvc.perform(get(URL + this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Sad Path
        when(this.categoryService.getCategoryById(anyLong())).thenReturn(null);
        mockMvc.perform(get(URL + this.id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateCategoryById() throws Exception {
        String categoryToJson = objectMapper.writeValueAsString(categoryDto);
        // Happy Path
        when(this.categoryService.updateCategory(anyLong(), any(CategoryDto.class))).thenReturn(true);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryToJson))
                .andExpect(status().isNoContent());
        // Sad Path
        when(this.categoryService.updateCategory(anyLong(), any(CategoryDto.class))).thenReturn(false);
        mockMvc.perform(put(URL +  this.id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(categoryToJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error updating category, contact an administrator!",
                            result.getResponse().getContentAsString());
                });
    }

    @Test
    void deleteCategoryById() throws Exception {
        String categoryToJson = objectMapper.writeValueAsString(categoryDto);
        // Happy Path
        when(this.categoryService.deleteCategory(anyLong())).thenReturn(true);
        mockMvc.perform(delete(URL +  this.id))
                .andExpect(status().isNoContent());
        // Sad Path
        when(this.categoryService.deleteCategory(anyLong())).thenReturn(false);
        mockMvc.perform(delete(URL +  this.id))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertEquals("Error deleting category, contact an administrator!",
                            result.getResponse().getContentAsString());
                });
    }

}
