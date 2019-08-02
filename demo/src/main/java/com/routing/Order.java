package com.routing;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.camel.dataformat.bindy.annotation.OneToMany;

@XmlRootElement(name="Order")
@XmlType(name = "", propOrder = {"items","country","amount","number"})
public class Order {

	private int number;
	private String country;
	private int amount;
	
	
	public Order() {
		super();
	}
	
	private List<Items> items;
	

	
	public Order(int number, String country, int amount, List<Items> items) {
		super();
		this.number = number;
		this.country = country;
		this.amount = amount;
		this.items = items;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", country=" + country + ", amount=" + amount + ", items=" + items + "]";
	}

	
	
	
	
}
