package com.docswebapps.homeinventoryservice.service;

import com.docswebapps.homeinventoryservice.web.model.OwnerDto;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getAllOwners();
    OwnerDto getOwnerById(Long id);
    Long saveOwner(OwnerDto ownerDto);
    boolean updateOwner(Long id, OwnerDto ownerDto);
    boolean deleteOwner(Long id);
}
