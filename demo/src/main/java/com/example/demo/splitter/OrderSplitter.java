package com.example.demo.splitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class OrderSplitter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("initializing camel context");

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				
				from("direct:resource")
				.split(xpath("//order[@product='electronics']/items"))
				//.log("message logged is ${body}").aggregate(new SplitAgreegator()).completionTimeout(150000)
				.to("file:src/main/data/out/others");
			}

		}

		);
		context.start();
		ProducerTemplate template = context.createProducerTemplate();
		InputStream orderxml = new FileInputStream("src/main/data/in/order.xml");
		template.sendBody("direct:resource", orderxml);
		context.stop();
	}

}
