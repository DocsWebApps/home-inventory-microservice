package com.docswebapps.homeinventoryservice.service.impl;

import com.docswebapps.homeinventoryservice.domain.Make;
import com.docswebapps.homeinventoryservice.mappers.MakeMapper;
import com.docswebapps.homeinventoryservice.repository.MakeRepository;
import com.docswebapps.homeinventoryservice.service.MakeService;
import com.docswebapps.homeinventoryservice.web.model.MakeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MakeServiceImpl implements MakeService {
    private final MakeRepository makeRepository;
    private final MakeMapper makeMapper;

    public MakeServiceImpl(MakeRepository makeRepository, MakeMapper makeMapper) {
        this.makeRepository = makeRepository;
        this.makeMapper = makeMapper;
    }

    @Override
    public List<MakeDto> getAllMakes() {
        return this.makeRepository.findAll()
                .stream()
                .map(makeMapper::makeToMakeDto)
                .collect(Collectors.toList());
    }

    @Override
    public MakeDto getMakeById(Long id) {
        Optional<Make> makeOpt = this.makeRepository.findById(id);
        return makeOpt.map(makeMapper::makeToMakeDto).orElse(null);
    }

    @Override
    public Long saveMake(MakeDto makeDto) {
        return this.makeRepository.save(this.makeMapper.makeDtoToMake(makeDto)).getId();
    }

    @Override
    public boolean updateMake(Long id, MakeDto makeDto) {
        return this.makeRepository.findById(id)
            .map(make -> {
                make.setName(makeDto.getName());
                this.makeRepository.save(make);
                return true;
            }).orElse(false);
    }

    @Override
    public boolean deleteMake(Long id) {
        return this.makeRepository.findById(id)
                .map(make -> {
                    this.makeRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
