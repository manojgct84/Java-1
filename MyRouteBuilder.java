package com.bac.rds.cmx.spring;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyRouteBuilder extends AbstractRouteBuilder {
	@Override
	public void configureRoutes() {
		// Access us using http://localhost:8080/camel/hello
		from("servlet:///hello").transform().constant("Hello from Camel!").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				throw new ArrayIndexOutOfBoundsException();
				
			}
		});

		// Trigger run right after startup. No Servlet request required.
		from("timer://foo?fixedRate=true&period=10s").log("Camel timer triggered.");
	}
}