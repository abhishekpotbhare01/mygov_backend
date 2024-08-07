package com.egov.service;

import com.egov.dto.FarmerSchemeDto;

public interface IFarmerSchemeService {

    FarmerSchemeDto applyFarmerScheme(FarmerSchemeDto farmerSchemeDto, Integer userId, Integer schemeId) throws Exception;
}
