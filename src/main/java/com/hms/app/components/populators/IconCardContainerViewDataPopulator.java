package com.hms.app.components.populators;

import org.springframework.stereotype.Component;

import com.hms.app.components.IconCardContainerComponent;
import com.hms.app.components.models.IconCard;
import com.hms.app.components.models.NavigationLink;
import com.hms.app.components.viewdata.IconCardContainerViewData;
import com.hms.app.components.viewdata.IconCardViewData;
import com.hms.app.components.viewdata.NavigationLinkViewData;
import com.hms.app.populator.Populator;

@Component
public class IconCardContainerViewDataPopulator
		implements Populator<IconCardContainerComponent, IconCardContainerViewData> {

	@Override
	public void populate(IconCardContainerComponent source, IconCardContainerViewData target) {
		target.setHeading(source.getHeading());

		source.getContentCards().forEach(contentCard -> populateContentCard(contentCard, target));

	}

	private void populateContentCard(IconCard contentCard, IconCardContainerViewData target) {
		IconCardViewData iconCardViewData = new IconCardViewData();
		iconCardViewData.setHeading(contentCard.getHeading());
		iconCardViewData.setDescription(contentCard.getDescription());
		iconCardViewData.setHeading(contentCard.getHeading());
		iconCardViewData.setIconName(contentCard.getIconName());
		iconCardViewData.setButtonLink(getNavLink(contentCard.getButtonLink()));
		iconCardViewData.setCardLink(getNavLink(contentCard.getCardLink()));
		target.getContentCards().add(iconCardViewData);
	}

	private NavigationLinkViewData getNavLink(NavigationLink link) {
		NavigationLinkViewData navigationLinkViewData = new NavigationLinkViewData();
		if (link != null) {
			
			navigationLinkViewData.setName(link.getLinkText());
			navigationLinkViewData.setUrl(link.getUrl());
		}
		return navigationLinkViewData;
	}

}
