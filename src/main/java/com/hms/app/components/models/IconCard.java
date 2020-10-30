package com.hms.app.components.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class IconCard {
	@Id
	private String id;
	@Column
	private String iconName;
	@Column
	private String heading;
	@Column
	private String description;
	@OneToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	private NavigationLink cardLink;
	@OneToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	private NavigationLink buttonLink;
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
	public NavigationLink getCardLink() {
		return cardLink;
	}
	public void setCardLink(NavigationLink cardLink) {
		this.cardLink = cardLink;
	}
	public NavigationLink getButtonLink() {
		return buttonLink;
	}
	public void setButtonLink(NavigationLink buttonLink) {
		this.buttonLink = buttonLink;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
