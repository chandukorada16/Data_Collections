package com.data.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.binding.CreateCaseResponse;
import com.data.entity.DcCasesEntity;
import com.data.service.DataCollectionsService;

@RestController
public class CreateRestController {
	
	@Autowired
	private DataCollectionsService service;
	
	@PostMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId){
		Long caseNum = service.loadCaseNum(appId);
		
		Map<Integer, String> planNames = service.getPlanNames();
		
		CreateCaseResponse ccr=new CreateCaseResponse();
		ccr.setCaseNum(caseNum);
		ccr.setPlanNames(planNames);
		
		return new ResponseEntity<CreateCaseResponse>(ccr,HttpStatus.CREATED);
		
		
	}
}
