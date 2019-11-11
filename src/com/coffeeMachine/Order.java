package com.coffeeMachine;

public class Order {
private Drink drink;
private String numberSugar;
private String stick;
private String message;
private String codeProtocol=null;
	
	public Order() 
	{
	
	}
	
	public Order(String message) 
	{
	super();
	this.message=message;
	}
	
	public Order(Drink drink, String numberSugar, String stick) 
	{
	super();
	this.drink = drink;
	this.numberSugar = numberSugar;
	this.stick = stick;
	}
	
	public Order(Drink drink) 
	{
	super();
	this.drink = drink;
	}
	

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
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
		
		try {
			codeProtocol=this.getDrink().getCodeMachine()+":"+this.getNumberSugar()+":"+this.getStick();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return codeProtocol;
		
	}
	public String getInstructionForWithMessageForDrinkMaker()
	{
		try
		{
			codeProtocol="M:"+this.message;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return codeProtocol;
	}
	
	public String getInstructionForWithoutSugarDrinkMaker()
	{
		
		try
		{
			codeProtocol=this.getDrink().getCodeMachine()+"::";
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return codeProtocol;
		
	}
	
	public String getInstructionForOrangeDrinkMaker()

	{
		try
		{
			codeProtocol=this.getDrink().getCodeMachine()+"::";
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return codeProtocol;
	}
	
	
}
