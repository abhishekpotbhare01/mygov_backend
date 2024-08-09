package com.egov.service;

import com.egov.dto.SchemeMasterDto;

import java.util.List;

public interface ISchemeService {

    SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto);

    SchemeMasterDto updateSchemeDetails(Integer schemeId, SchemeMasterDto schemeDto);
    SchemeMasterDto getSchemeDetailsById(Integer schemeId);
    List<SchemeMasterDto> getSchemeDetailbyName(String schemeName);
    List<SchemeMasterDto> getAllSchemeDetails();
}
