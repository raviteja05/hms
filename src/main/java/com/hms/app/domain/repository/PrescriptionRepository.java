package com.hms.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.Prescription;
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
	
	

}
