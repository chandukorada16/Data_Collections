package com.data.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.binding.Income;
import com.data.service.DataCollectionsService;

@RestController
public class IncomeRestController {
	
	private DataCollectionsService service;

	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income) {
		Long caseNum = service.saveIncomeData(income);
		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);

	}

}

