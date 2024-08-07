package com.egov.service;

import com.egov.dto.StudentSchemeDto;
import com.egov.entity.SchemeMaster;
import com.egov.entity.StudentScheme;
import com.egov.entity.User;
import com.egov.repository.SchemeRepository;
import com.egov.repository.StudentSchemeRepo;
import com.egov.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentSchemeImpl implements IStudentSchemeService {

    private final StudentSchemeRepo studentSchemeRepo;

    private final UserRepository userRepository;
    private final SchemeRepository schemeRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentSchemeImpl(StudentSchemeRepo studentSchemeRepo, UserRepository userRepository, SchemeRepository schemeRepository, ModelMapper modelMapper) {
        this.studentSchemeRepo = studentSchemeRepo;
        this.userRepository = userRepository;
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public StudentSchemeDto register(StudentSchemeDto studentSchemeDto, Integer userId, Integer schemeId) throws Exception {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        SchemeMaster schemeMaster = schemeRepository.findById(schemeId)
                .orElseThrow(() -> new Exception("Scheme not found"));
        StudentScheme studentScheme = modelMapper.map(studentSchemeDto, StudentScheme.class);

        studentScheme.setUserId(user);
        studentScheme.setSchemeMaster(schemeMaster);

        return modelMapper.map(studentSchemeRepo.save(studentScheme), StudentSchemeDto.class);
    }

    @Override
    public StudentSchemeDto update(String schemeId, StudentSchemeDto studentSchemeDto) {
        return null;
    }

    @Override
    public StudentSchemeDto get(String schemeId) {
        return null;
    }

    @Override
    public List<StudentSchemeDto> getAll() {
        return List.of();
    }
}
