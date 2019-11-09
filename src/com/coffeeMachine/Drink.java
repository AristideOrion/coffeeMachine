package com.coffeeMachine;

public abstract class Drink {
	protected double price;
	protected String codeMachine;
	
	protected abstract void setPrice();
	public abstract Double getPrice();
	protected abstract void setCodeMachine();
	public abstract String getCodeMachine();

}
