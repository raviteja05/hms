package com.hms.app.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends User {
	@Column
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
