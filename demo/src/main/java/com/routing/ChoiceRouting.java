package com.routing;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

public class ChoiceRouting {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		CamelContext context = new DefaultCamelContext();
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Order.class);
		xmlDataFormat.setContext(con);
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Order.class);
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub

				from("file:src/main/data/in?noop=true?")
						
						/*
						 * .split(xpath("orders/Order")) .log(" splitted msg ${body}")
						 * 
						 * 
						 * .choice()
						 * 
						 * .when(xpath("Order/country='UK'"))
						 */
						  .unmarshal(xmlDataFormat).process(new ChoiceProcessor()).marshal(jsonDataFormat)
						  .to("file:src/main/data/out/uk")
				
				/*
				 * .when(xpath("Order/country='USA'"))
				 * .unmarshal(xmlDataFormat).convertBodyTo(Order.class).marshal(jsonDataFormat)
				 * .to("file:src/main/data/out/usa")
				 */
				 ;
				/*
				 * otherwise()
				 * 
				 * 
				 * .unmarshal(xmlDataFormat).convertBodyTo(Order.class).marshal(jsonDataFormat)
				 * .log("${body}") .to("file:src/main/data/out/others");
				 */
			}
		});

		context.start();
		Thread.sleep(50000);
	}

}
