package com.example.demo;

import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.MDC;

public class MyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		com.example.demo.User employee = exchange.getIn().getBody(com.example.demo.User.class);
			
			exchange.getIn().setBody(employee);
		}

	
	

}
