package com.egov.controller;

import com.egov.dto.FarmerSchemeDto;
import com.egov.service.IFarmerSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fscheme")
@CrossOrigin(origins = "http://localhost:3000")
public class FarmerSchemeController {

    private final IFarmerSchemeService farmerSchemeService;

    @Autowired
    public FarmerSchemeController(IFarmerSchemeService farmerSchemeService) {
        this.farmerSchemeService = farmerSchemeService;
    }


    @PostMapping("/{userId}")
    public ResponseEntity<?> createScheme(@PathVariable("userId") Integer userId,
                                          @RequestParam("schemeId") Integer schemeId,
                                          @RequestBody FarmerSchemeDto farmerScheme) {

        try {
            FarmerSchemeDto farmerSchemeDto = farmerSchemeService.applyFarmerScheme(farmerScheme, userId, schemeId);
            return new ResponseEntity<>(farmerSchemeDto, HttpStatus.CREATED);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
