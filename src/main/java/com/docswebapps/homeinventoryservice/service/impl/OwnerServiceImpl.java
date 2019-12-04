package com.docswebapps.homeinventoryservice.service.impl;

import com.docswebapps.homeinventoryservice.mappers.OwnerMapper;
import com.docswebapps.homeinventoryservice.repository.OwnerRepository;
import com.docswebapps.homeinventoryservice.service.OwnerService;
import com.docswebapps.homeinventoryservice.web.model.OwnerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        return this.ownerRepository.findAll()
                .stream()
                .map(ownerMapper::ownerToOwnerDto)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDto getOwnerById(Long id) {
        return this.ownerRepository.findById(id)
                .map(ownerMapper::ownerToOwnerDto)
                .orElse(null);
    }

    @Override
    public Long saveOwner(OwnerDto ownerDto) {
        return this.ownerRepository
                .save(this.ownerMapper.ownerDtoToOwner(ownerDto))
                .getId();
    }

    @Override
    public boolean updateOwner(Long id, OwnerDto ownerDto) {
        return this.ownerRepository.findById(id)
                .map(owner -> {
                    owner.setName(ownerDto.getName());
                    this.ownerRepository.save(owner);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteOwner(Long id) {
        return this.ownerRepository.findById(id)
                .map(owner -> {
                    this.ownerRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
