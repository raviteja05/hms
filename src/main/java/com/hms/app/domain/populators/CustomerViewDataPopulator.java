package com.hms.app.domain.populators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.PrescriptionViewData;
import com.hms.app.populator.Populator;
@Component
public class CustomerViewDataPopulator implements Populator<Customer,CustomerViewData> {
	
	@Resource
	private PrescriptionViewDataPopulator prescriptionViewDataPopulator;

	@Override
	public void populate(Customer source, CustomerViewData target) {
		target.setAge(source.getAge());
		target.setBloodGroup(source.getBloodGroup());
		target.setEmail(source.getEmail());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setAddress(source.getAddress());
		target.setHeight(source.getHeight());
		target.setKnownAllergies(source.getKnownAllergies());
		target.setNotes(source.getNotes());
		target.setWeight(source.getWeight());
			
		
	}

}
