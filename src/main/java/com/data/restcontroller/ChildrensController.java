package com.data.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.binding.ChildRequest;
import com.data.binding.DcSummary;
import com.data.service.DataCollectionsService;

@RestController
public class ChildrensController {
	
	@Autowired
	private DataCollectionsService service;
	
	@PostMapping("/child")
	public ResponseEntity<DcSummary> saveChildren(@RequestBody ChildRequest request) {
		Long caseNum = service.saveChildrenDetails(request);

		DcSummary summary = service.getSummary(caseNum);

		return new ResponseEntity<DcSummary>(summary, HttpStatus.CREATED);

	}

}
