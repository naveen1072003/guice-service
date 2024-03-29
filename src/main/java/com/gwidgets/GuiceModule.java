package com.gwidgets;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.gwidgets.dao.DBConfig;
import com.gwidgets.service.AnotherService;
import com.gwidgets.service.SimpleService;
import com.gwidgets.service.impl.AnotherServiceImpl;
import com.gwidgets.service.impl.SimpleServiceImpl;

public class GuiceModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(DBConfig.class).in(Scopes.SINGLETON);
		bind(SimpleService.class).to(SimpleServiceImpl.class);
		bind(AnotherService.class).to(AnotherServiceImpl.class);
	}
}