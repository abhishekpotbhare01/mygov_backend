package com.egov.service;

import com.egov.dto.AllSchemeDto;
import com.egov.dto.ApprovalPayLoad;
import com.egov.entity.Status;

import java.util.List;

public interface IAdminService {

    List<AllSchemeDto> getAllByStatus(Integer schemeId, Status status);

    String approveOrRejectApplication(ApprovalPayLoad approvalPayLoad);

}
