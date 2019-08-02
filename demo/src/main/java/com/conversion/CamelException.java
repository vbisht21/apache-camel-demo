package com.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

import com.example.demo.MyProcessor;
@XmlSeeAlso({com.example.demo.User.class})
public class CamelException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CamelContext context = new DefaultCamelContext();

		//JAXBContext jaxb = JAXBContext.newInstance(com.example.demo.User.class);
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(com.example.demo.User.class);
		xmlDataFormat.setContext(con);
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(com.example.demo.User.class);
		//JsonDataFormat j=new JsonDataFormat();
		/* Unmarshaller jaxbUnMarshaller = jaxb.createUnmarshaller(); */
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub

				from("file:src/main/data/in/xml?noop=true")
				.convertBodyTo(String.class)
				//.  unmarshal().serialization().convertBodyTo(String.class)
				.unmarshal().jacksonxml()
				//.bean(XmlToBeanAndBackBean.class) //.jacksonxml()
				//.process(new MyProcessor())
				//.marshal(jsonDataFormat)
				//. to("dataformat:xmlDataFormat:unmarshal?contextPath=com.example.demo.User")
				
				 
				//.convertBodyTo(String.class)
						/*
						 * .process(new MyCamelProcessor()) .marshal(context.)
						 */
				.to("activemq:testQueue");

				/*
				 * onException(ValidationException.class) .handled(true)
				 * .log("validation is failed");
				 */
				/* errorHandler(deadLetterChannel("direct:something")); */

				/*
				 * from("direct:start") .doTry() .process(new MyValidator())
				 * .log("validation successfull") .doCatch(ValidationException.class)
				 * .handled(false) .log("validation failed");
				 */

				/*
				 * from("direct:start") .process(new MyValidator()) .to("direct:end");
				 * 
				 * from("direct:end") .log("check in header { in.header.foo}");
				 * 
				 * from("direct:something").log("deadletter");
				 */

			}
			
			
			
		});
		
		context.start();
		Thread.sleep(50000);
		
		
		
		/*
		 * context.start(); ProducerTemplate produce = context.createProducerTemplate();
		 * produce.sendBody("direct:start", new com.example.demo.User());
		 */
		// produce.send("direct:start", new HeaderProcessor());
		 
		// sendBodyAndHeader("Hello iam james bond", "foo", "james bond 007")

	}

}
