package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.MDC;

public class MakeItWork {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CamelContext c=new DefaultCamelContext();
		c.start();
		c.setUseMDCLogging(true);
		 //MDC.put("custom.id", "APP-1");
		c.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:src/main/data/in/csv?noop=true").routeId("direct-a")
			    .process(new Processor() {
			       
					@Override
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						 MDC.put("custom.id", "MDC-1");
				           
				            System.out.print("MDC value of test"+MDC.get("custom.id"));
					}
			    }).to("direct:b")
			    .log(">> MDC : logger called in Route A "+MDC.get("custom.id"));

				from("direct:b").routeId("direct-b")
				    .log(">> MDC : logger called in Route B");
			}
		});
	}

}
