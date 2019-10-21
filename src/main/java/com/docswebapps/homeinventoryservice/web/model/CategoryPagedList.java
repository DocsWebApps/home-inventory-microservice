package com.docswebapps.homeinventoryservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryPagedList extends PageImpl<CategoryDto> {
    public CategoryPagedList(List<CategoryDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CategoryPagedList(List<CategoryDto> content) {
        super(content);
    }
}
