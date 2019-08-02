package com.example.demo;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				DemoApplication.class, args);
	//	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		/*
		 * connectionFactory.setBrokerURL("tcp://localhost:61616");
		 * connectionFactory.setUserName("admin");
		 * connectionFactory.setPassword("admin");
		 */
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		jms.convertAndSend("javafirstqueue", "test message");
		
	}
}