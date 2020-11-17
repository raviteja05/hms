package com.hms.app.components;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HeroBannerComponent extends Component{
	@Column
	private String bannerHeading;
	@Column
	private String bannerSubHeading;
	@Column
	private String buttonText;
	@Column
	private String buttonURL;
	@Column
	private String imageURL;
	public String getBannerHeading() {
		return bannerHeading;
	}
	public void setBannerHeading(String bannerHeading) {
		this.bannerHeading = bannerHeading;
	}
	public String getBannerSubHeading() {
		return bannerSubHeading;
	}
	public void setBannerSubHeading(String bannerSubHeading) {
		this.bannerSubHeading = bannerSubHeading;
	}
	public String getButtonText() {
		return buttonText;
	}
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}
	public String getButtonURL() {
		return buttonURL;
	}
	public void setButtonURL(String buttonURL) {
		this.buttonURL = buttonURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	

	

}
