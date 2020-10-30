package com.hms.app.components.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.FooterComponent;
import com.hms.app.components.repositories.FooterComponentRepository;

@Service
public class FooterComponentService implements ComponentService<FooterComponent>{
	
	@Resource
	private FooterComponentRepository footerComponentRepository;

	@Override
	public void createComponent(FooterComponent component) {
		footerComponentRepository.save(component);
		
	}

	@Override
	public FooterComponent getComponent(String id) {
		return footerComponentRepository.getOne(id);
	}

}
