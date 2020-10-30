package com.hms.app.data.setup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.reflect.TypeToken;
import com.hms.app.components.FooterComponent;
import com.hms.app.components.HeroBannerComponent;
import com.hms.app.components.NavigationBarComponent;
import com.hms.app.components.models.FooterSection;
import com.hms.app.components.models.NavigationBar;
import com.hms.app.components.models.NavigationLink;
import com.hms.app.components.models.services.FooterSectionService;
import com.hms.app.components.models.services.NavigationBarService;
import com.hms.app.components.models.services.NavigationLinkService;
import com.hms.app.components.populators.NavigationViewDataPopulator;
import com.hms.app.components.services.FooterComponentService;
import com.hms.app.components.services.HeroBannerComponentService;
import com.hms.app.components.services.NavigationComponentService;
import com.hms.app.pages.models.Page;
import com.hms.app.utils.JsonUtils;
@Component
public class SiteWideComponentsDataHandler implements DataHandler {
	@Resource
	private NavigationComponentService navigationComponentService;
	@Resource
	private FooterSectionService footerSectionService;
	@Resource
	private FooterComponentService footerComponentService;

	@Resource
	private HeroBannerComponentService heroBannerComponentService;

	@Resource
	private NavigationViewDataPopulator navigationViewDataPopulator;

	@Resource
	private NavigationBarService navigationBarService;
	@Resource
	private NavigationLinkService navigationLinkService;
	
	@Resource
	private JsonUtils jsonUtils;



	@Override
	public void setUp() {
		List<NavigationLink> navLink = null;
		NavigationBar navBar = null;
		List<FooterSection> footerSections=null;

		NavigationBarComponent navBarComponentData = null;
		FooterComponent footerComponentData = null;
		HeroBannerComponent heroBannerViewData = null;
		
		Page page = null;
		try {
			Type navLinkListType=new TypeToken<List<NavigationLink>>() {}.getType();
			navLink=(List<NavigationLink>) jsonUtils.parseJsonList("/cms-data/navlinks.json", navLink, navLinkListType);

			navBar=(NavigationBar) jsonUtils.parseJson("/cms-data/nav.json", navBar, NavigationBar.class);
			navBarComponentData=(NavigationBarComponent) jsonUtils.parseJson("/cms-data/navbar.json", navBarComponentData, NavigationBarComponent.class);
			Type footerListType=new TypeToken<List<FooterSection>>() {}.getType();
			footerSections=(List<FooterSection>) jsonUtils.parseJsonList("/cms-data/footersections.json", footerSections, footerListType);
			footerComponentData=(FooterComponent) jsonUtils.parseJson("/cms-data/footer.json", footerComponentData, FooterComponent.class);
			heroBannerViewData=(HeroBannerComponent) jsonUtils.parseJson("/cms-data/herobanner.json", heroBannerViewData, HeroBannerComponent.class);

			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		navigationLinkService.createComponents(navLink);
		navigationBarService.createComponent(navBar);

		navigationComponentService.createComponent(navBarComponentData);
		footerSectionService.createComponents(footerSections);
		footerComponentService.createComponent(footerComponentData);

		
		
	}

}
