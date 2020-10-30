package com.hms.app.data.setup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.common.reflect.TypeToken;
import com.hms.app.components.FooterComponent;
import com.hms.app.components.IconCardContainerComponent;
import com.hms.app.components.NavigationBarComponent;
import com.hms.app.components.models.IconCard;
import com.hms.app.components.models.services.IconCardService;
import com.hms.app.components.services.IconCardContainerComponentService;
import com.hms.app.pages.models.Page;
import com.hms.app.pages.services.PageService;
import com.hms.app.utils.JsonUtils;
@Component
public class DashBoardPageDataHandler implements DataHandler {
	@Resource
	private JsonUtils jsonUtils;
	
	@Resource
	private PageService pageService;
	
	@Resource
	private IconCardContainerComponentService iconCardContainerComponentService;
	
	@Resource
	private IconCardService iconCardService;
	
	@Override
	public void setUp() {
		IconCardContainerComponent patientIconCardContainerComponent=null;
		IconCardContainerComponent doctorIconCardContainerComponent=null;
		IconCardContainerComponent adminIconCardContainerComponent=null;
		List<IconCard> patientIconCards=null;
		List<IconCard> doctorIconCards=null;
		List<IconCard> adminIconCards=null;
		Page patientDashBoardPage=new Page();
		Page doctorDashBoardPage=new Page();
		Page adminDashBoardPage=new Page();
		NavigationBarComponent navBarComponentData = null;
		FooterComponent footerComponentData = null;
		
		try {
			Type iconListType=new TypeToken<List<IconCard>>() {}.getType();
			patientIconCards=(List<IconCard>)jsonUtils.parseJsonList("/cms-data/patient-dashboard-cards.json", patientIconCards, iconListType);
			doctorIconCards=(List<IconCard>)jsonUtils.parseJsonList("/cms-data/doctor-dashboard-cards.json", patientIconCards, iconListType);
			adminIconCards=(List<IconCard>)jsonUtils.parseJsonList("/cms-data/admin-dashboard-cards.json", patientIconCards, iconListType);
			patientIconCardContainerComponent=(IconCardContainerComponent) jsonUtils.parseJson("/cms-data/patient-dashboard.json", patientIconCardContainerComponent, IconCardContainerComponent.class);
			doctorIconCardContainerComponent=(IconCardContainerComponent) jsonUtils.parseJson("/cms-data/doctor-dashboard.json", doctorIconCardContainerComponent, IconCardContainerComponent.class);
			adminIconCardContainerComponent=(IconCardContainerComponent) jsonUtils.parseJson("/cms-data/admin-dashboard.json", adminIconCardContainerComponent, IconCardContainerComponent.class);
			navBarComponentData=(NavigationBarComponent) jsonUtils.parseJson("/cms-data/navbar.json", navBarComponentData, NavigationBarComponent.class);
			footerComponentData=(FooterComponent) jsonUtils.parseJson("/cms-data/footer.json", footerComponentData, FooterComponent.class);
			iconCardService.createComponents(patientIconCards);
			iconCardService.createComponents(doctorIconCards);
			iconCardService.createComponents(adminIconCards);
			
			iconCardContainerComponentService.createComponent(patientIconCardContainerComponent);
			iconCardContainerComponentService.createComponent(doctorIconCardContainerComponent);
			iconCardContainerComponentService.createComponent(adminIconCardContainerComponent);
			
			patientDashBoardPage.setPageId("patient-dashboard");
			doctorDashBoardPage.setPageId("doctor-dashboard");
			adminDashBoardPage.setPageId("admin-dashboard");
			
			patientDashBoardPage.setComponents(Arrays.asList(navBarComponentData,patientIconCardContainerComponent,footerComponentData));
			doctorDashBoardPage.setComponents(Arrays.asList(navBarComponentData,doctorIconCardContainerComponent,footerComponentData));
			adminDashBoardPage.setComponents(Arrays.asList(navBarComponentData,adminIconCardContainerComponent,footerComponentData));
			
			List<Page> pages=new ArrayList<>();
			pages.add(adminDashBoardPage);
			pages.add(doctorDashBoardPage);
			pages.add(patientDashBoardPage);
			pageService.createPages(pages);
			
			} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
