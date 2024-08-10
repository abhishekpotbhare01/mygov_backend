package com.egov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egov.dto.WomenDto;
import com.egov.service.IWomenService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/women")
public class WomenController {
    
    @Autowired
    private IWomenService womenService;

    @GetMapping
  public ResponseEntity<?> getAllwomendata() {
    System.out.println("in get womenscheme");
    return ResponseEntity.ok (womenService.getAllWomensData());

  }
  @PostMapping("/addnewdata")
  public ResponseEntity<?>addNewWomen(@RequestBody WomenDto womenDto){
   try {
	  return ResponseEntity.status(HttpStatus.CREATED).body(womenService.addNewWomenData(womenDto));    
     } catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
  
  }  
  @GetMapping("/{id}")
  public ResponseEntity<?>getWomenScheme(@PathVariable Integer id)
  {
	try {  
	  return ResponseEntity.ok(womenService.getWomenDataById(id));
	  
	  } catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	 }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<?> updateWomendatabyid(@PathVariable Integer id,@RequestBody WomenDto womenDto)
  {
	try {
	  return ResponseEntity.ok(womenService.updateWomenDataDetails(id, womenDto));
     } catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletewomenData(@PathVariable @Valid Integer id){
	  try {
	            womenService.deleteWomendataById(id);
	        return ResponseEntity.ok("Data deleted successfully");
	     } catch (RuntimeException e) { 
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
         }
  }
}
