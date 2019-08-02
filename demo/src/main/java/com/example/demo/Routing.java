package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Routing {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CamelContext c=new DefaultCamelContext();
		c.start();
		c.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("timer://mytimer?period=1000")
		           .log("Hello World!");
				
			
			}
			
		
		
	});

}
}