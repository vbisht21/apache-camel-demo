package com.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyCamelProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		User user = new User();
		user.setId(1);
		user.setName("vishal");
		user.setAge(26);
		
		 JAXBContext jaxbContext = JAXBContext.newInstance(User.class); 
		  Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); 
		 
		  exchange.getIn().setBody(jaxbMarshaller);
		
		
	}

}
