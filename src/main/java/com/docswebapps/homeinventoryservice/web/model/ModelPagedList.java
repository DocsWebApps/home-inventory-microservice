package com.docswebapps.homeinventoryservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ModelPagedList extends PageImpl<ModelDto> {

    public ModelPagedList(List<ModelDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public ModelPagedList(List<ModelDto> content) {
        super(content);
    }
}
