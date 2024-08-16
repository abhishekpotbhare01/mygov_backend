package com.egov.service;

import com.egov.dto.FarmerSchemeDto;
import com.egov.entity.FarmerScheme;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.User;
import com.egov.repository.FarmerSchemeRepo;
import com.egov.repository.SchemeRepository;
import com.egov.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FarmerSchemeServiceImpl implements IFarmerSchemeService {

    private final FarmerSchemeRepo farmerSchemeRepo;
    private final UserRepository userRepository;
    private final SchemeRepository schemeRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public FarmerSchemeServiceImpl(FarmerSchemeRepo farmerSchemeRepo,
                                   UserRepository userRepository,
                                   SchemeRepository schemeRepository,
                                   ModelMapper modelMapper) {
        this.farmerSchemeRepo = farmerSchemeRepo;
        this.userRepository = userRepository;
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FarmerSchemeDto applyFarmerScheme(FarmerSchemeDto farmerSchemeDto,
                                             Integer userId, Integer schemeId) throws Exception {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        SchemeMaster schemeMaster = schemeRepository.findById(schemeId)
                .orElseThrow(() -> new Exception("Scheme not found"));
        FarmerScheme farmerScheme = modelMapper.map(farmerSchemeDto, FarmerScheme.class);


        farmerScheme.setUserId(user);
        farmerScheme.setSchemeMaster(schemeMaster);

        FarmerScheme farmerSchemeSaved = farmerSchemeRepo.save(farmerScheme);


        return modelMapper.map(farmerSchemeSaved, FarmerSchemeDto.class);
    }

    @Override
    public String updateStatus(Integer applicationId, Status status, String comments) {


        FarmerScheme farmerScheme = farmerSchemeRepo.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Scheme Id not found"));

        if (farmerScheme.getStatus() == status) {
            return "Application is already in " + status;
        }

        farmerScheme.setStatus(status);
        farmerScheme.setComments(comments);
        farmerSchemeRepo.save(farmerScheme);
        return "Successfully change the status to " + status;
    }

}