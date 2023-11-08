package com.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.DcChidren;
import com.data.entity.DcCitizenAppEntity;

public interface DcCitizenAppEntityRepository extends JpaRepository<DcCitizenAppEntity, Serializable> {

}
