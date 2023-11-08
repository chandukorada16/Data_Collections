package com.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.DcCasesEntity;
import com.data.service.DataCollectionsService;

public interface DcCasesEntityRepository extends JpaRepository<DcCasesEntity, Serializable> {

	public DcCasesEntity findByAppId(Integer appId);
}
