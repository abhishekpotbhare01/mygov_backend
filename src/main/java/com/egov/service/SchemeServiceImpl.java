package com.egov.service;

import com.egov.dto.SchemeDto;
import com.egov.entity.Scheme;
import com.egov.repository.SchemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemeServiceImpl implements ISchemeService {
    @Autowired
    private SchemeRepository schemeRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public SchemeDto saveSchemeDetails(SchemeDto schemeDto) {

        Scheme schemeDetails = modelMapper.map(schemeDto, Scheme.class);

        Scheme savedSchemeDetails = schemeRepository.save(schemeDetails);

        schemeDto = modelMapper.map(savedSchemeDetails, SchemeDto.class);
        return schemeDto;
    }
}
