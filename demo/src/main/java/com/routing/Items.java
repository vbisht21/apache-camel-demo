package com.routing;

public class Items {

	private String vegetables;
	private String fruits;
	public Items(String vegetables, String fruits) {
		super();
		this.vegetables = vegetables;
		this.fruits = fruits;
	}
	public String getVegetables() {
		return vegetables;
	}
	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}
	public String getFruits() {
		return fruits;
	}
	public void setFruits(String fruits) {
		this.fruits = fruits;
	}
	/*
	 * @Override public String toString() { return "Items [vegetables=" + vegetables
	 * + ", fruits=" + fruits + "]"; }
	 */
	public Items() {
		super();
	}
	
	
}
