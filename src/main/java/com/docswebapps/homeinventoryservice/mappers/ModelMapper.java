package com.docswebapps.homeinventoryservice.mappers;

import com.docswebapps.homeinventoryservice.domain.Model;
import com.docswebapps.homeinventoryservice.web.model.ModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface ModelMapper {
    ModelDto modelToModelDto(Model model);

    @Mapping(target="version", ignore = true)
    @Mapping(target="items", ignore = true)
    @Mapping(target = "modelMake", ignore = true)
    Model modelDtoToModel(ModelDto modelDto);
}
