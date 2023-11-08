package com.data.service;

import java.util.Map;

import com.data.binding.ChildRequest;
import com.data.binding.DcSummary;
import com.data.binding.Education;
import com.data.binding.Income;
import com.data.binding.PlanSelection;

public interface DataCollectionsService {
	
	public Long loadCaseNum(Integer appId);
	
	public Map<Integer,String> getPlanNames();
	
	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeData(Income income);
	
	public Long saveEducation(Education education);
	
	public Long saveChildrenDetails(ChildRequest request);
	
	public DcSummary getSummary(Long caseNumber);

}
