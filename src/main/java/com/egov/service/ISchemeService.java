package com.egov.service;

import com.egov.dto.SchemeMasterDto;

import java.util.List;

public interface ISchemeService {

    SchemeMasterDto saveSchemeDetails(SchemeMasterDto schemeDto);

    SchemeMasterDto updateSchemeDetails(SchemeMasterDto schemeDto);
    SchemeMasterDto getSchemeDetails(String schemeId);
    List<SchemeMasterDto> getAllSchemeDetails();
}
