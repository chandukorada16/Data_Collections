package com.data.binding;

import java.util.List;

import lombok.Data;

@Data
public class DcSummary {
	
	private Income income;
	
	private Education education;
	
	private List<Children> childrens;
	
	private String planName;

}
