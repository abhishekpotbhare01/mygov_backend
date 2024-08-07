package com.egov.service;

import com.egov.dto.StudentSchemeDto;

import java.util.List;

public interface IStudentSchemeService {
    StudentSchemeDto register(StudentSchemeDto studentSchemeDto, Integer userId, Integer schemeId) throws Exception;

    StudentSchemeDto update(String schemeId, StudentSchemeDto studentSchemeDto);

    StudentSchemeDto get(String schemeId);

    List<StudentSchemeDto> getAll();

}
