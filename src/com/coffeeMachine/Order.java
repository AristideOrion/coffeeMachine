package com.coffeeMachine;

public class Order {
private String drink;
private String numberSugar;
private String stick;
private String message;

	public Order() 
	{
	
	}
	public Order(String drink, String numberSugar, String stick,String message) 
	{
	super();
	this.drink = drink;
	this.numberSugar = numberSugar;
	this.stick = stick;
	this.message=message;
	}
	

	public String getDrink() {
		return drink;
	}

	private void setDrink(String drink) {
		this.drink = drink;
	}

	public String getNumberSugar() {
		return numberSugar;
	}

	private void setNumberSugar(String numberSugar) {
		this.numberSugar = numberSugar;
	}

	public String getMessage() {
		return message;
	}
	private void setMessage(String message) {
		this.message = message;
	}
	public String getStick() {
		return stick;
	}

	private void setStick(String stick) {
		this.stick = stick;
	}
	
	
}
