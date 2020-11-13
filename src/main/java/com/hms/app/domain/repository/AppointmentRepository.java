package com.hms.app.domain.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	Appointment getAppointmentByTime(Time time);
	Optional<Appointment> findByDateAndTimeAndDoctor(Date date,Time time,Doctor doctor);
	

}
