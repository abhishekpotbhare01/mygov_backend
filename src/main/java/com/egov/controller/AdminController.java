package com.egov.controller;


import com.egov.entity.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {


    @PostMapping("/{schemeName}")
    public ResponseEntity<?> changeStatus(@RequestParam("status") Status status,
                                          @RequestParam("schmeId") Integer schemeId
    ) {


        return null;

    }

}
