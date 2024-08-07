package com.egov.controller;

import com.egov.dto.SchemeMasterDto;
import com.egov.service.ISchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheme")
@CrossOrigin(origins = "http://localhost:3000")
public class SchemeMasterController {

    @Autowired
    private ISchemeService schemeService;

    @PostMapping("/")
    public ResponseEntity createScheme(@RequestBody SchemeMasterDto schemeDto) {
        SchemeMasterDto resp = schemeService.saveSchemeDetails(schemeDto);

        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
}