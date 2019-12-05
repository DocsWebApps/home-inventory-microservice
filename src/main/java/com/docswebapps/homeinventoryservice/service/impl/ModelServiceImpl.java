package com.docswebapps.homeinventoryservice.service.impl;

import com.docswebapps.homeinventoryservice.domain.Model;
import com.docswebapps.homeinventoryservice.mappers.ModelMapper;
import com.docswebapps.homeinventoryservice.repository.MakeRepository;
import com.docswebapps.homeinventoryservice.repository.ModelRepository;
import com.docswebapps.homeinventoryservice.service.ModelService;
import com.docswebapps.homeinventoryservice.web.model.ModelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final MakeRepository makeRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper, MakeRepository makeRepository) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.makeRepository = makeRepository;
    }

    @Override
    public List<ModelDto> getAllModels() {
        return this.modelRepository.findAll()
                .stream()
                .map(modelMapper::modelToModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public ModelDto getModelById(Long id) {
        return this.modelRepository.findById(id)
                .map(modelMapper::modelToModelDto)
                .orElse(null);
    }

    @Override
    public Long saveModel(ModelDto modelDto) {
        Model model = Model.builder().build();
        return this.makeRepository.findByName(modelDto.getModelMakeName().toUpperCase())
                .map(make -> {
                    model.setName(modelDto.getName());
                    model.setModelMake(make);
                    return this.modelRepository.save(model).getId();
                }).orElse(-1L);
    }

    @Override
    public boolean updateModel(Long id, ModelDto modelDto) {
        return this.modelRepository.findById(id)
                .map(model -> {
                    this.makeRepository.findByName(modelDto.getModelMakeName())
                            .map(make -> {
                                model.setName(modelDto.getName());
                                model.setModelMake(make);
                                this.modelRepository.save(model);
                                return true;
                            }).orElse(false);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteModel(Long id) {
        return this.modelRepository.findById(id)
                .map(model -> {
                    this.modelRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
