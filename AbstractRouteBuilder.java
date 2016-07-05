package com.bac.rds.cmx.spring;

import org.apache.camel.builder.RouteBuilder;

public abstract class AbstractRouteBuilder extends RouteBuilder {

	private ResponseException resposeException;

	@Override
	public void configure() throws Exception {
		exceptionRoute();
		configureRoutes();
	}

	public abstract void configureRoutes();

	private void exceptionRoute() {

		onException(Exception.class).handled(true).beanRef("responseException");

	}
}
