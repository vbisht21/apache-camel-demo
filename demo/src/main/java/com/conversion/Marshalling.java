package com.conversion;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Marshalling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		com.example.demo.User user = new com.example.demo.User();
		user.setId(1);
		user.setName("vishal");
		user.setAge(26);
		try {

			
			/*
			 * JAXBContext jaxbContext =
			 * JAXBContext.newInstance(com.example.demo.User.class); Marshaller
			 * jaxbMarshaller = jaxbContext.createMarshaller(); jaxbMarshaller.marshal(user,
			 * System.out);
			 */
			 

			
			
			  JAXBContext jaxbContext =
			  JAXBContext.newInstance(com.example.demo.User.class); File file = new
			  File("C:/Users/vb00618384/Downloads/demo/src/main/data/in/xml/data.xml");
			  Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
			  com.example.demo.User userunmarshal = (com.example.demo.User)
			  jaxbUnMarshaller.unmarshal(file); System.out.println(user);
			 

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
