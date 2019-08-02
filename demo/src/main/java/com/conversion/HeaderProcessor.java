package com.conversion;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.spi.Synchronization;
import org.apache.camel.spi.UnitOfWork;

public class HeaderProcessor  implements Processor

{
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		exchange.getIn().setHeader("yoo", "foo1");
	}

}
