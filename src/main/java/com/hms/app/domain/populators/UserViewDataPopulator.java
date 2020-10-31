package com.hms.app.domain.populators;

import org.springframework.stereotype.Component;

import com.hms.app.domain.models.User;
import com.hms.app.domain.viewdata.UserViewData;
import com.hms.app.populator.Populator;
@Component
public class UserViewDataPopulator implements Populator<User,UserViewData>{

	@Override
	public void populate(User source, UserViewData target) {
		target.setEmail(source.getEmail());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setAddress(source.getAddress());
		
	}

}
