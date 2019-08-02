package com.example.demo.splitter;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SplitAgreegator implements AggregationStrategy  {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		
		if(oldExchange==null)
		{
			return oldExchange;
		}
		
	  else {
         String newBody =
                 oldExchange.getIn().getBody(String.class)
                         + newExchange.getIn().getBody(String.class);
         oldExchange.getIn().setBody( newBody, String.class );
         return oldExchange;
     }
		
	}

}
