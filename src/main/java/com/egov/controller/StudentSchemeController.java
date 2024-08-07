package com.egov.controller;

import com.egov.dto.StudentSchemeDto;
import com.egov.service.IStudentSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentSchemeController {

    private final IStudentSchemeService studentSchemeService;

    @Autowired
    public StudentSchemeController(IStudentSchemeService studentSchemeService) {
        this.studentSchemeService = studentSchemeService;
    }


    @PostMapping("/{userId}")
    public ResponseEntity<?> createScheme(@PathVariable("userId") Integer userId,
                                          @RequestParam("schemeId") Integer schemeId,
                                          @RequestBody StudentSchemeDto studentScheme) {

        try {
            StudentSchemeDto resp = studentSchemeService.register(studentScheme, userId, schemeId);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
