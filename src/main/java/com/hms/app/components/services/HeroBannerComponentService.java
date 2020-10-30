package com.hms.app.components.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.HeroBannerComponent;
import com.hms.app.components.repositories.HeroBannerComponentRepository;
@Service
public class HeroBannerComponentService implements ComponentService<HeroBannerComponent>{
	@Resource
	private HeroBannerComponentRepository heroBannerComponentRepository;
	@Override
	public void createComponent(HeroBannerComponent component) {
		heroBannerComponentRepository.save(component);
	}

	@Override
	public HeroBannerComponent getComponent(String id) {
		
		return heroBannerComponentRepository.getOne(id);
	}

}
