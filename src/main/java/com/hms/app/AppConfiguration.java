package com.hms.app;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hms.app.components.populators.FooterViewDataPopulator;
import com.hms.app.components.populators.HeroBannerViewDataPopulator;
import com.hms.app.components.populators.IconCardContainerViewDataPopulator;
import com.hms.app.components.populators.NavigationViewDataPopulator;
import com.hms.app.components.services.ComponentService;
import com.hms.app.components.services.FooterComponentService;
import com.hms.app.components.services.HeroBannerComponentService;
import com.hms.app.components.services.IconCardContainerComponentService;
import com.hms.app.components.services.NavigationComponentService;
import com.hms.app.populator.Populator;

@Configuration
public class AppConfiguration {
	@Resource
	private NavigationComponentService navigationComponentService;
	
	@Resource 
	private NavigationViewDataPopulator navigationViewDataPopulator;
	
	@Resource
	private FooterComponentService footerComponentService;
	
	@Resource 
	private FooterViewDataPopulator footerViewDataPopulator;
	
	@Resource 
	private HeroBannerComponentService heroBannerComponentService;
	
	@Resource
	private HeroBannerViewDataPopulator heroBannerViewDataPopulator;
	
	@Resource 
	private IconCardContainerViewDataPopulator iconCardContainerViewDataPopulator;
	
	@Resource
	private IconCardContainerComponentService iconCardContainerComponentService;
	
	@Bean
	public Map<String,ComponentService> componentServices(){
		Map<String,ComponentService> services=new HashMap<>();
		services.put("navigation", navigationComponentService);
		services.put("footer", footerComponentService);
		services.put("herobanner", heroBannerComponentService);
		services.put("iconcardcontainer", iconCardContainerComponentService);
		return services;
		
	}
	
	@Bean
	public Map<String,Populator> componentPopulators(){
		Map<String,Populator> populators=new HashMap<>();
		populators.put("navigation", navigationViewDataPopulator);
		populators.put("footer", footerViewDataPopulator);
		populators.put("herobanner", heroBannerViewDataPopulator);
		populators.put("iconcardcontainer", iconCardContainerViewDataPopulator);
		return populators;
		
	}

	

}
