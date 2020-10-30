package com.hms.app.components.viewdata;

import java.util.ArrayList;
import java.util.List;

public class IconCardContainerViewData {
	private String heading;
	private List<IconCardViewData> contentCards=new ArrayList<>();
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public List<IconCardViewData> getContentCards() {
		return contentCards;
	}
	public void setContentCards(List<IconCardViewData> contentCards) {
		this.contentCards = contentCards;
	}
	
	

}
