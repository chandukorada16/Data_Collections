package com.data.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.binding.Education;
import com.data.service.DataCollectionsService;

@RestController
public class EducationController {
	
	@Autowired
	private DataCollectionsService service;

	@PostMapping("/education")
	public ResponseEntity<Long> saveEducation(@RequestBody Education education) {
		Long caseNum = service.saveEducation(education);

		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);

	}

}
