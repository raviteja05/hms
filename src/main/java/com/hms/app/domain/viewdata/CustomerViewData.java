package com.hms.app.domain.viewdata;

import java.util.ArrayList;
import java.util.List;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Prescription;

public class CustomerViewData extends UserViewData {
	
	
	private String knownAllergies;	
	private String bloodGroup;	
	private List<Prescription> prescriptions=new ArrayList<>();	
	private int age;	
	private int weight;	
	private float height;	
	private List<Appointment> appointments=new ArrayList<>();	
	private String notes;
	public String getKnownAllergies() {
		return knownAllergies;
	}
	public void setKnownAllergies(String knownAllergies) {
		this.knownAllergies = knownAllergies;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
