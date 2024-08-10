package com.egov.service;

import com.egov.dto.AllSchemeDto;
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

    @Override
    public List<AllSchemeDto> getAllByStatus(Integer schemeId, Status status) {

        return schemeRepository.findBySchemeId(schemeId, status);

    }
}
