package com.coffeeMachine;

public class Coffee extends Drink implements ExtraHot{

	
	private boolean hotDrink;
	
	public  Coffee() //NOSONAR
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
	@Override
	public boolean extraHot() {
		// TODO Auto-generated method stub
		return hotDrink;
	}
	
	public void setDrinkHot()
	{
		hotDrink=true;
		this.codeMachine=this.getCodeMachine()+"h";
	}

}
