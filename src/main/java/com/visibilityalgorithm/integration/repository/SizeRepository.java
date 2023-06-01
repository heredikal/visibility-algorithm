package com.visibilityalgorithm.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visibilityalgorithm.integration.entity.SizeEntity;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {    
}
