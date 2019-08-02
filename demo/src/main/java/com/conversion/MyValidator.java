package com.conversion;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ValidationException;

public class MyValidator implements Processor {
	public void process(Exchange exchange) throws Exception {
		Object value = exchange.getIn().getHeader("yoo");
		if (value != null && !value.equals("foo")) {
			throw new ValidationException(exchange, "The foo header does not equal bar! Was: " + value);
		}
	}
}
