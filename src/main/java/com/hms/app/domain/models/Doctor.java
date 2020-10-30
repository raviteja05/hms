package com.hms.app.domain.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Doctor extends User{
	@Column
	private String qualification;
	@Column
	private String specialization;
	@Column
	private String designation;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Appointment> appointments=new ArrayList<>();
	@OneToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Prescription> prescriptions=new ArrayList<>();
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointment) {
		this.appointments = appointment;
	}
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
	

}
