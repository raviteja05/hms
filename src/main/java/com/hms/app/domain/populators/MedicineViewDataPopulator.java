package com.hms.app.domain.populators;

import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Medicine;
import com.hms.app.domain.viewdata.MedicineViewData;
import com.hms.app.populator.Populator;
@Component
public class MedicineViewDataPopulator implements Populator<Medicine,MedicineViewData> {

	@Override
	public void populate(Medicine source, MedicineViewData target) {
		target.setName(source.getName());
		target.setDosage(source.getDosage());
		
	}

}
