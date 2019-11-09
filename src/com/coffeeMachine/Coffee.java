package com.coffeeMachine;

public class Coffee extends Drink {

	
	public  Coffee()
	{
		
	}
	@Override
	protected void setPrice() {
		this.price=0.4;

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
		return this.getCodeMachine();
	}

}
