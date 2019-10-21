package com.docswebapps.homeinventoryservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MakePagedList extends PageImpl<MakeDto> {
    public MakePagedList(List<MakeDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public MakePagedList(List<MakeDto> content) {
        super(content);
    }
}
