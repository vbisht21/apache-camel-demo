package com.example.demo.cbr;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CBRRouteBuilder {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("initializing camel context");

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:src/main/data/in?noop=true").choice()
				.when(xpath("/Order/Country='USA'")).to("file:src/main/data/out/usa")
				.when(xpath("/Order/Country='UK'")).to("file:src/main/data/out/uk")
				.otherwise().to("file:src/main/data/out/others");
				
			}

		});
		context.start();
		 Thread.sleep(3000);
		 context.stop();
	}

}
