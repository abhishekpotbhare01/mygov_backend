package com.egov.service;

import com.egov.dto.StudentSchemeDto;

import java.util.List;

public interface IStudentSchemeService {
    StudentSchemeDto register(StudentSchemeDto studentSchemeDto, Integer userId, Integer schemeId) throws Exception;

    StudentSchemeDto update(Integer schemeId, StudentSchemeDto studentSchemeDto) throws Exception;

    StudentSchemeDto get(Integer schemeId) throws Exception;

    List<StudentSchemeDto> getAll();

}
