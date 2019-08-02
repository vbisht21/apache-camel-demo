package com.conversion;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class XmlToBeanAndBackBean  implements Serializable {

	public User transformXmlObject(User user){
		User returnPojo = user;
        returnPojo.setName("merkur");
        return returnPojo;
    }

}
