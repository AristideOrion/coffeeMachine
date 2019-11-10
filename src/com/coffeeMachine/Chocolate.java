package com.coffeeMachine;

public class Chocolate extends Drink {
	
	public Chocolate() {
		this.setPrice();
		this.setCodeMachine();
	}

	@Override
	protected void setPrice() {
		// TODO Auto-generated method stub
		this.price=0.5;

	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	protected void setCodeMachine() {
		// TODO Auto-generated method stub
		this.codeMachine="H";

	}

	@Override
	public String getCodeMachine() {
		// TODO Auto-generated method stub
		return this.codeMachine;
	}

}
