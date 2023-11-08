package com.data.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	
	private String fullName;
	
	private String email;
	
	private Long phNo;
	
	private Long ssn;
	
	private Character gender;
	
	private String stateName;
	
	private LocalDate dateofBirth;

}
