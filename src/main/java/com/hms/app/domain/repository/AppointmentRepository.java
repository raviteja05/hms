package com.hms.app.domain.repository;

import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>{
	
	Appointment getAppointmentByTime(Time time);

}
