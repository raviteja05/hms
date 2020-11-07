package com.hms.app.domain.populators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Prescription;
import com.hms.app.domain.viewdata.MedicineViewData;
import com.hms.app.domain.viewdata.PrescriptionViewData;
import com.hms.app.populator.Populator;
@Component
public class PrescriptionViewDataPopulator implements Populator<Prescription,PrescriptionViewData> {
	@Resource
	private MedicineViewDataPopulator medicineViewDataPopulator;
	
	@Resource 
	private CustomerViewDataPopulator customerViewDataPopulator;
	
	@Resource
	private DoctorViewDataPopulator doctorViewDataPopulator;

	@Override
	public void populate(Prescription source, PrescriptionViewData target) {
		target.setDate(source.getDate());
		target.setId(source.getId());
		source.getMedicines().forEach(medicine->{
			MedicineViewData medicineViewData=new MedicineViewData();
			medicineViewDataPopulator.populate(medicine, medicineViewData);
			target.getMedicines().add(medicineViewData);
		
		});
		
		customerViewDataPopulator.populate(source.getCustomer(), target.getCustomerViewData());
		doctorViewDataPopulator.populate(source.getDoctor(), target.getDoctorViewData());
	}

}
