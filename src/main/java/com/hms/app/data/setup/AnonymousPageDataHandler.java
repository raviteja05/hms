package com.hms.app.data.setup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.common.reflect.TypeToken;
import com.hms.app.components.FooterComponent;
import com.hms.app.components.HeroBannerComponent;
import com.hms.app.components.IconCardContainerComponent;
import com.hms.app.components.NavigationBarComponent;
import com.hms.app.components.models.IconCard;
import com.hms.app.components.models.services.IconCardService;
import com.hms.app.components.services.HeroBannerComponentService;
import com.hms.app.components.services.IconCardContainerComponentService;
import com.hms.app.pages.models.Page;
import com.hms.app.pages.services.PageService;
import com.hms.app.utils.JsonUtils;
@Component
public class AnonymousPageDataHandler implements DataHandler {
	@Resource
	private JsonUtils jsonUtils;
	@Resource
	private PageService pageService;
	
	@Resource
	private HeroBannerComponentService heroBannerComponentService;
	
	@Resource
	private IconCardContainerComponentService iconCardContainerComponentService;
	
	@Resource
	private IconCardService iconCardService;

	@Override
	public void setUp() {
		NavigationBarComponent navBarComponentData = null;
		FooterComponent footerComponentData = null;
		HeroBannerComponent heroBannerViewData = null;
		IconCardContainerComponent iconCardContainerComponent=null;
		List<IconCard> iconCards=null;
		Page homePage=new Page();
		List<Page> anonymousPages=null;
		
		try {
			Type iconListType=new TypeToken<List<IconCard>>() {}.getType();
			iconCards=(List<IconCard>)jsonUtils.parseJsonList("/cms-data/homeIconCards.json", iconCards, iconListType);
			Type pageType=new TypeToken<List<Page>>() {}.getType();
			anonymousPages=(List<Page>)jsonUtils.parseJsonList("/cms-data/pages.json", anonymousPages, pageType);
			navBarComponentData=(NavigationBarComponent) jsonUtils.parseJson("/cms-data/navbar.json", navBarComponentData, NavigationBarComponent.class);
			footerComponentData=(FooterComponent) jsonUtils.parseJson("/cms-data/footer.json", footerComponentData, FooterComponent.class);
			heroBannerViewData=(HeroBannerComponent) jsonUtils.parseJson("/cms-data/herobanner.json", heroBannerViewData, HeroBannerComponent.class);
			iconCardContainerComponent=(IconCardContainerComponent) jsonUtils.parseJson("/cms-data/homeiconcardcontainer.json", iconCardContainerComponent, IconCardContainerComponent.class);
			iconCardService.createComponents(iconCards);
			heroBannerComponentService.createComponent(heroBannerViewData);
			iconCardContainerComponentService.createComponent(iconCardContainerComponent);
			
			homePage = new Page();
			homePage.setPageId("home");
			homePage.setComponents(Arrays.asList(navBarComponentData, heroBannerViewData,iconCardContainerComponent, footerComponentData));
			
			for(Page page:anonymousPages) {
				page.setComponents(Arrays.asList(navBarComponentData, footerComponentData));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		pageService.createPage(homePage);
		pageService.createPages(anonymousPages);
		
	}

}
