package com.hms.app.components.services;

public interface ComponentService<T> {
	
	void createComponent(T component);
	T getComponent(String id);

}
