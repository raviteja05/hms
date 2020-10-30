package com.hms.app.domain.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
public class Customer extends User {
	@Column
	private String knownAllergies;
	@Column
	private String bloodGroup;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Prescription> prescriptions=new ArrayList<>();
	@Column
	private int age;
	@Column
	private int weight;
	@Column
	private float height;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Appointment> appointments=new ArrayList<>();
	@Column
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
