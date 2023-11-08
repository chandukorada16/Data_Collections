package com.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.DcIncomeEntity;

public interface DcIncomeEntityRepository extends JpaRepository<DcIncomeEntity, Serializable> {

	public DcIncomeEntity findByCaseNum(Long caseNumber);

}
