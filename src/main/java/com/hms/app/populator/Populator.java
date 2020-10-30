package com.hms.app.populator;

public interface Populator<SOURCE,TARGET> {
	
	void populate(SOURCE source,TARGET target);

}
