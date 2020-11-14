package com.hms.app.domain.viewdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrescriptionViewData {
	private long id;
	private Date date=new Date();
	private List<MedicineViewData> medicines=new ArrayList<>();
	private DoctorViewData doctorViewData=new DoctorViewData();
	private CustomerViewData customerViewData=new CustomerViewData();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<MedicineViewData> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<MedicineViewData> medicines) {
		this.medicines = medicines;
	}
	public DoctorViewData getDoctorViewData() {
		return doctorViewData;
	}
	public void setDoctorViewData(DoctorViewData doctorViewData) {
		this.doctorViewData = doctorViewData;
	}
	public CustomerViewData getCustomerViewData() {
		return customerViewData;
	}
	public void setCustomerViewData(CustomerViewData customerViewData) {
		this.customerViewData = customerViewData;
	}
	

}
