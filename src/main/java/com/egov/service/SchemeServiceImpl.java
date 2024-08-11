package com.egov.service;

import com.egov.dto.SchemeMasterDto;
import com.egov.entity.SchemeMaster;
import com.egov.repository.SchemeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchemeServiceImpl implements ISchemeService {


    @Autowired
    private SchemeRepository schemeRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public SchemeMasterDto findBySchemeById(Integer schemeId) {
   
        SchemeMaster schemeMaster = schemeRepository.findById(schemeId)
                .orElseThrow(() -> new RuntimeException(""));

        return modelMapper.map(schemeMaster, SchemeMasterDto.class);

    }

    @Override
    public SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto) {

        com.egov.entity.SchemeMaster schemeDetails = modelMapper.map(schemeDto, SchemeMaster.class);

        SchemeMaster savedSchemeDetails = schemeRepository.save(schemeDetails);

        schemeDto = modelMapper.map(savedSchemeDetails, SchemeMasterDto.class);
        return schemeDto;
    }

    @Override
    public SchemeMasterDto updateSchemeDetails(Integer schemeId, SchemeMasterDto schemeDto) {

        SchemeMaster existingScheme = schemeRepository.findById(schemeId).orElseThrow(() -> new RuntimeException("Invalid Scheme id!!!"));

        //existing scheme data will be updated
        modelMapper.map(schemeDto, existingScheme);
        existingScheme.setSchemeId(schemeId);
        SchemeMaster updatedScheme = schemeRepository.save(existingScheme);
        System.out.println(existingScheme);

        return modelMapper.map(updatedScheme, SchemeMasterDto.class);
    }

    @Override
    public SchemeMasterDto getSchemeDetailsById(Integer schemeId) {

        SchemeMaster schemeMaster = schemeRepository.findById(schemeId).orElseThrow(() -> new RuntimeException("Invalid Scheme id!!!"));

        return modelMapper.map(schemeMaster, SchemeMasterDto.class);

    }

    @Override
    public List<SchemeMasterDto> getAllSchemeDetails() {

        List<SchemeMaster> schemeEntity = schemeRepository.findAll();

        List<SchemeMasterDto> schemeData = schemeEntity.stream()
                .map(scheme -> modelMapper.map(scheme, SchemeMasterDto.class))
                .collect(Collectors.toList());
        return schemeData;
    }

    @Override
    public List<SchemeMasterDto> getSchemeDetailsbyName(String schemeName) {

        List<SchemeMaster> schemeEntity = schemeRepository.findBySchemeName(schemeName);
        System.out.println(schemeEntity.size());
        if (schemeEntity == null || schemeEntity.isEmpty()) {
            return new ArrayList<>();
        }

        // Map entities to DTOs
        Type listType = new TypeToken<List<SchemeMasterDto>>() {
        }.getType();
        List<SchemeMasterDto> schemedata = modelMapper.map(schemeEntity, listType);

        return schemedata;
    }

	@Override
	public List<Integer> getAllSchemeIdByUserId(Integer userId) {
		List<Integer>list=schemeRepository.findByUserId(userId);
		System.out.println(list);
		return list;
	}

    
}
