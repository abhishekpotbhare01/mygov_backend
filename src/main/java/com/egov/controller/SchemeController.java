package com.egov.controller;

import com.egov.dto.SchemeDto;
import com.egov.service.ISchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheme")
@CrossOrigin(origins = "http://localhost:3000")
public class SchemeController {

    @Autowired
    private ISchemeService schemeService;

    @PostMapping("/")
    public ResponseEntity createScheme(@RequestBody SchemeDto schemeDto) {
        SchemeDto resp = schemeService.saveSchemeDetails(schemeDto);

        return new ResponseEntity(resp, HttpStatus.CREATED);
    }


}