package com.egov.service;

import com.egov.dto.AllSchemeDto;
import com.egov.dto.ApprovalPayLoad;
import com.egov.entity.Status;
import com.egov.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {


    @Autowired
    private SchemeRepository schemeRepository;

    @Autowired
    private IFarmerSchemeService farmerSchemeService;

    @Autowired
    private IStudentSchemeService studentSchemeService;

    @Autowired
    private IWomenService womenService;

    @Override
    public List<AllSchemeDto> getAllByStatus(Integer schemeId, Status status) {

        return schemeRepository.findBySchemeId(schemeId, status);

    }

    @Override
    public String approveOrRejectApplication(ApprovalPayLoad approvalPayLoad) {

        String message = " Unable to update status of application : " + approvalPayLoad.getApplicationId();

        try {
            switch (approvalPayLoad.getSchemeConst()) {
                case PM_KISAN:
                    message = farmerSchemeService.updateStatus(approvalPayLoad.getApplicationId(), approvalPayLoad.getStatus(),
                            approvalPayLoad.getComments());
                    break;
                case LADLI:
                    womenService.updateStatus(approvalPayLoad.getApplicationId(), approvalPayLoad.getStatus(),
                            approvalPayLoad.getComments());
                    break;
                case VIDYA_LAXMI:
                    studentSchemeService.updateStatus(approvalPayLoad.getApplicationId(), approvalPayLoad.getStatus(),
                            approvalPayLoad.getComments());
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
