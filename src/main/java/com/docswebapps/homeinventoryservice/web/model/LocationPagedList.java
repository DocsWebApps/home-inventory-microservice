package com.docswebapps.homeinventoryservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class LocationPagedList extends PageImpl<LocationDto> {
    public LocationPagedList(List<LocationDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public LocationPagedList(List<LocationDto> content) {
        super(content);
    }
}
