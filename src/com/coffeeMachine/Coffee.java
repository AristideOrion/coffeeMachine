package com.coffeeMachine;

public class Coffee extends Drink {

	
	public  Coffee()
	{
		this.setPrice();
		this.setCodeMachine();
	}
	@Override
	protected void setPrice() {
		this.price=0.6;

	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	protected void setCodeMachine() {
		this.codeMachine="C";
	}

	@Override
	public String getCodeMachine() {
		return this.codeMachine;
	}

}
