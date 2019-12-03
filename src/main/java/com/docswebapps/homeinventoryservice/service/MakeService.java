package com.docswebapps.homeinventoryservice.service;

import com.docswebapps.homeinventoryservice.web.model.MakeDto;

import java.util.List;

public interface MakeService {
    List<MakeDto> getAllMakes();
    MakeDto getMakeById(Long id);
    Long saveMake(MakeDto makeDto);
    boolean updateMake(Long id, MakeDto makeDto);
    boolean deleteMake(Long id);
}
