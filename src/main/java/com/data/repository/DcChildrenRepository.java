package com.data.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.DcChidren;

public interface DcChildrenRepository extends JpaRepository<DcChidren, Serializable> {

	public List<DcChidren> findByCaseNum(Long caseNumber);

}
