package com.rte.collector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rte.collector.entity.OffreSpeciale;

@Repository
public interface OffreSpecialRepository extends JpaRepository<OffreSpeciale, Long> {
	

}
