package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class BreadCrumb {

	public static void main(String[] args) {
		SimpleRouteBuilders routeBuilder = new SimpleRouteBuilders();
		CamelContext ctx = new DefaultCamelContext();
		try {
			ctx.addRoutes(routeBuilder);
			ctx.setUseMDCLogging(true);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}