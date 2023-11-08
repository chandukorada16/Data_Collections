package com.data.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {
	
	private Long caseNum;
	
	private Double empIncome;
	
	private Double propertyIncome;
	
	private Double rentIncome;

}
