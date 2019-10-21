package com.docswebapps.homeinventoryservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OwnerPagedList extends PageImpl<OwnerDto> {
    public OwnerPagedList(List<OwnerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public OwnerPagedList(List<OwnerDto> content) {
        super(content);
    }
}
