package com.egov.service;

import com.egov.dto.FarmerSchemeDto;
import com.egov.entity.Status;

public interface IFarmerSchemeService {

    FarmerSchemeDto applyFarmerScheme(FarmerSchemeDto farmerSchemeDto, Integer userId, Integer schemeId) throws Exception;

    String updateStatus(Integer applicationId, Status status, String comments);

}
