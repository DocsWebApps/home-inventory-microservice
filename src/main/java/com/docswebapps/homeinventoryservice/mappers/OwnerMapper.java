package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Owner;
import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface OwnerMapper {
    OwnerDto ownerToOwnerDto(Owner owner);

    @Mapping(target="version", ignore = true)
    @Mapping(target="items", ignore = true)
    Owner ownerDtoToOwner(OwnerDto ownerDto);
}
