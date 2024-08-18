package com.egov.controller;


import com.egov.dto.AllSchemeDto;
import com.egov.dto.ApprovalPayLoad;
import com.egov.entity.Status;
import com.egov.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/approval")
    public ResponseEntity<?> approval(@RequestBody ApprovalPayLoad approvalPayLoad) {
        String message = adminService.approveOrRejectApplication(approvalPayLoad);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{schemeId}")
    public ResponseEntity<?> getStatus(@PathVariable("schemeId") Integer schemeId,
                                       @RequestParam(value = "status", defaultValue = "PENDING") Status status
    ) {
        List<AllSchemeDto> res = adminService.getAllByStatus(schemeId, status);
        return ResponseEntity.ok(res);
    }
}