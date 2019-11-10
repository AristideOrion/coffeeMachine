package com.coffeeMachine;

public class Tea extends Drink {
	public Tea()
	{
		this.setPrice();
		this.setCodeMachine();
	}

	@Override
	protected void setPrice() {
		// TODO Auto-generated method stub
		this.price=0.4;

	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	protected void setCodeMachine() {
		// TODO Auto-generated method stub
		this.codeMachine="T";

	}

	@Override
	public String getCodeMachine() {
		// TODO Auto-generated method stub
		return this.codeMachine;
	}

}
