package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface MakeMapper {
    MakeDto makeToMakeDto(Make make);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "models", ignore = true)
    Make makeDtoToMake(MakeDto makeDto);
}
