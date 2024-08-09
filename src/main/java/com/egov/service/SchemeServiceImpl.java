package com.egov.service;
import  com.egov.entity.*;
import com.egov.dto.SchemeMasterDto;
import com.egov.repository.SchemeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class SchemeServiceImpl implements ISchemeService {
    @Autowired
    private SchemeRepository schemeRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto) {

        com.egov.entity.SchemeMaster schemeDetails = modelMapper.map(schemeDto, SchemeMaster.class);

        SchemeMaster savedSchemeDetails = schemeRepository.save(schemeDetails);

        schemeDto = modelMapper.map(savedSchemeDetails, SchemeMasterDto.class);
        return schemeDto;
    }
            //updating scheme method
    @Override
public SchemeMasterDto updateSchemeDetails( Integer schemeId,SchemeMasterDto schemeDto)  {

    Optional<SchemeMaster> schemeEntity=schemeRepository.findById(schemeId);
             SchemeMaster existingScheme=schemeEntity.orElseThrow();
        SchemeMaster scheme=modelMapper.map(schemeDto, SchemeMaster.class);
           existingScheme.setName(scheme.getName());   
           existingScheme.setSchemeDescription(scheme.getSchemeDescription());
           existingScheme.setLaunchDate(scheme.getLaunchDate());
           existingScheme.setAge(scheme.getAge());
           existingScheme.setCategory(scheme.getCategory());
           existingScheme.setEligibilityCriteria(scheme.getEligibilityCriteria());
           existingScheme.setDocRequired(scheme.getDocRequired());
           schemeRepository.save(existingScheme);
        return schemeDto;
    }
    
    @Override
    public SchemeMasterDto getSchemeDetailsById(Integer schemeId) {
        Optional<SchemeMaster> scheme=schemeRepository.findById(schemeId);
                
        return  modelMapper.map(scheme, SchemeMasterDto.class);
    }
    
    @Override
    public List<SchemeMasterDto> getAllSchemeDetails() {
        List<SchemeMaster> schemeEntity=schemeRepository.findAll();
        Type listType = new TypeToken<SchemeMasterDto>(){}.getType();
        List<SchemeMasterDto> schemeData=modelMapper.map(schemeEntity,listType);
        return schemeData;
    }
}
