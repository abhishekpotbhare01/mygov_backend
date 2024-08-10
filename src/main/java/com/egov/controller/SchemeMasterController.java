package com.egov.controller;

import com.egov.dto.SchemeMasterDto;
import com.egov.service.ISchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<?> getAllSchemes() {

        List<SchemeMasterDto> resp = schemeService.getAllSchemeDetails();

        return new ResponseEntity(resp, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getAllSchmeData() {

        return ResponseEntity.status(HttpStatus.OK).body(schemeService.getAllSchemeDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchmeDataById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(schemeService.getSchemeDetailsById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateSchemeData(@PathVariable Integer id, @RequestBody SchemeMasterDto schemeMaterDto) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(schemeService.updateSchemeDetails(id, schemeMaterDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("schemeName/{schemeName}")
    public ResponseEntity<?> getSchmeDataById(@PathVariable String schemeName) {
        try {
            List<SchemeMasterDto> schemes = schemeService.getSchemeDetailsbyName(schemeName);
            if (schemes.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            return ResponseEntity.status(HttpStatus.OK).body(schemes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
