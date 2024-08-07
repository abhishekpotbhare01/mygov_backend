package com.egov.service;

import com.egov.dto.SchemeMasterDto;
import com.egov.repository.SchemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeServiceImpl implements ISchemeService {
    @Autowired
    private SchemeRepository schemeRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto) {

        com.egov.entity.SchemeMaster schemeDetails = modelMapper.map(schemeDto, com.egov.entity.SchemeMaster.class);

        com.egov.entity.SchemeMaster savedSchemeDetails = schemeRepository.save(schemeDetails);

        schemeDto = modelMapper.map(savedSchemeDetails, SchemeMasterDto.class);
        return schemeDto;
    }

    @Override
    public SchemeMasterDto updateSchemeDetails(SchemeMasterDto schemeDto) {
        return null;
    }

    @Override
    public SchemeMasterDto getSchemeDetails(String schemeId) {
        return null;
    }

    @Override
    public List<SchemeMasterDto> getAllSchemeDetails() {
        return List.of();
    }
}
