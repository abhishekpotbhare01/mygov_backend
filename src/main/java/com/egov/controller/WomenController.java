package com.egov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egov.dto.WomenDto;
import com.egov.entity.Women;
import com.egov.service.IWomenService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/women")
public class WomenController {
    
    @Autowired
    private IWomenService womenService;

    @GetMapping
  public ResponseEntity<?> getWomenScheme() {
    System.out.println("in get womenscheme");
    return ResponseEntity.ok (womenService.getAllWomensData());

  }
  @PostMapping("/addnewdata")
  public ResponseEntity<?>addNewWomen(@RequestBody Women women){
    return ResponseEntity.status(HttpStatus.CREATED).body(womenService.addNewWomenData(null));    
  }  
  @GetMapping("/{id}")
  public ResponseEntity<?>getAllWomenData(@PathVariable @Valid @Min(1) @Max(100) Integer id)
  {
	  
	  return ResponseEntity.ok(womenService.getWomenDataById(id));
	  
  }
  @GetMapping("/{schemename}")
  public ResponseEntity<?>getAllDataByName(@PathVariable @Valid String schemeName)
  {
	  return ResponseEntity.ok(womenService.getWomenDataByName(schemeName));
  }
}
