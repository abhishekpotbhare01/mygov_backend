package com.egov.controller;

import com.egov.dto.StudentSchemeDto;
import com.egov.service.IStudentSchemeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

	@GetMapping
	public ResponseEntity<?> getStudents() {
		System.out.println("in get studentschema");
		return ResponseEntity.ok(studentSchemeService.getAll());

	}

	@GetMapping("/{studentSchemeId}")
	public ResponseEntity<?> getStudentData(@PathVariable @Valid  Integer id) {
		try {
			System.out.println("in get studentschema");
			return ResponseEntity.ok(studentSchemeService.get(id));	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

//	StudentSchemeDto update(String schemeId, StudentSchemeDto studentSchemeDto);
	@PutMapping("/{studentSchemeId}")
	public ResponseEntity<?> createScheme(@PathVariable("studentSchemeId") Integer studentSchemeId,
			@RequestBody StudentSchemeDto studentScheme) {
		try {
			String resp = studentSchemeService.update(studentSchemeId, studentScheme);
			return new ResponseEntity<>(resp, HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/{userId}")
	public ResponseEntity<?> createScheme(@PathVariable("userId") Integer userId,
			@RequestParam("schemeId") Integer schemeId, @RequestBody StudentSchemeDto studentScheme) {

		try {
			StudentSchemeDto resp = studentSchemeService.register(studentScheme, userId, schemeId);
			return new ResponseEntity<>(resp, HttpStatus.CREATED);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
