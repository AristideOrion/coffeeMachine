package com.coffeeMachine;

public class Orange extends Drink {
	
	public Orange()
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
		this.codeMachine="O";
	}

	@Override
	public String getCodeMachine() {
		// TODO Auto-generated method stub
		return this.codeMachine;
	}

}
