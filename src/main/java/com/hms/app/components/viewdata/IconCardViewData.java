package com.hms.app.components.viewdata;

public class IconCardViewData {
	private String iconName;
	private String heading;
	private String description;
	private NavigationLinkViewData cardLink=new NavigationLinkViewData();
	private NavigationLinkViewData buttonLink=new NavigationLinkViewData();
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public NavigationLinkViewData getCardLink() {
		return cardLink;
	}
	public void setCardLink(NavigationLinkViewData cardLink) {
		this.cardLink = cardLink;
	}
	public NavigationLinkViewData getButtonLink() {
		return buttonLink;
	}
	public void setButtonLink(NavigationLinkViewData buttonLink) {
		this.buttonLink = buttonLink;
	}
	

}
