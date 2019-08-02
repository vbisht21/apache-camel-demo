package com.routing;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ChoiceProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		com.routing.Order order=exchange.getIn().getBody(com.routing.Order.class);
			
		
		
		exchange.getIn().setBody(order);
	}

}
