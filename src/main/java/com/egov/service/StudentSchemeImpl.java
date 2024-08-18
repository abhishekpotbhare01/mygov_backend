package com.egov.service;

import com.egov.dto.StudentSchemeDto;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.StudentScheme;
import com.egov.entity.User;
import com.egov.repository.SchemeRepository;
import com.egov.repository.StudentSchemeRepo;
import com.egov.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class StudentSchemeImpl implements IStudentSchemeService {

    private final StudentSchemeRepo studentSchemeRepo;

    private final UserRepository userRepository;
    private final SchemeRepository schemeRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentSchemeImpl(StudentSchemeRepo studentSchemeRepo, UserRepository userRepository,
                             SchemeRepository schemeRepository, ModelMapper modelMapper) {
        this.studentSchemeRepo = studentSchemeRepo;
        this.userRepository = userRepository;
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentSchemeDto register(StudentSchemeDto studentSchemeDto, Integer userId, Integer schemeId)
            throws Exception {

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));

        SchemeMaster schemeMaster = schemeRepository.findById(schemeId)
                .orElseThrow(() -> new Exception("Scheme not found"));
        StudentScheme studentScheme = modelMapper.map(studentSchemeDto, StudentScheme.class);

        studentScheme.setUser(user);
        studentScheme.setSchemeMaster(schemeMaster);

        return modelMapper.map(studentSchemeRepo.save(studentScheme), StudentSchemeDto.class);
    }

    //	Incomplete code/ not working
    @Override
    public StudentSchemeDto update(Integer schemeId, StudentSchemeDto studentSchemeDto) throws Exception {
//		StudentScheme student = studentSchemeRepo.findById(schemeId).orElseThrow(() -> new Exception("Student not found"));
//
//	    modelMapper.map(studentSchemeDto, student);
//
//	    StudentScheme updatedData = studentSchemeRepo.save(student);
//	    return modelMapper.map(updatedData, StudentSchemeDto.class);

        StudentScheme student = studentSchemeRepo.findById(schemeId)
                .orElseThrow(() -> new Exception("Student not found"));


        modelMapper.typeMap(StudentSchemeDto.class, StudentScheme.class).map(studentSchemeDto, student);

        System.out.println(student);

        student.setStudentSchemeId(schemeId);
        StudentScheme updatedStudent = studentSchemeRepo.save(student);


        return modelMapper.map(updatedStudent, StudentSchemeDto.class);

//		return NULL;
    }

    @Override
    public StudentSchemeDto get(Integer schemeId) throws Exception {

        StudentScheme studentEntity = studentSchemeRepo.findById(schemeId).orElseThrow(() -> new Exception("Student not found"));

        StudentSchemeDto studentData = modelMapper.map(studentEntity, StudentSchemeDto.class);
        return studentData;

        // return null;
    }

    @Override
    public List<StudentSchemeDto> getAll() {
        List<StudentScheme> studentEntitiy = studentSchemeRepo.findAll();

        Type listType = new TypeToken<List<StudentSchemeDto>>() {
        }.getType();

        List<StudentSchemeDto> studentdata = modelMapper.map(studentEntitiy, listType);

        return studentdata;
    }

    @Override
    public String updateStatus(Integer applicationId, Status status, String comments) {
        try {
            StudentScheme studentScheme = studentSchemeRepo.findById(applicationId)
                    .orElseThrow(() -> new RuntimeException("Women not found with id: " + applicationId));

            studentScheme.setStatus(status);
            studentScheme.setComments(comments);

            studentSchemeRepo.save(studentScheme);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to change status: " + applicationId);
        }

        return "Successfully change the status to " + status;
    }
}
