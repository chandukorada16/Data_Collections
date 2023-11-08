package com.data.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.binding.PlanSelection;
import com.data.service.DataCollectionsService;

@RestController
public class PlanSelectionRestController {
	
	@Autowired
	private DataCollectionsService service;

	@PostMapping("/planSel")
	public ResponseEntity<Long> planSelection(@RequestBody PlanSelection selection) {
		Long caseNum = service.savePlanSelection(selection);

		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);

	}

}

