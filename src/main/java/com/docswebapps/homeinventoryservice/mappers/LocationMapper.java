package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Location;
import com.docswebapps.homeinventoryservice.web.model.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class)
public interface LocationMapper {
    @Mapping(target="version", ignore = true)
    @Mapping(target = "items", ignore = true)
    Location locationDtoToLocation(LocationDto locationDto);

    LocationDto locationToLocationDto(Location location);
}
