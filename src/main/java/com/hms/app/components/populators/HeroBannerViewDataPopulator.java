package com.hms.app.components.populators;

import org.springframework.stereotype.Component;

import com.hms.app.components.HeroBannerComponent;
import com.hms.app.components.viewdata.HeroBannerViewData;
import com.hms.app.populator.Populator;
@Component
public class HeroBannerViewDataPopulator implements Populator<HeroBannerComponent,HeroBannerViewData>{

	@Override
	public void populate(HeroBannerComponent source, HeroBannerViewData target) {
		target.setBannerHeading(source.getBannerHeading());
		target.setBannerSubHeading(source.getBannerSubHeading());
		target.setButtonText(source.getButtonText());
		target.setButtonURL(source.getButtonURL());
		target.setImageURL(source.getImageURL());
		
	}

}
