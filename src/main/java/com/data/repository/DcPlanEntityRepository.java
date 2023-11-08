package com.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.PlanEntity;

public interface DcPlanEntityRepository extends JpaRepository<PlanEntity, Serializable>{

}
