package com.visibilityalgorithm.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visibilityalgorithm.integration.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {    
}
