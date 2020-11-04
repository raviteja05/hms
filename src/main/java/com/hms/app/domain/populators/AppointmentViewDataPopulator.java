package com.hms.app.domain.populators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.populator.Populator;
@Component
public class AppointmentViewDataPopulator implements Populator<Appointment, AppointmentViewData> {
	
	@Resource
	private DoctorViewDataPopulator doctorViewDataPopulator;
	
	@Resource
	private CustomerViewDataPopulator customerViewDataPopulator;

	@Override
	public void populate(Appointment source, AppointmentViewData target) {
		target.setId(source.getId());
		target.setAppointmentTime(source.getTime().toString());
		target.setDate(source.getDate());
		target.setAppointmentNotes(source.getNotes());
		doctorViewDataPopulator.populate(source.getDoctor(), target.getDoctor());
		customerViewDataPopulator.populate(source.getCustomer(), target.getCustomer());
		
	}
	

}
