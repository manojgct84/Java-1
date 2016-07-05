package com.bac.rds.cmx.spring;

public class FindCustomerRouter extends AbstractRouteBuilder {
	@Override
	public void configureRoutes() {
		// Access us using http://localhost:8080/camel/hello
		from("servlet:///custmerlst").transform().constant("Camel found ");

		// Trigger run right after startup. No Servlet request required.
		from("timer://foo1?fixedRate=true&period=10s").log("Camel timer triggered.");
	}
}