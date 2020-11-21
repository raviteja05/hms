package com.hms.app.utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.hms.app.components.viewdata.FooterViewData;
import com.hms.app.components.viewdata.HeroBannerViewData;
import com.hms.app.components.viewdata.IconCardContainerViewData;
import com.hms.app.components.viewdata.NavigationViewData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AppObjectFactoryTest {
	@Test
	public void testCreateNavigationViewDataObject() {
		AppObjectFactory appObjectFactory=new AppObjectFactory();
		Object object=appObjectFactory.createViewDataObject("navigation");
		assertTrue(object instanceof NavigationViewData);
	}
	@Test
	public void testCreateFooterViewDataObject() {
		AppObjectFactory appObjectFactory=new AppObjectFactory();
		Object object=appObjectFactory.createViewDataObject("footer");
		assertTrue(object instanceof FooterViewData);
	}
	@Test
	public void testCreateHeroBannerViewDataObject() {
		AppObjectFactory appObjectFactory=new AppObjectFactory();
		Object object=appObjectFactory.createViewDataObject("herobanner");
		assertTrue(object instanceof HeroBannerViewData);
	}
	@Test
	public void testCreateIconCardContainerViewDataObject() {
		AppObjectFactory appObjectFactory=new AppObjectFactory();
		Object object=appObjectFactory.createViewDataObject("iconcardcontainer");
		assertTrue(object instanceof IconCardContainerViewData);
	}
	
	@Test
	public void testCreateNullObject() {
		AppObjectFactory appObjectFactory=new AppObjectFactory();
		Object object=appObjectFactory.createViewDataObject("random");
		assertTrue(object==null);
	}

}
