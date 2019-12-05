package com.docswebapps.homeinventoryservice.service;

import com.docswebapps.homeinventoryservice.web.model.ModelDto;

import java.util.List;

public interface ModelService {
    List<ModelDto> getAllModels();
    ModelDto getModelById(Long id);
    Long saveModel(ModelDto modelDto);
    boolean updateModel(Long id, ModelDto modelDto);
    boolean deleteModel(Long id);
}
