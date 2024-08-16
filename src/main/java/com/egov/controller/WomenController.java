package com.egov.controller;

import com.egov.dto.WomenSchemeDto;
import com.egov.service.IWomenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/women")
public class WomenController {

    @Autowired
    private IWomenService womenService;

    @GetMapping
    public ResponseEntity<?> getAllwomendata() {
        System.out.println("in get womenscheme");
        return ResponseEntity.ok(womenService.getAllWomensData());

    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> addNewWomen(@PathVariable Integer userId,
                                         @RequestParam Integer schemeId, 
                                         @RequestBody WomenSchemeDto womenDto) {
    	System.out.println(userId+ schemeId +"woemnedata: "+womenDto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(womenService.addNewWomenData(userId, schemeId, womenDto));
        } catch (RuntimeException e) {
            // If the error is not related to resource not found, consider changing the status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getWomenScheme(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(womenService.getWomenDataById(id));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWomendatabyid(@PathVariable Integer id, @RequestBody WomenSchemeDto womenDto) {
        try {
            return ResponseEntity.ok(womenService.updateWomenDataDetails(id, womenDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletewomenData(@PathVariable @Valid Integer id) {
        try {
            womenService.deleteWomendataById(id);
            return ResponseEntity.ok("Data deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }
    }
}
