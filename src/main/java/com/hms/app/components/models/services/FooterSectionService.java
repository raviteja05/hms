package com.hms.app.components.models.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.models.FooterSection;
import com.hms.app.components.models.repository.FooterSectionRepository;
import com.hms.app.components.services.ComponentService;

@Service
public class FooterSectionService implements ComponentService<FooterSection>{
	@Resource
	private FooterSectionRepository footerSectionRepository;

	@Override
	public void createComponent(FooterSection component) {
		footerSectionRepository.save(component);
		
	}
	public void createComponents(List<FooterSection> components) {
		footerSectionRepository.saveAll(components);
		
	}

	@Override
	public FooterSection getComponent(String id) {
		
		return footerSectionRepository.getOne(id);
	}

}
