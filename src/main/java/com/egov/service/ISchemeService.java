package com.egov.service;

import com.egov.dto.SchemeMasterDto;

import java.util.List;

public interface ISchemeService {


    SchemeMasterDto findBySchemeById(Integer schemeId);

    SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto);

    SchemeMasterDto updateSchemeDetails(Integer schemeId, SchemeMasterDto schemeDto);

    SchemeMasterDto getSchemeDetailsById(Integer schemeId);


    List<SchemeMasterDto> getSchemeDetailsbyName(String schemeName);

    List<SchemeMasterDto> getAllSchemeDetails();
}
