package com.hms.app.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Prescription;
import com.hms.app.domain.populators.PrescriptionViewDataPopulator;
import com.hms.app.domain.repository.PrescriptionRepository;
import com.hms.app.domain.viewdata.PrescriptionViewData;

@Service
public class PrescriptionService {
	@Resource
	private PrescriptionRepository prescriptionRepository;
	
	@Resource
	private UserService userService;
	
	@Resource
	private PrescriptionViewDataPopulator prescriptionViewDataPopulator;
	
	public void savePrescription(Prescription prescription) {
		prescriptionRepository.save(prescription);
	}
	
	public List<PrescriptionViewData> getAllPrescriptionsForCustomer(String custId){
		
		Optional<Customer> customer=userService.findCustomer(custId);
		List<PrescriptionViewData> prescriptionViewDatas=new ArrayList<>();
		
		customer.get().getPrescriptions().forEach(prescription->{
			PrescriptionViewData prescriptionViewData=new PrescriptionViewData();
			prescriptionViewDataPopulator.populate(prescription, prescriptionViewData);
			prescriptionViewDatas.add(prescriptionViewData);
		});
		return prescriptionViewDatas;
		
	}
	
	public PrescriptionViewData getPrescriptionById(long id) {
		Optional<Prescription> prescription =prescriptionRepository.findById(id);
		PrescriptionViewData prescriptionViewData=new PrescriptionViewData();
		prescriptionViewDataPopulator.populate(prescription.get(), prescriptionViewData);
		return prescriptionViewData;
		
	}
	
	
}
