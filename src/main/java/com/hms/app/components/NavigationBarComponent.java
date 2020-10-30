package com.hms.app.components;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.hms.app.components.models.NavigationBar;

@Entity
public class NavigationBarComponent extends Component<NavigationBar> {
	@OneToOne
	@Cascade( value = { CascadeType.SAVE_UPDATE })
	private NavigationBar navigationBar;

	public NavigationBar getNavigationBar() {
		return navigationBar;
	}

	public void setNavigationBar(NavigationBar navigationBar) {
		this.navigationBar = navigationBar;
	}
	
	
}
