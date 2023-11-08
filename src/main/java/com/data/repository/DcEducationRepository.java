package com.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.DcEducation;

public interface DcEducationRepository extends JpaRepository<DcEducation, Serializable> {

	public DcEducation findByCaseNum(Long caseNumber);

}
