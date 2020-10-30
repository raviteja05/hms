package com.hms.app.utils;


import com.hms.app.components.viewdata.FooterViewData;
import com.hms.app.components.viewdata.HeroBannerViewData;
import com.hms.app.components.viewdata.IconCardContainerViewData;
import com.hms.app.components.viewdata.NavigationViewData;

public class AppObjectFactory {
	
	
	public Object createViewDataObject(String componentName) {		
		switch(componentName) {
		case "navigation":
			return  new NavigationViewData();		
		case "footer":
			return new FooterViewData();
		case "herobanner":
			return new HeroBannerViewData();
		case "iconcardcontainer":
			return new IconCardContainerViewData();
		}
		
		return null;
		
	}

	
}
