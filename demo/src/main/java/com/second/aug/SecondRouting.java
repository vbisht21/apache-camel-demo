package com.second.aug;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

import com.routing.ChoiceProcessor;
import com.routing.Order;

public class SecondRouting
{
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

				from("file:src/main/data/in?fileName=bata.txt&noop=true")/*
																			 * .log("reading ${body}").
																			 * 
																			 * unmarshal(xmlDataFormat).process(new
																			 * ChoiceProcessor()).marshal(
																			 * jsonDataFormat)
																			 */
					  .to("file:src/main/data/out/uk");
			
		
		}
	});

	context.start();
	Thread.sleep(50000);
}

}

