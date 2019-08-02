package com.example.demo;

import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.MDC;

public class SimpleRouteBuilders extends RouteBuilder {

	HashMap h = new HashMap();
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:a").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				
				h.put("vishal", "singh");
				MDC.put("custom.id", "MDC-1");
				MDC.put("camel.breadcrumbId", "APP-1");
				
				System.out.println("procesor method"+h.get("vishal"));
			}

		})

				/*
				 * .log(">> MDC : logger called in Route A "+ MDC.get("custom.id"))
				 * .log(LoggingLevel.INFO, "logger called in Route ABCD: " +
				 * MDC.get("custom.id"))
				 */ .to("direct:b");
		System.out.println("sysou value is " + MDC.get("custom.id"));
		from("direct:b").routeId("direct-b")
				.log(">> MDC : logger called in Route B" + MDC.get("custom.id") + "," + h.get("vishal"));

	}

}