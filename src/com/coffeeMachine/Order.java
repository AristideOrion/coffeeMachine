package com.coffeeMachine;

public class Order {
private String drink;
private String numberSugar;
private String stick;
private String message;

	public Order() 
	{
	
	}
	
	public Order(String message) 
	{
	super();
	this.message=message;
	}
	
	public Order(String drink, String numberSugar, String stick) 
	{
	super();
	this.drink = drink;
	this.numberSugar = numberSugar;
	this.stick = stick;
	}
	

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getNumberSugar() {
		return numberSugar;
	}

	public void setNumberSugar(String numberSugar) {
		this.numberSugar = numberSugar;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStick() {
		return stick;
	}

	public void setStick(String stick) {
		this.stick = stick;
	}
	public String getInstructionForWithSugarStickDrinkMaker()
	{
		return this.getDrink()+":"+this.getNumberSugar()+":"+this.getStick();
		
	}
	public String getInstructionForWithMessageForDrinkMaker()
	{
		return "M:"+this.message;
	}
	
	public String getInstructionForWithoutSugarDrinkMaker()
	{
		return this.getDrink()+"::";
		
	}
	
	
	
}
